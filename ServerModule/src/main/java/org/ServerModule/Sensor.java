package org.ServerModule;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sensor implements Serializable{
	
	int id;
	String location ;
	String sensorName ;
	String sensorType ;
	String state; 
	
	@JsonCreator
	public Sensor(@JsonProperty("location") String location,@JsonProperty("sensorName") String sensorName,@JsonProperty("sensorType") String sensorType,@JsonProperty("state") String state)
	{
		this.location = location;
		this.sensorName = sensorName; 
		this.sensorType = sensorType;
		this.state = state;
	}
	
	public String toString()
	{
		return String.format("Sensor : [location :" + location + ",sensorName : " + sensorName +", sensorType :" + sensorType + ", sensorType :" + state+ " ]"); 
	}

}
 