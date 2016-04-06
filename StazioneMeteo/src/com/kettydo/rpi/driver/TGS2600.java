package com.kettydo.rpi.driver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kettydo.rpi.driver.MCP3008.MCP3008InputChannels;

public class TGS2600 {

	private static Log log = LogFactory.getLog(TGS2600.class);

	private final MCP3008 adc;
	private static MCP3008InputChannels DEFAULT_ADC_CHANNEL = MCP3008.MCP3008InputChannels.CH0;

	// Value of the load resistance Rl as specified in
	// http://www.figarosensor.com/products/2600pdf.pdf (0.45K Ohm min)
	private static final int DEFAULT_LOAD_RESISTENCE = 22000;

	// http://www.produktinfo.conrad.com/datenblaetter/175000-199999/183304-da-01-en-GASSENSOR_FIGARO_TGS2600_B00.pdf
	private static final float DEFAULT_CLEAN_AIR_RESISTENCE = 32000;

	// Sensor requires Vc of 5V
	private static final int VCC = 5000;

	// Etanolo, butano, idrogeno
	private final float[] C2H5OH_CURVE = { 0.2995093465f, -3.148170562f };
	private final float[] C4H10_CURVE = { 0.3555567714f, -3.337882361f };
	private final float[] H2_CURVE = { 0.3417050674f, -2.887154835f };

	private final int channel;
	private final int loadResistence;

	private float calibration;
	private float referenceHumidity;
	private float referenceTemperature;

	private float cleanAirResistance;

	public TGS2600() {
		this(new MCP3008(), DEFAULT_ADC_CHANNEL, DEFAULT_LOAD_RESISTENCE, DEFAULT_CLEAN_AIR_RESISTENCE);
	}

	public TGS2600(final MCP3008 adc, final MCP3008InputChannels channel) {
		this(adc, channel, DEFAULT_LOAD_RESISTENCE, DEFAULT_CLEAN_AIR_RESISTENCE);
	}

	public TGS2600(final MCP3008 adc, final int loadResistence) {
		this(adc, DEFAULT_ADC_CHANNEL, loadResistence, DEFAULT_CLEAN_AIR_RESISTENCE);
	}

	public TGS2600(final MCP3008 adc, final MCP3008InputChannels channel, final int loadResistence,
			final float cleanAirResistance) {
		this.adc = adc;
		this.channel = channel.ch();
		this.loadResistence = loadResistence;
		this.cleanAirResistance = cleanAirResistance;
	}

	public TGS2600Response read() {
		final TGS2600Response res = new TGS2600Response();

		final float resistance = readCalibratedResistance();

		res.setResistance(resistance);
		res.setC2h5ohPPM(readGasPPM(resistance, C2H5OH_CURVE));
		res.setC4h10PPM(readGasPPM(resistance, C4H10_CURVE));
		res.setH2PPM(readGasPPM(resistance, H2_CURVE));

		return res;
	}

	public void setReferenceHumidity(final float referenceHumidity) {
		this.referenceHumidity = referenceHumidity;

		updateCalibration();
	}

	public void setReferenceTemperature(final float referenceTemperature) {
		this.referenceTemperature = referenceTemperature;

		updateCalibration();
	}

	public void shutdownMCP3008() {
		adc.shutdownMCP3008();
	}

	private float readResistance() {
		final float vOut = adc.readMilliVoltsFromChannel(channel);
		log.debug("MCP3008 measured voltage: " + vOut);

		final float resistance = ((VCC * loadResistence) / vOut) - loadResistence;
		log.debug("Read resistance: " + resistance);

		return resistance;
	}

	private float readCalibratedResistance() {
		final float res = readResistance() * calibration;
		log.debug("Read calibrated resistance: " + res);

		return res;
	}

	private float readGasPPM(final float rs, final float[] curve) {
		// https://github.com/empierre/arduino/blob/f817b9ce5304daec9508e444a4e4046f90fb1f8d/AirQuality-Multiple_Gas_Sensor1_4.ino
		// http://davidegironi.blogspot.fr/2014/01/cheap-co2-meter-using-mq135-sensor-with.html
		// https://www.researchgate.net/publication/269001878_Air_Contaminants_Monitoring_of_Carbon_Monoxide_and_Hydrogen_using_Standalone_Microcontroller_Based_System_for_Passive_Smoker
		final float res = (float) (curve[0] * Math.pow(rs / cleanAirResistance, curve[1]));

		log.debug("Rs: " + rs + "; R0: " + cleanAirResistance);
		log.debug("PPM: " + res);

		return res;
	}

	private void updateCalibration() {
		// http://www.atmos-meas-tech.net/5/1925/2012/amt-5-1925-2012.pdf
		calibration = 0.024f + 0.0072f * referenceHumidity + 0.0246f * referenceTemperature;
	}

}
