package com.alessiogavioli.mqttwriter.business;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.alessiogavioli.aziendalogistica.model.Articolo;
import com.alessiogavioli.aziendalogistica.model.Camion;
import com.alessiogavioli.aziendalogistica.model.Carico;
import com.alessiogavioli.aziendalogistica.model.Destinazione;
import com.alessiogavioli.aziendalogistica.model.Dimensioni;
import com.alessiogavioli.aziendalogistica.model.Guidatore;
import com.alessiogavioli.aziendalogistica.model.Pallet;
import com.alessiogavioli.aziendalogistica.model.PianoViaggio;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class DemoMqttWriter {

	public static void main(String[] args) {
		
		Articolo art1 = new Articolo("0000", "Caffe' Coop", "Barattolo 250g", 3.60f, 0.25f, 4000);
		Articolo art2 = new Articolo("0002", "Caffe' Coop", "Sacco 1Kg", 9.90f, 1.00f, 1000);
		Articolo art3 = new Articolo("0003", "Caffe' Coop", "Sacco 10Kg", 89.90f, 10.00f, 1000);
		
		Pallet pallet1 = new Pallet(new Dimensioni(120.00f, 80.00f, 190.00f), art1);
		Pallet pallet2 = new Pallet(new Dimensioni(120.00f, 80.00f, 190.00f), art2);
		Pallet pallet3 = new Pallet(new Dimensioni(120.00f, 80.00f, 190.00f), art3);
		List<Pallet> pallets = new ArrayList<>();
		pallets.add(pallet1);
		pallets.add(pallet2);
		pallets.add(pallet3);
		Carico carico1 = new Carico(pallets);
		
		Destinazione dest1 = new Destinazione("41° 53' 30 N", "12° 30' 40 E", "Roma", new GregorianCalendar(2016, 2, 1).getTime(), new GregorianCalendar(2016, 2, 1).getTime());
		Destinazione dest2 = new Destinazione("43° 46' 45 N", "11° 14' 46 E", "Firenze", new GregorianCalendar(2016, 2, 1).getTime(), new GregorianCalendar(2016, 2, 1).getTime());
		List<Destinazione> destinazioni = new ArrayList<>();
		destinazioni.add(dest1);
		destinazioni.add(dest2);
		PianoViaggio pianoViaggio = new PianoViaggio(destinazioni);
		
		Camion camion1 = new Camion("ABC345", new Guidatore("Alessio Gavioli"), pianoViaggio, 3000.00f, 6);
		System.out.println(camion1.toString());
		
		String s = "Ciao come va?";
		JSONSerializer json = new JSONSerializer();
		String cam = json.serialize(camion1);
		s = json.serialize(s);
		String topic = "StazioneMeteoAlessioCNA";
		int qos = 2;
		
		String broker = "tcp://iot.eclipse.org:1883";
		String clientId = "AlessioCNA";
		MemoryPersistence persistence = new MemoryPersistence();
		
		try {
			MqttClient client = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			client.connect(connOpts);
			client.setCallback(new MqttReader());
			client.subscribe(topic, qos);
			MqttMessage message = new MqttMessage(s.getBytes());
			message.setQos(qos);
			client.publish(topic, message);
			System.out.println("Inviato");
			Thread.sleep(3000);
			MqttMessage messageCam = new MqttMessage(cam.getBytes());
			messageCam.setQos(qos);
			client.publish(topic, messageCam);
			System.out.println("Inviato");
			Thread.sleep(1000);
			client.disconnect();
			
		} catch (MqttException | InterruptedException e) {
			System.err.println(e.getMessage());
			
		}
		
		JSONDeserializer< Camion> dejson = new JSONDeserializer<>();
		Camion cam2 = dejson.use(null, Camion.class).deserialize(MqttReader.mess);
		System.out.println(cam2.toString());

	}

}
