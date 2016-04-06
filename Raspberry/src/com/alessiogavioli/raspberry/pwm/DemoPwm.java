package com.alessiogavioli.raspberry.pwm;

import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

public class DemoPwm {
	
	private static int PIN = 1;

	public static void main(String[] args) throws InterruptedException {
		
		Gpio.wiringPiSetup();
		
		SoftPwm.softPwmCreate(PIN, 0, 100);
		int counter = 100;
		
		while (counter > 0) {
			/*for (int i = 0; i <= 100; i++) {
				SoftPwm.softPwmWrite(PIN, i);
				Thread.sleep(25);
			}
			
			for (int i = 100; i >= 0; i--) {
				SoftPwm.softPwmWrite(PIN, i);
				Thread.sleep(25);
			}*/
			//SoftPwm.softPwmWrite(PIN, 100);
			SoftPwm.softPwmWrite(PIN, counter);
			Thread.sleep(500);
			
			counter -= 5;
			
		}

	}

}
