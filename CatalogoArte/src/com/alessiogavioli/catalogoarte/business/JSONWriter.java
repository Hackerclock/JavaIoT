package com.alessiogavioli.catalogoarte.business;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class JSONWriter {
	
	private String serviceUrl = "http://10.24.105.55:8080/ServletCatalogoArte/save";

	private URL url;
	private HttpURLConnection con;


	public JSONWriter() {
		try {
			url = new URL(serviceUrl);
		} catch (Exception e) {
			System.err.println("Unable to initialize RESTWriter: " + e.getMessage());
		}
	}

	public boolean write(String json) {

		try {

			openConnection();

			DataOutputStream out = new DataOutputStream(con.getOutputStream());
			out.write(("data=" + json).getBytes(StandardCharsets.UTF_8));

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			System.out.println(response.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return true;
	}

	public void close() {
		closeConnection();
	}

	private void openConnection() throws Exception {
		con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", this.getClass().getName());
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Charset", "UTF-8");
		con.setDoOutput(true);
		con.setUseCaches(false);
	}

	private void closeConnection() {
		if (con != null) {
			con.disconnect();
		}
	}

}