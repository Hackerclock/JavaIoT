package com.kettydo.rpi.business;

import com.kettydo.rpi.common.Writer;
import com.kettydo.rpi.model.StazioneMeteoReader;

public class DemoStazioneMeteo {

	public static void main(String[] args) {
		
		StazioneMeteoReader reader = new StazioneMeteoReader();
		// WriterInterfaces writer = (StazioneMeteoWriter) StazioneMeteoWriterFactory.getWriter(Writer.MQTT);
		WriterInterfaces writer = StazioneMeteoWriterFactory.getWriter(Writer.HTTP);
				
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				reader.shutdown();
				writer.close();
			}
		});
		
		while (true) {
			StazioneMeteoDati data = reader.read();
			System.out.println(data.toString());
			writer.write(data);	
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
