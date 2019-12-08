package org.ClientModule;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.json.bind.Jsonb;

import org.ServerModule.Sensor;
import org.ServerModule.SerializationDriver;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import javax.json.bind.JsonbBuilder;

public class BackEnd implements ActionListener, WindowListener {

	public String location;
	public String sensorName;
	public String sensorType; 
	public String state;



	public SensorInterface sensorInterface;

	//public void start (){

	//		SerializationDriver ser = new SerializationDriver();
	//
	//		System.out.println("start du back");
	//		Sensor sensor = new Sensor(location, SensorName, SensorType,State);
	//		ClientSocket client = new ClientSocket();
	//		try {
	//			System.out.println("ser");
	//			ser.serializer(sensor);
	//
	//		} catch (JsonProcessingException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		client.getSocket(sensor);
	//		System.out.println("appeler a socket");




	//}


	public BackEnd(SensorInterface sensorInterface2) {
		this.sensorInterface = sensorInterface2;
	}



	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== SensorInterface.getButtonSubmit()){
			System.out.println("action button Submit");
			ClientSocket client = new ClientSocket();

			Sensor sensor = new Sensor();
			sensor.location = SensorInterface.getTextLocation();
			sensor.sensorName =  SensorInterface.getTextName();
			sensor.sensorType =  SensorInterface.getTextType();
			sensor.state =  SensorInterface.getTextState();



			System.out.println(sensor.toString());
			Jsonb jsonb = JsonbBuilder.create();
			String result = jsonb.toJson(sensor);
			System.out.println(result);
			
			//String serializedObject = Tools.serializeObject(sensor, sensor.getClass(), "");
//			System.out.println(serializedObject);
//			String jsRequest = Tools.serializeQuery(Queries.INSERT, Sensor.class, serializedObject,null);
//			System.out.println(jsRequest);
//			System.out.println("toto1");
			//ClientServerConnection.callSocket();

			String answer = client.getSocket(result);


			//String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();

		}



	} 


}





