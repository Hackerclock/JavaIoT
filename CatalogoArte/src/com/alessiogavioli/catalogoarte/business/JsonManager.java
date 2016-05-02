package com.alessiogavioli.catalogoarte.business;

import com.alessiogavioli.catalogoarte.model.Opera;

import flexjson.JSONSerializer;

public class JsonManager {
	
	public static String jsonSe;
	
	public static void serializza (Object obj) {
		
		if (obj instanceof Opera) {
			
			Opera opera1 = (Opera)obj;
			
			JSONSerializer s = new JSONSerializer();
			s.exclude("class", "opera.class", "autore.class", "stile.class", "tipo.class");
			s.prettyPrint(true);
			jsonSe = s.deepSerialize(opera1);
			
		}
		
		if (obj instanceof Status) {
			
			Status status1 = (Status)obj;
			
			JSONSerializer s = new JSONSerializer();
			s.exclude("class");
			s.prettyPrint(true);
			jsonSe = s.deepSerialize(status1);
			
		}
		
	}
	
	public static void invia () {
		new JSONWriter().write(jsonSe);
	}

}
