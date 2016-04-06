package com.kettydo.rpi.driver;

public class TGS2600Response {

	private float resistance;
	private float c2h5ohPPM;
	private float c4h10PPM;
	private float h2PPM;

	/**
	 * @return the resistance
	 */
	public float getResistance() {
		return resistance;
	}

	/**
	 * @param resistance
	 *            the resistance to set
	 */
	public void setResistance(final float resistance) {
		this.resistance = resistance;
	}

	/**
	 * @return the c2h5ohPPM
	 */
	public float getC2h5ohPPM() {
		return c2h5ohPPM;
	}

	/**
	 * @param c2h5ohPPM
	 *            the c2h5ohPPM to set
	 */
	public void setC2h5ohPPM(final float c2h5ohPPM) {
		this.c2h5ohPPM = c2h5ohPPM;
	}

	/**
	 * @return the c4h10PPM
	 */
	public float getC4h10PPM() {
		return c4h10PPM;
	}

	/**
	 * @param c4h10ppm
	 *            the c4h10PPM to set
	 */
	public void setC4h10PPM(final float c4h10ppm) {
		c4h10PPM = c4h10ppm;
	}

	/**
	 * @return the h2PPM
	 */
	public float getH2PPM() {
		return h2PPM;
	}

	/**
	 * @param h2ppm
	 *            the h2PPM to set
	 */
	public void setH2PPM(final float h2ppm) {
		h2PPM = h2ppm;
	}

}
