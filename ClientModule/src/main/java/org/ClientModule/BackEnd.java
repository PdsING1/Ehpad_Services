package org.ClientModule;

import org.ServerModule.Sensor;

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
	
		
		Sensor sensor = new Sensor(location, SensorName, SensorType,State);
		
	}
	  

}
