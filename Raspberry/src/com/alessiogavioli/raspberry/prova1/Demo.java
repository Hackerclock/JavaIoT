package com.alessiogavioli.raspberry.prova1;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
//import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
//import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Demo {

	public static void main(String[] args) {
		
		//creategpiocontroller
		final GpioController gpio=GpioFactory.getInstance();
		//provisiongpiopin#01asanoutputpinandturnon
		final GpioPinDigitalOutput pin=gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00,
		"MyLED",PinState.HIGH);
		
		//final GpioPinDigitalInput btn = gpio.provisionDigitalInputPin(RaspiPin.GPIO_00, "Button", PinPullResistance.PULL_DOWN);
		
		//setshutdownstateforthispin
		pin.setShutdownOptions(true,PinState.LOW);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//turnoffgpiopin#01
		pin.low();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//togglethecurrentstateofgpiopin#01(shouldturnon)
		pin.toggle();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//turnongpiopin#01for1secondandthenoff
		pin.pulse(1000,true);
		//setsecondargumentto'true'useablockingcall
		//stopallGPIOactivity/threadsbyshuttingdowntheGPIOcontroller
		//(thismethodwillforcefullyshutdownallGPIOmonitoringthreadsandscheduledtasks)
		gpio.shutdown();

	}

}
