package org.ClientModule;

import org.ServerModule.Sensor;
import org.ServerModule.SerializationDriver;

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
	
	
	public void start (){
		
		SerializationDriver ser = new SerializationDriver();
	
		System.out.println("start du back");
		Sensor sensor = new Sensor(location, SensorName, SensorType,State);
		ClientSocket client = new ClientSocket();
		ser.serializer(sensor);
		client.getSocket(sensor);
		System.out.println("appeler a socket");
	} 
	  

}
