package com.kettydo.rpi.driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kettydo.rpi.util.NativeProcess;
import com.kettydo.rpi.util.NativeProcessException;

public class DHT22 {

	private static Log log = LogFactory.getLog(DHT22.class);

	private static final int DEFAULT_PIN = 28;
	private static final String NATIVE_DRIVER = "dht22";

	private int pin;
	private String nativeDriver;

	public DHT22() {
		this(DEFAULT_PIN, NATIVE_DRIVER);
	}

	public DHT22(int pin, String nativeDriver) {
		this.pin = pin;
		this.nativeDriver = nativeDriver;
	}

	public DHT22Response read() {
		DHT22Response res = null;

		List<String> command = new ArrayList<String>();
		command.add(nativeDriver);
		command.add(String.valueOf(pin));

		try {
			NativeProcess np = new NativeProcess(command, null, "/tmp", true);
			np.run();
			String out = readStream(np.getStdIn());
			if (out != null) {
				JAXBContext ctx = JAXBContext.newInstance(DHT22Response.class);
				res = (DHT22Response) ctx.createUnmarshaller().unmarshal(new StringReader(out));
			}
		} catch (NativeProcessException | JAXBException e) {
		}

		return res;
	}

	private String readStream(BufferedReader stdIn) {
		String res = null;

		try {
			res = stdIn.readLine();
		} catch (Exception e) {
			log.error("Unable to read process stream", e);
		} finally {
			try {
				stdIn.close();
			} catch (IOException e) {
				log.error("Unable to close process stream", e);
			}
		}

		return res;
	}

}