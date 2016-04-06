package com.alessiogavioli.raspberry.sevensegdisplay;

import java.util.concurrent.Callable;


import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;

public class DemoDisplay {
	
	static int i = 0;

	public static void main(String[] args) {
		
		
		final GpioController gpio = GpioFactory.getInstance();
		
		final GpioPinDigitalInput btn = gpio.provisionDigitalInputPin
				(RaspiPin.GPIO_29, "Button", PinPullResistance.PULL_DOWN);
		
		btn.addTrigger(new GpioCallbackTrigger(new Callable<Void>() {
			
			public Void call() throws Exception {
				
				if (btn.getState() == PinState.HIGH)
					i++;
				return null;
			}
			}));
		
		
		final GpioPinDigitalOutput a = gpio.provisionDigitalOutputPin
				(RaspiPin.GPIO_25,"a",PinState.HIGH);
		a.setShutdownOptions(true,PinState.HIGH);
		
		final GpioPinDigitalOutput b = gpio.provisionDigitalOutputPin
				(RaspiPin.GPIO_22,"b",PinState.HIGH);
		b.setShutdownOptions(true,PinState.HIGH);
		
		final GpioPinDigitalOutput c = gpio.provisionDigitalOutputPin
				(RaspiPin.GPIO_21,"c",PinState.HIGH);
		c.setShutdownOptions(true,PinState.HIGH);
		
		final GpioPinDigitalOutput d = gpio.provisionDigitalOutputPin
				(RaspiPin.GPIO_02,"d",PinState.HIGH);
		d.setShutdownOptions(true,PinState.HIGH);
		
		final GpioPinDigitalOutput e = gpio.provisionDigitalOutputPin
				(RaspiPin.GPIO_00,"e",PinState.HIGH);
		e.setShutdownOptions(true,PinState.HIGH);
		
		final GpioPinDigitalOutput f = gpio.provisionDigitalOutputPin
				(RaspiPin.GPIO_24,"f",PinState.HIGH);
		f.setShutdownOptions(true,PinState.HIGH);
		
		final GpioPinDigitalOutput g = gpio.provisionDigitalOutputPin
				(RaspiPin.GPIO_23,"g",PinState.HIGH);
		g.setShutdownOptions(true,PinState.HIGH);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
		
		
		while (i < 10) {
			switch (i) {
			case 0:
				System.out.println("0");
				a.low();
				b.low();
				c.low();
				d.low();
				e.low();
				f.low();
				g.high();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				}
				break;
			case 1:
				System.out.println("1");
				a.high();
				b.low();
				c.low();
				d.high();
				e.high();
				f.high();
				g.high();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				}
				break;
			case 2:
				System.out.println("2");
				a.low();
				b.low();
				c.high();
				d.low();
				e.low();
				f.high();
				g.low();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				}
				break;
			case 3:
				System.out.println("3");
				a.low();
				b.low();
				c.low();
				d.low();
				e.high();
				f.high();
				g.low();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				}
				break;
			case 4:
				System.out.println("4");
				a.high();
				b.low();
				c.low();
				d.high();
				e.high();
				f.low();
				g.low();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				}
				break;
			case 5:
				System.out.println("5");
				a.low();
				b.high();
				c.low();
				d.low();
				e.high();
				f.low();
				g.low();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				}
				break;
			case 6:
				System.out.println("6");
				a.low();
				b.high();
				c.low();
				d.low();
				e.low();
				f.low();
				g.low();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				}
				break;
			case 7:
				System.out.println("7");
				a.low();
				b.low();
				c.low();
				d.high();
				e.high();
				f.high();
				g.high();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				}
				break;
			case 8:
				System.out.println("8");
				a.low();
				b.low();
				c.low();
				d.low();
				e.low();
				f.low();
				g.low();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				}
				break;
			case 9:
				System.out.println("9");
				a.low();
				b.low();
				c.low();
				d.low();
				e.high();
				f.low();
				g.low();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				}
				break;
			default:
				;
				break;
			}
		}
		
		b.setShutdownOptions(true,PinState.HIGH);
		gpio.shutdown();

	}

}
