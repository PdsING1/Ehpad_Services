package org.ClientModule;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



public class Sensor implements Serializable{
	
	//int id;
	String location ;
	String sensorName ;
	String sensorType ;
	String state; 
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Sensor ()
	{
		
	}

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
	

		final StringBuffer sb = new StringBuffer("Sensor{");
		sb.append("location=").append(location);
		sb.append(", sensorName='").append(sensorName).append('\'');
		sb.append(", sensorType='").append(sensorType).append('\'');
		sb.append(", state='").append(state).append('\'');
		
		sb.append('}');
		return sb.toString();
	
	
	}

}
 


 