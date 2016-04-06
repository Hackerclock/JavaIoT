package com.kettydo.rpi.business;

import com.kettydo.rpi.common.Writer;
import com.kettydo.rpi.model.StazioneMeteoWriter;

public class StazioneMeteoWriterFactory {

	public static StazioneMeteoWriter getWriter(Writer writer) {
		
		return new StazioneMeteoWriter();
	}

}
