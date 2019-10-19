package org.ServerModule;

public class Sensor {
	
	int id;
	String location ;
	String sensorName ;
	String sensorType ;
	String state; 
	
	public Sensor(String location,String sensorName,String sensorType, String state)
	{
		this.location = location;
		this.sensorName = sensorName; 
		this.sensorType = sensorType;
		this.state = state;
	}

}
 