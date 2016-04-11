package com.kettydo.rpi.business;

import com.kettydo.rpi.common.Writer;
import com.kettydo.rpi.model.JSONWriter;
import com.kettydo.rpi.model.StazioneMeteoWriter;

public class StazioneMeteoWriterFactory  {

	public static WriterInterfaces getWriter(Writer writer) {
		
		if (writer.equals(Writer.MQTT))
			return new StazioneMeteoWriter();
		
		if (writer.equals(Writer.HTTP))
			return new JSONWriter();
		
		return null;
	}

}
