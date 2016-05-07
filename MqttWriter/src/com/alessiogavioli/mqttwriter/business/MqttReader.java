package com.alessiogavioli.mqttwriter.business;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

//import com.alessiogavioli.aziendalogistica.model.Camion;

//import flexjson.JSONDeserializer;

public class MqttReader implements MqttCallback{
	
	private static int count = 0;
	public static String mess;

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		if (count == 0) {
			String m = new String(message.getPayload());
			System.out.println("Messaggio arrivato! \n\t" + m);
			count++;
		} else {
			
			String m = new String(message.getPayload());
			System.out.println("Messaggio arrivato! \n\t" + m);
			mess = m;
		}
		
		
	}

}
