package com.kettydo.rpi.driver;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dht22")
public class DHT22Response {

	private double temperature;
	private double humidity;
	private long timestamp;

	/**
	 * Il driver ritorna il timestamp in secondi. In Java ho bisogno dei millisecondi.
	 *
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp * 1000;
	}

	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature
	 *           the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the humidity
	 */
	public double getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity
	 *           the humidity to set
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	/**
	 * @param timestamp
	 *           the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
