package Trigger;

import java.util.concurrent.Callable;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
import com.pi4j.io.gpio.trigger.GpioPulseStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSetStateTrigger;

public class DemoTrigger {

	public static void main(String[] args) {
		
		// create gpio controller
		final GpioController gpio = GpioFactory.getInstance();
		
		// provision gpio pin #02 as an input pin with its internal pull down resistor enabled
		final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02,
		PinPullResistance.PULL_DOWN);
		
		// setup gpio pins #04, #05, #06 as an output pins and make sure they are all LOW
		// at startup
		GpioPinDigitalOutput myLed[] = {
		gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "LED #1", PinState.LOW),
		gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "LED #2", PinState.LOW),
		gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "LED #3", PinState.LOW)
		};
		
		// create a gpio control trigger on the input pin; when the input goes HIGH, also set gpio pin #04 to HIGH
		myButton.addTrigger(new GpioSetStateTrigger(PinState.HIGH, myLed[0], PinState.HIGH));
		
		// create a gpio control trigger on the input pin; when the input goes LOW, also set gpio pin #04 to LOW
		myButton.addTrigger(new GpioSetStateTrigger(PinState.LOW, myLed[0], PinState.LOW));
		
		myButton.addTrigger(new GpioCallbackTrigger(new Callable<Void>() {
			public Void call() throws Exception {
				System.out.println(" --> GPIO TRIGGER CALLBACK RECEIVED ");
				myButton.addTrigger(new GpioPulseStateTrigger(PinState.HIGH, myLed[0], 3000));
				return null;
			}
		}));
		
		/*
		// create a gpio control trigger on the input pin; when the input goes LOW, also set gpio pin #04 to LOW
		myButton.addTrigger(new GpioSetStateTrigger(PinState.LOW, myLed[0], PinState.LOW));
		
		// create a gpio synchronization trigger on the input pin; when the input changes, also set gpio pin #05 to same state
		myButton.addTrigger(new GpioSyncStateTrigger(myLed[1]));
		
		// create a gpio pulse trigger on the input pin; when the input goes HIGH, also pulse gpio pin #06 to the HIGH state for 1 second
		myButton.addTrigger(new GpioPulseStateTrigger(PinState.HIGH, myLed[2], 1000));
		
		// create a gpio callback trigger on gpio pin#4; when #4 changes state, perform a callback
		// invocation on the user defined 'Callable' class instance
		myButton.addTrigger(new GpioCallbackTrigger(new Callable<Void>() {
			public Void call() throws Exception {
				System.out.println(" --> GPIO TRIGGER CALLBACK RECEIVED ");				
				myButton.addTrigger(new GpioPulseStateTrigger(PinState.HIGH, myLed[2], 1000));
				myButton.addTrigger(new GpioPulseStateTrigger(PinState.HIGH, myLed[1], 2000));
				myButton.addTrigger(new GpioPulseStateTrigger(PinState.HIGH, myLed[0], 3000));
				return null;
			}
		}));
		*/
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
