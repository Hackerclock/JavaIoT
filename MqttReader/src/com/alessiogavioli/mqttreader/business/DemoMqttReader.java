package com.alessiogavioli.mqttreader.business;

import java.util.Arrays;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class DemoMqttReader {

	public static void main(String[] args) {
		
		final String broker = "tcp://iot.eclipse.org:1883";
		final String clientId = "AlessioCNA";
		MemoryPersistence persistence = new MemoryPersistence();
		String topic = "StazioneMeteoAlessioCNA";
		int qos = 2;
		
		try {
			MqttClient client = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			client.setCallback(new MqttCallback() {
				
				@Override
				public void messageArrived(String topic, MqttMessage message) throws Exception {
					
					JSONDeserializer<String> dese = new JSONDeserializer<>();
					String s = Arrays.toString(message.getPayload());
					System.out.println(topic + ": " + dese.deserialize(s));
					
				}
				
				@Override
				public void deliveryComplete(IMqttDeliveryToken arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void connectionLost(Throwable arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			client.connect();
			if (client.isConnected()) {
				System.out.println("Connesso");
				
			}
			client.subscribe(topic, qos);
			JSONSerializer s = new JSONSerializer();
			String prova = s.serialize("CIAO");
			MqttMessage message = new MqttMessage(prova.getBytes());
			client.publish(topic, message);
			//client.close();
			
		} catch (MqttException e) {
			e.printStackTrace();
		}
		

	}

}
