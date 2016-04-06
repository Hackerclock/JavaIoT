package com.kettydo.rpi.util;

public class NativeProcessException extends Exception {

	private static final long serialVersionUID = 1612981002381964921L;

	public NativeProcessException() {
		super();
	}

	public NativeProcessException(String message) {
		super(message);
	}

	public NativeProcessException(Throwable th) {
		super(th);
	}

	public NativeProcessException(String message, Throwable th) {
		super(message, th);
	}

}