package com.kettydo.rpi.driver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kettydo.rpi.driver.MCP3008.MCP3008InputChannels;

public class ML8511 {

	private static Log log = LogFactory.getLog(ML8511.class);

	private MCP3008 adc;
	private static MCP3008InputChannels DEFAULT_ADC_CHANNEL = MCP3008.MCP3008InputChannels.CH1;

	private int channel;

	public ML8511() {
		this(new MCP3008(), DEFAULT_ADC_CHANNEL);
	}

	public ML8511(MCP3008 adc) {
		this(adc, DEFAULT_ADC_CHANNEL);
	}

	public ML8511(MCP3008 adc, MCP3008InputChannels channel) {
		this.adc = adc;
		this.channel = channel.ch();
	}

	public float read() {
		int uvLevel = adc.readMCP3008(channel);
		log.debug("MCP3008 read: " + uvLevel);

		float outputVoltage = adc.readVoltsFromValue(uvLevel);
		float uvIntensity = mapFloat(outputVoltage, 0.99f, 2.9f, 0.0f, 15.0f);

		return uvIntensity;
	}

	public void shutdownMCP3008() {
		adc.shutdownMCP3008();
	}

	private static float mapFloat(float x, float in_min, float in_max, float out_min, float out_max) {
		return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
	}
}
