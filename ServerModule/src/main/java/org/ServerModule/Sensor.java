package org.ServerModule;

public class Sensor {
	
	int id;
	String location ;
	String sensorName ;
	String sensorType ;
	Boolean state; 
	
	public Sensor(String location,String sensorName,String sensorType, Boolean state)
	{
		this.location = location;
		this.sensorName = sensorName; 
		this.sensorType = sensorType;
		this.state = state;
	}

}
