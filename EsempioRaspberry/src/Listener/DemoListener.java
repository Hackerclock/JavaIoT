package Listener;


import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
//import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
//import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class DemoListener {

	public static void main(String[] args) {
		
		final GpioController gpio = GpioFactory.getInstance();
		
		final GpioPinDigitalInput btn = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);
		
		//final GpioPinDigitalOutput pinR = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Red", PinState.LOW);
		
		btn.addListener(new GpioPinListenerDigital() {
			
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				System.out.println("--> GPIO PINSTATE CHANGE: " + event.getPin() + " = " + event.getState());
				
					
				
			}
		});
		
		while (true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
