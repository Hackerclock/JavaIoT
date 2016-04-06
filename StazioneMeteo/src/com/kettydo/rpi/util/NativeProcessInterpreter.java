package com.kettydo.rpi.util;

/**
 * Interfaccia che deve essere implementata dall'utilizzatore del
 * MultiThreadRunner.
 * 
 * @author Marco
 * 
 */
public interface NativeProcessInterpreter {

	/**
	 * Legge da stdin (cioè dallo stdout del processo).
	 * 
	 * @param input
	 */
	public void processInput(String input);

	/**
	 * Legge da stderr (cioè dallo stderr del processo).
	 * 
	 * @param error
	 */
	public void processError(String error);

	/**
	 * Legge il risultato dell'esecuzione del processo.
	 * 
	 * @param exitValue
	 */
	public void processEnd(int exitValue);
}
