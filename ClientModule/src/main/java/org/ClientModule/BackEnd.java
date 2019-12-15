package org.ClientModule;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.json.bind.Jsonb;

import org.ServerModule.Sensor;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import javax.json.bind.JsonbBuilder;

public class BackEnd implements ActionListener {

	public String location;
	public String sensorName;
	public String sensorType; 
	public String state;
	Sensor sensor;


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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== SensorInterface.getButtonSubmit()){
			System.out.println("action button Submit");


			sensor = new Sensor();
			sensor.query = "INSERT";
			sensor.location = SensorInterface.getTextLocation();
			sensor.sensorName =  SensorInterface.getTextName();
			sensor.sensorType =  SensorInterface.getTextType();
			sensor.state =  SensorInterface.getTextState();


			if(SensorInterface.getTextLocation().toUpperCase().equals("CORRIDOR1") ||SensorInterface.getTextLocation().toUpperCase().equals("CORRIDOR2") || SensorInterface.getTextLocation().toUpperCase().equals("KITCHEN") || SensorInterface.getTextLocation().toUpperCase().equals("LIVINGROOM")|| SensorInterface.getTextLocation().toUpperCase().equals("LIBRARY"))
			{

				if(SensorInterface.getTextType().toUpperCase().equals("SMOKE") || SensorInterface.getTextType().toUpperCase().equals("HUMIDITY"))
				{
					if(SensorInterface.getTextState().toUpperCase().equals("ON") || SensorInterface.getTextState().toUpperCase().equals("OFF") || SensorInterface.getTextState().toUpperCase().equals("ALERTE") )
					{
						if(! SensorInterface.getTextName().isEmpty() )
						{


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

							ClientSocket client = new ClientSocket();


							String answer = client.getSocket(result);
						}else 
						{
							System.out.println("Le nom du capteur ne peut pas etre vide !");
						}

					}else 
					{
						System.out.println("cet état du capteur n'existe pas !");
					}

				}else 
				{
					System.out.println("Le type de capteur n'existe pas !");
				}

				//String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
			}else 
			{
				System.out.println("La localisation n'existe pas !");
			}
		}
		else if (e.getSource()== SensorInterface.getButtonSupprimer()){
			System.out.println("action button Delete");


			sensor = new Sensor();
			sensor.query = "DELETE";
			sensor.location = SensorInterface.getTextLocation();
			sensor.sensorName =  SensorInterface.getTextName();
			sensor.sensorType =  SensorInterface.getTextType();
			sensor.state =  SensorInterface.getTextState();

			if(SensorInterface.getTextLocation().toUpperCase().equals("CORRIDOR1") ||SensorInterface.getTextLocation().toUpperCase().equals("CORRIDOR2") || SensorInterface.getTextLocation().toUpperCase().equals("KITCHEN") || SensorInterface.getTextLocation().toUpperCase().equals("LIVINGROOM")|| SensorInterface.getTextLocation().toUpperCase().equals("LIBRARY"))
			{

				if(SensorInterface.getTextType().toUpperCase().equals("SMOKE") || SensorInterface.getTextType().toUpperCase().equals("HUMIDITY"))
				{
					if(SensorInterface.getTextState().toUpperCase().equals("ON") || SensorInterface.getTextState().toUpperCase().equals("OFF") || SensorInterface.getTextState().toUpperCase().equals("ALERTE") )
					{
						if(! SensorInterface.getTextName().isEmpty() )
						{

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

							ClientSocket client = new ClientSocket();


							String answer = client.getSocket(result);
						}else 
						{
							System.out.println("Le nom du capteur du capteur ne peut pas etre vide !");
						}
					}else 
					{
						System.out.println("cet état du capteur n'existe pas !");
					}

				}else 
				{
					System.out.println("Le type de capteur n'existe pas !");
				}

				//String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
			}else 
			{
				System.out.println("La localisation n'existe pas !");
			}


		}

	} 


}





