package com.alessiogavioli.raspberry.rtttl;

import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftTone;

public class DemoRtttl {
	
	final static int NOTE_B0 = 31;
	final static int NOTE_C1 = 33;
	final static int NOTE_CS1 = 35;
	final static int NOTE_D1 = 37;
	final static int NOTE_DS1 = 39;
	final static int NOTE_E1 = 41;
	final static int NOTE_F1 = 44;
	final static int NOTE_FS1 = 46;
	final static int NOTE_G1 = 49;
	final static int NOTE_GS1 = 52;
	final static int NOTE_A1 = 55;
	final static int NOTE_AS1 = 58;
	final static int NOTE_B1 = 62;
	final static int NOTE_C2 = 65;
	final static int NOTE_CS2 = 69;
	final static int NOTE_D2 = 73;
	final static int NOTE_DS2 = 78;
	final static int NOTE_E2 = 82;
	final static int NOTE_F2 = 87;
	final static int NOTE_FS2 = 93;
	final static int NOTE_G2 = 98;
	final static int NOTE_GS2 = 104;
	final static int NOTE_A2 = 110;
	final static int NOTE_AS2 = 117;
	final static int NOTE_B2 = 123;
	final static int NOTE_C3 = 131;
	final static int NOTE_CS3 = 139;
	final static int NOTE_D3 = 147;
	final static int NOTE_DS3 = 156;
	final static int NOTE_E3 = 165;
	final static int NOTE_F3 = 175;
	final static int NOTE_FS3 = 185;
	final static int NOTE_G3 = 196;
	final static int NOTE_GS3 = 208;
	final static int NOTE_A3 = 220;
	final static int NOTE_AS3 = 233;
	final static int NOTE_B3 = 247;
	final static int NOTE_C4 = 262;
	final static int NOTE_CS4 = 277;
	final static int NOTE_D4 = 294;
	final static int NOTE_DS4 = 311;
	final static int NOTE_E4 = 330;
	final static int NOTE_F4 = 349;
	final static int NOTE_FS4 = 370;
	final static int NOTE_G4 = 392;
	final static int NOTE_GS4 = 415;
	final static int NOTE_A4 = 440;
	final static int NOTE_AS4 = 466;
	final static int NOTE_B4 = 494;
	final static int NOTE_C5 = 523;
	final static int NOTE_CS5 = 554;
	final static int NOTE_D5 = 587;
	final static int NOTE_DS5 = 622;
	final static int NOTE_E5 = 659;
	final static int NOTE_F5 = 698;
	final static int NOTE_FS5 = 740;
	final static int NOTE_G5 = 784;
	final static int NOTE_GS5 = 831;
	final static int NOTE_A5 = 880;
	final static int NOTE_AS5 = 932;
	final static int NOTE_B5 = 988;
	final static int NOTE_C6 = 1047;
	final static int NOTE_CS6 = 1109;
	final static int NOTE_D6 = 1175;
	final static int NOTE_DS6 = 1245;
	final static int NOTE_E6 = 1319;
	final static int NOTE_F6 = 1397;
	final static int NOTE_FS6 = 1480;
	final static int NOTE_G6 = 1568;
	final static int NOTE_GS6 = 1661;
	final static int NOTE_A6 = 1760;
	final static int NOTE_AS6 = 1865;
	final static int NOTE_B6 = 1976;
	final static int NOTE_C7 = 2093;
	final static int NOTE_CS7 = 2217;
	final static int NOTE_D7 = 2349;
	final static int NOTE_DS7 = 2489;
	final static int NOTE_E7 = 2637;
	final static int NOTE_F7 = 2794;
	final static int NOTE_FS7 = 2960;
	final static int NOTE_G7 = 3136;
	final static int NOTE_GS7 = 3322;
	final static int NOTE_A7 = 3520;
	final static int NOTE_AS7 = 3729;
	final static int NOTE_B7 = 3951;
	final static int NOTE_C8 = 4186;
	final static int NOTE_CS8 = 4435;
	final static int NOTE_D8 = 4699;
	final static int NOTE_DS8 = 4978;
	 
	final static int melodyPin = 1;
	
	final static int[] tempo = {
			  12, 12, 12, 12,
			  12, 12, 12, 12,
			  12, 12, 12, 12,
			  12, 12, 12, 12,
			 
			  12, 12, 12, 12,
			  12, 12, 12, 12,
			  12, 12, 12, 12,
			  12, 12, 12, 12,
			 
			  9, 9, 9,
			  12, 12, 12, 12,
			  12, 12, 12, 12,
			  12, 12, 12, 12,
			 
			  12, 12, 12, 12,
			  12, 12, 12, 12,
			  12, 12, 12, 12,
			  12, 12, 12, 12,
			 
			  9, 9, 9,
			  12, 12, 12, 12,
			  12, 12, 12, 12,
			  12, 12, 12, 12,
			};
	
	final static int[] melody = {
			  NOTE_E7, NOTE_E7, 0, NOTE_E7,
			  0, NOTE_C7, NOTE_E7, 0,
			  NOTE_G7, 0, 0,  0,
			  NOTE_G6, 0, 0, 0,
			 
			  NOTE_C7, 0, 0, NOTE_G6,
			  0, 0, NOTE_E6, 0,
			  0, NOTE_A6, 0, NOTE_B6,
			  0, NOTE_AS6, NOTE_A6, 0,
			 
			  NOTE_G6, NOTE_E7, NOTE_G7,
			  NOTE_A7, 0, NOTE_F7, NOTE_G7,
			  0, NOTE_E7, 0, NOTE_C7,
			  NOTE_D7, NOTE_B6, 0, 0,
			 
			  NOTE_C7, 0, 0, NOTE_G6,
			  0, 0, NOTE_E6, 0,
			  0, NOTE_A6, 0, NOTE_B6,
			  0, NOTE_AS6, NOTE_A6, 0,
			 
			  NOTE_G6, NOTE_E7, NOTE_G7,
			  NOTE_A7, 0, NOTE_F7, NOTE_G7,
			  0, NOTE_E7, 0, NOTE_C7,
			  NOTE_D7, NOTE_B6, 0, 0
			};

	public static void main(String[] args) throws InterruptedException {
		
		Gpio.wiringPiSetup();
		System.out.println("Creato");
		Thread.sleep(1000);
		int x = 0;
		
		while (x < 5) {
			
			SoftTone.softToneCreate(melodyPin);

			for (int i = 0; i < melody.length; i++) {
				
				SoftTone.softToneWrite(melodyPin, melody[i]);
				Thread.sleep(1000 / tempo[i]);
				
			
			}
			Thread.sleep(25);
			SoftTone.softToneStop(melodyPin);
			System.out.println("Fine");
			x++;
		}

	}

}
