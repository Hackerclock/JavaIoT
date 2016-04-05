import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class Demo {

	public static void main(String[] args) {
		System.out.println("Hello World!!!");
		
		final GpioController gpio = GpioFactory.getInstance();
		final GpioPinDigitalOutput pinR = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Red", PinState.LOW);
		final GpioPinDigitalOutput pinY = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Yellow", PinState.LOW);
		final GpioPinDigitalOutput pinG = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Green", PinState.LOW);
		
		pinG.high();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pinG.low();
		pinY.high();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pinY.low();
		pinR.high();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pinR.setShutdownOptions(false, PinState.HIGH);
		pinY.setShutdownOptions(false, PinState.HIGH);
		pinG.setShutdownOptions(false, PinState.HIGH);
		
		//gpio.setShutdownOptions(true, PinState.LOW);
		
		gpio.shutdown();

	}

}
