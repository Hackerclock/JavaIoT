package com.kettydo.rpi.model;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.kettydo.rpi.business.StazioneMeteoDati;
import com.kettydo.rpi.business.WriterInterfaces;

import flexjson.JSONSerializer;

public class StazioneMeteoWriter implements WriterInterfaces{
	
	private final String broker;
	private final String clientId;
	private MemoryPersistence persistence;
	private MqttClient client;
	private MqttConnectOptions connOpts;
	
	public StazioneMeteoWriter() {
		this.broker = "tcp://iot.eclipse.org:1883";
		this.clientId = "AlessioCNA";
		this.persistence = new MemoryPersistence();
		try {
			this.client = new MqttClient(broker, clientId, persistence);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
		try {
			client.connect(connOpts);
		} catch (MqttSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public MemoryPersistence getPersistence() {
		return persistence;
	}
	public void setPersistence(MemoryPersistence persistence) {
		this.persistence = persistence;
	}

	public MqttClient getClient() {
		return client;
	}
	public void setClient(MqttClient client) {
		this.client = client;
	}

	public MqttConnectOptions getConnOpts() {
		return connOpts;
	}
	public void setConnOpts(MqttConnectOptions connOpts) {
		this.connOpts = connOpts;
	}

	public String getBroker() {
		return broker;
	}

	public String getClientId() {
		return clientId;
	}

	@Override
	public String toString() {
		return "StazioneMeteoWriter [broker=" + broker + ", clientId=" + clientId + ", persistence=" + persistence
				+ ", client=" + client + ", connOpts=" + connOpts + "]";
	}

	public void close() {
		try {
			client.close();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean write(StazioneMeteoDati data) {
		
		String topic = "StazioneMeteoAlessioCNA";
		int qos = 2;
		JSONSerializer jsonSerializer = new JSONSerializer();
		String json = jsonSerializer.serialize(data);
		MqttMessage message = new MqttMessage(json.getBytes());
		message.setQos(qos);
		try {
			client.publish(topic, message);
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
	}
	
}
