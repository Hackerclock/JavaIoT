package com.kettydo.rpi.driver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Read an Analog to Digital Converter
 */
public class MCP3008 {

	private static Log log = LogFactory.getLog(MCP3008.class);

	// SPI: Serial Peripheral Interface
	private static Pin spiClk = RaspiPin.GPIO_14; // Pin #23, clock
	private static Pin spiMiso = RaspiPin.GPIO_13; // Pin #21, data in. MISO:
													// Master In Slave Out
	private static Pin spiMosi = RaspiPin.GPIO_12; // Pin #19, data out. MOSI:
													// Master Out Slave In
	private static Pin spiCe0 = RaspiPin.GPIO_10; // Pin #24, Chip Select

	private static final float VCC = 3.3f;

	public enum MCP3008InputChannels {
		CH0(0), CH1(1), CH2(2), CH3(3), CH4(4), CH5(5), CH6(6), CH7(7);

		private int ch;

		MCP3008InputChannels(final int chNum) {
			this.ch = chNum;
		}

		public int ch() {
			return this.ch;
		}
	}

	private static GpioController gpio;

	private static GpioPinDigitalInput misoInput = null;
	private static GpioPinDigitalOutput mosiOutput = null;
	private static GpioPinDigitalOutput clockOutput = null;
	private static GpioPinDigitalOutput chipSelectOutput = null;

	public MCP3008() {
		gpio = GpioFactory.getInstance();
		mosiOutput = gpio.provisionDigitalOutputPin(spiMosi, "MOSI", PinState.LOW);
		clockOutput = gpio.provisionDigitalOutputPin(spiClk, "CLK", PinState.LOW);
		chipSelectOutput = gpio.provisionDigitalOutputPin(spiCe0, "CE0", PinState.LOW);

		misoInput = gpio.provisionDigitalInputPin(spiMiso, "MISO");
	}

	public void shutdownMCP3008() {
		gpio.shutdown();
	}

	public int readMCP3008(final int channel) {
		chipSelectOutput.high();

		clockOutput.low();
		chipSelectOutput.low();

		int adccommand = channel;
		log.debug(
				"1 -       ADCCOMMAND: 0x" + lpad(Integer.toString(adccommand, 16).toUpperCase(), "0", 4) + ", 0&" + lpad(Integer.toString(adccommand, 2).toUpperCase(), "0", 16));
		adccommand |= 0x18; // 0x18: 00011000
		log.debug(
				"2 -       ADCCOMMAND: 0x" + lpad(Integer.toString(adccommand, 16).toUpperCase(), "0", 4) + ", 0&" + lpad(Integer.toString(adccommand, 2).toUpperCase(), "0", 16));
		adccommand <<= 3;
		log.debug(
				"3 -       ADCCOMMAND: 0x" + lpad(Integer.toString(adccommand, 16).toUpperCase(), "0", 4) + ", 0&" + lpad(Integer.toString(adccommand, 2).toUpperCase(), "0", 16));

		// Send 5 bits: 8 - 3. 8 input channels on the MCP3008.
		for (int i = 0; i < 5; i++) {
			log.debug("4 - (i=" + i + ") ADCCOMMAND: 0x" + lpad(Integer.toString(adccommand, 16).toUpperCase(), "0", 4) + ", 0&"
					+ lpad(Integer.toString(adccommand, 2).toUpperCase(), "0", 16));

			if ((adccommand & 0x80) != 0x0) {
				mosiOutput.high();
			} else {
				mosiOutput.low();
			}
			adccommand <<= 1;
			// Clock high and low
			tickOnPin(clockOutput);
		}

		int adcOut = 0;
		// Read in one empty bit, one null bit and 10 ADC bits
		for (int i = 0; i < 12; i++) {
			tickOnPin(clockOutput);
			adcOut <<= 1;

			if (misoInput.isHigh()) {
				// System.out.println(" " + misoInput.getName() + " is high (i:"
				// + i + ")");
				// Shift one bit on the adcOut
				adcOut |= 0x1;
			}
			log.debug("ADCOUT: 0x" + lpad(Integer.toString(adcOut, 16).toUpperCase(), "0", 4) + ", 0&" + lpad(Integer.toString(adcOut, 2).toUpperCase(), "0", 16));
		}
		chipSelectOutput.high();

		// Drop first bit
		adcOut >>= 1;
		return adcOut;
	}

	public float readMilliVoltsFromChannel(final int channel) {
		return readMilliVoltsFromValue(readMCP3008(channel));
	}

	public float readMilliVoltsFromValue(final int readValue) {
		return VCC * 1000 / (1024 - 1) * readValue;
	}

	public float readVoltsFromChannel(final int channel) {
		return readVoltsFromValue(readMCP3008(channel));
	}

	public float readVoltsFromValue(final int readValue) {
		return VCC / (1024 - 1) * readValue;
	}

	private void tickOnPin(final GpioPinDigitalOutput pin) {
		pin.high();
		pin.low();
	}

	private String lpad(final String str, final String with, final int len) {
		String s = str;
		while (s.length() < len) {
			s = with + s;
		}
		return s;
	}
}