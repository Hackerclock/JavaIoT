package com.kettydo.rpi.model;

import com.kettydo.rpi.business.StazioneMeteoDati;
import com.kettydo.rpi.driver.BMP180;
import com.kettydo.rpi.driver.DHT22;
import com.kettydo.rpi.driver.DHT22Response;
import com.kettydo.rpi.driver.MCP3008;
import com.kettydo.rpi.driver.ML8511;
import com.kettydo.rpi.driver.TGS2600;
import com.kettydo.rpi.driver.TGS2600Response;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class StazioneMeteoReader {
	
	private GpioController controller;	
	final GpioPinDigitalOutput pinR;
	private final DHT22 dht22;
	private final BMP180 bmp180;
	private final MCP3008 adc;
	private final ML8511 uv;
	private final TGS2600 tgs2600;
		
	public StazioneMeteoReader () {
		this.controller = GpioFactory.getInstance();
		this.pinR = controller.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Red", PinState.LOW);
		this.dht22 = new DHT22(28, "/home/pi/dht22");
		this.bmp180 = new BMP180();
		this.adc = new MCP3008();
		this.uv = new ML8511(adc);
		this.tgs2600 = new TGS2600(adc, MCP3008.MCP3008InputChannels.CH0);
	}

	public DHT22 getDht22() {
		return dht22;
	}


	public BMP180 getBmp180() {
		return bmp180;
	}

	public MCP3008 getAdc() {
		return adc;
	}

	public ML8511 getUv() {
		return uv;
	}
	

	public TGS2600 getTgs2600() {
		return tgs2600;
	}

	public void shutdown() {
		
		controller.shutdown();
		
	}
	

	public StazioneMeteoDati read() {
		
		System.out.println("Inizio lettura sensori: \n");
		
		pinR.pulse(100);
		StazioneMeteoDati dati = new StazioneMeteoDati();
		
		DHT22Response th = dht22.read();
		tgs2600.setReferenceHumidity((float) th.getHumidity());
		tgs2600.setReferenceTemperature((float) th.getTemperature());
		TGS2600Response res = tgs2600.read();
		
		dati.setAirQuality(res.getResistance());
		dati.setEtanolo(res.getC2h5ohPPM());
		dati.setButano(res.getC4h10PPM());
		dati.setIdrogeno(res.getH2PPM());
		dati.setTemperatura((float) th.getTemperature());
		dati.setUmidita((float) th.getHumidity());
		dati.setUvIntensity(uv.read());
		try {
			dati.setPressione(bmp180.readPressure());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fine lettura sensori!!! \n");
		pinR.low();
		
		return dati;
	}

}
