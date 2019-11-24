package org.ClientModule;


import java.awt.Color;

import org.ServerModule.Sensor;
import org.ServerModule.SerializationDriver;

import com.fasterxml.jackson.core.JsonProcessingException;

public class BackEnd {

	String location;
	String SensorName;
	String SensorType; 
	String State;

	public BackEnd (String location, String SensorName, String SensorType, String State)
	{
		this.location = location;
		this.SensorName = SensorName;
		this.SensorType = SensorType;
		this.State = State;


	}
	public BackEnd ()
	{

	}

	public void AfficherSensors(org.ClientModule.Sensor sensor,SensorFirst instance )
	{

		

		switch (sensor.location.toUpperCase()) 
		{
		case "CORRIDOR1" :


			if (sensor.sensorType.toUpperCase() == "HUMIDITY")

			{



				switch(sensor.state.toUpperCase())
				{
				case "ON" :
					//SensorFirst instance =new SensorFirst();
					System.out.println("corr1 hum on");
					instance.humidity1.setBackground(Color.GREEN);
					instance.humidity1.setVisible(true);
					break;
				case "ALERTE":

					//SensorFirst instance1 =new SensorFirst();
					instance.humidity1.setBackground(Color.RED);
					instance.humidity1.setVisible(true);

				default : 
					//SensorFirst instance2 =new SensorFirst();

					instance.humidity1.setVisible(true);
					break;
				}
			}
			else 
			{


				switch(sensor.state.toUpperCase())
				{
				case "ON" :
					//SensorFirst instance =new SensorFirst();
					System.out.println("corr1 hum on");
					instance.smoke1.setBackground(Color.GREEN);
					instance.smoke1.setVisible(true);
					break;
				case "ALERTE":

					//SensorFirst instance1 =new SensorFirst();
					instance.smoke1.setBackground(Color.RED);
					instance.smoke1.setVisible(true);

				default : 
					//SensorFirst instance2 =new SensorFirst();

					instance.smoke1.setVisible(true);
					break;
				}
			}

			break;
		case "CORRIDOR2" :


			if (sensor.sensorType.toUpperCase() == "HUMIDITY")

			{



				switch(sensor.state.toUpperCase())
				{
				case "ON" :
					
					System.out.println("corr1 hum on");
					instance.humidity2.setBackground(Color.GREEN);
					instance.humidity2.setVisible(true);
					break;
				case "ALERTE":

					//SensorFirst instance1 =new SensorFirst();
					instance.humidity2.setBackground(Color.RED);
					instance.humidity2.setVisible(true);

				default : 
					//SensorFirst instance2 =new SensorFirst();

					instance.humidity2.setVisible(true);
					break;
				}
			}
			else 
			{


				switch(sensor.state.toUpperCase())
				{
				case "ON" :
					//SensorFirst instance =new SensorFirst();
					System.out.println("corr1 hum on");
					instance.smoke2.setBackground(Color.GREEN);
					instance.smoke2.setVisible(true);
					break;
				case "ALERTE":

					//SensorFirst instance1 =new SensorFirst();
					instance.smoke2.setBackground(Color.RED);
					instance.smoke2.setVisible(true);

				default : 
					//SensorFirst instance2 =new SensorFirst();

					instance.smoke2.setVisible(true);
					break;
				}
			}

			break;
		case "CORRIDOR3" :


			if (sensor.sensorType.toUpperCase() == "HUMIDITY")

			{



				switch(sensor.state.toUpperCase())
				{
				case "ON" :
					//SensorFirst instance =new SensorFirst();
					System.out.println("corr1 hum on");
					instance.humidity3.setBackground(Color.GREEN);
					instance.humidity3.setVisible(true);
					break;
				case "ALERTE":

					//SensorFirst instance1 =new SensorFirst();
					instance.humidity3.setBackground(Color.RED);
					instance.humidity3.setVisible(true);

				default : 
					//SensorFirst instance2 =new SensorFirst();

					instance.humidity3.setVisible(true);
					break;
				}
			}
			else 
			{


				switch(sensor.state.toUpperCase())
				{
				case "ON" :
					//SensorFirst instance =new SensorFirst();
					System.out.println("corr1 hum on");
					instance.smoke3.setBackground(Color.GREEN);
					instance.smoke3.setVisible(true);
					break;
				case "ALERTE":

					//SensorFirst instance1 =new SensorFirst();
					instance.smoke3.setBackground(Color.RED);
					instance.smoke3.setVisible(true);

				default : 
					//SensorFirst instance2 =new SensorFirst();

					instance.smoke3.setVisible(true);
					break;
				}
			}

			break;
		case "LIBRARY" :


			if (sensor.sensorType.toUpperCase() == "HUMIDITY")

			{



				switch(sensor.state.toUpperCase())
				{
				case "ON" :
					//SensorFirst instance =new SensorFirst();
					System.out.println("corr1 hum on");
					instance.humidityLIB.setBackground(Color.GREEN);
					instance.humidityLIB.setVisible(true);
					break;
				case "ALERTE":

					//SensorFirst instance1 =new SensorFirst();
					instance.humidityLIB.setBackground(Color.RED);
					instance.humidityLIB.setVisible(true);

				default : 
					//SensorFirst instance2 =new SensorFirst();

					instance.humidityLIB.setVisible(true);
					break;
				}
			}
			else 
			{


				switch(sensor.state.toUpperCase())
				{
				case "ON" :
					//SensorFirst instance =new SensorFirst();
					System.out.println("corr1 hum on");
					instance.smokeLIB.setBackground(Color.GREEN);
					instance.smokeLIB.setVisible(true);
					break;
				case "ALERTE":

					//SensorFirst instance1 =new SensorFirst();
					instance.smokeLIB.setBackground(Color.RED);
					instance.smokeLIB.setVisible(true);

				default : 
					//SensorFirst instance2 =new SensorFirst();

					instance.smokeLIB.setVisible(true);
					break;
				}
			}

			break;
		case "LIVINGROOM" :


			if (sensor.sensorType.toUpperCase() == "HUMIDITY")

			{



				switch(sensor.state.toUpperCase())
				{
				case "ON" :
					//SensorFirst instance =new SensorFirst();
					System.out.println("corr1 hum on");
					instance.humidityL.setBackground(Color.GREEN);
					instance.humidityL.setVisible(true);
					break;
				case "ALERTE":

					//SensorFirst instance1 =new SensorFirst();
					instance.humidityL.setBackground(Color.RED);
					instance.humidityL.setVisible(true);

				default : 
					//SensorFirst instance2 =new SensorFirst();

					instance.humidityL.setVisible(true);
					break;
				}
			}
			else 
			{


				switch(sensor.state.toUpperCase())
				{
				case "ON" :
					//SensorFirst instance =new SensorFirst();
					System.out.println("corr1 hum on");
					instance.smokeL.setBackground(Color.GREEN);
					instance.smokeL.setVisible(true);
					break;
				case "ALERTE":

					//SensorFirst instance1 =new SensorFirst();
					instance.smokeL.setBackground(Color.RED);
					instance.smokeL.setVisible(true);

				default : 
					//SensorFirst instance2 =new SensorFirst();

					instance.smokeL.setVisible(true);
					break;
				}
			}

			break;
		case "KITCHEN" :


			if (sensor.sensorType.toUpperCase() == "HUMIDITY")

			{



				switch(sensor.state.toUpperCase())
				{
				case "ON" :
					//SensorFirst instance =new SensorFirst();
					System.out.println("corr1 hum on");
					instance.humidityK.setBackground(Color.GREEN);
					instance.humidityK.setVisible(true);
					break;
				case "ALERTE":

					//SensorFirst instance1 =new SensorFirst();
					instance.humidityK.setBackground(Color.RED);
					instance.humidityK.setVisible(true);

				default : 
					//SensorFirst instance2 =new SensorFirst();

					instance.humidityK.setVisible(true);
					break;
				}
			}
			else 
			{


				switch(sensor.state.toUpperCase())
				{
				case "ON" :
					//SensorFirst instance =new SensorFirst();
					System.out.println("corr1 hum on");
					instance.smokeK.setBackground(Color.GREEN);
					instance.smokeK.setVisible(true);
					break;
				case "ALERTE":

					//SensorFirst instance1 =new SensorFirst();
					instance.smokeK.setBackground(Color.RED);
					instance.smokeK.setVisible(true);

				default : 
					//SensorFirst instance2 =new SensorFirst();

					instance.smokeK.setVisible(true);
					break;
				}
			}

			break;

		default : 
			break;
		}
	}


	public void start (){

		SerializationDriver ser = new SerializationDriver();

		System.out.println("start du back");
		Sensor sensor = new Sensor(location, SensorName, SensorType,State);
		ClientSocket client = new ClientSocket();
		try {
			System.out.println("ser");
			ser.serializer(sensor);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.getSocket(sensor);
		System.out.println("appeler a socket");
	} 




}
