package com.alessiogavioli.catalogoarte.business;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.alessiogavioli.catalogoarte.model.Autore;
import com.alessiogavioli.catalogoarte.model.Opera;
import com.alessiogavioli.catalogoarte.model.Stile;
import com.alessiogavioli.catalogoarte.model.Tipo;

public class DemoMain {

	public static void main(String[] args) {
		
		Autore autore1 = new Autore("Pablo", "Picasso", "Picasso", "Malaga",
				new GregorianCalendar(1881, 10, 25).getTime(), new GregorianCalendar(1881, 10, 25).getTime());
		
		Stile stile1 = new Stile("Cubismo");
		
		Tipo tipo1 = new Tipo("Quadro");
		
		Opera opera1 = new Opera("Guernica", new GregorianCalendar(1937, 4, 22).getTime(), tipo1, stile1, autore1);
		
		System.out.println(opera1.toString());
		
		Autore autore2 = new Autore("Pippo", "Pluto", "Paperino", "Paperopoli",
				new GregorianCalendar(1920, 7, 23).getTime(), new GregorianCalendar(1980, 1, 15).getTime());
		
		Stile stile2 = new Stile("Impressionismo");
		
		Tipo tipo2 = new Tipo("Scultura");
		
		Opera opera2 = new Opera("David", new GregorianCalendar(1958, 8, 2).getTime(), tipo2, stile2, autore2);
		
		System.out.println(opera2.toString());
		
		List<Opera> opere = new ArrayList<>();
		opere.add(opera1);
		opere.add(opera2);
		
		for (Opera o : opere) {
			JsonManager.serializza(o);
			JsonManager.invia();
		}
		
		
	}

}
