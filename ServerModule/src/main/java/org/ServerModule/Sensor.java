package org.ServerModule;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



public class Sensor implements Serializable{
	
	//int id;
	public String location ;
	public String sensorName ;
	public String sensorType ;
	public String state; 
	public String query; 
	
	@JsonCreator
	public Sensor (@JsonProperty("query") String query)
	{
		this.query = query;
	}
	

	public Sensor(@JsonProperty("query") String query , @JsonProperty("location") String location,@JsonProperty("sensorName") String sensorName,@JsonProperty("sensorType") String sensorType,@JsonProperty("state") String state)
	{
		this.query = query;
		this.location = location;
		this.sensorName = sensorName; 
		this.sensorType = sensorType;
		this.state = state;
	}
	
	@JsonCreator
	public Sensor(@JsonProperty("location") String location,@JsonProperty("sensorName") String sensorName,@JsonProperty("sensorType") String sensorType,@JsonProperty("state") String state)
	{
		this.location = location;
		this.sensorName = sensorName; 
		this.sensorType = sensorType;
		this.state = state;
	}
	public Sensor() {
		// TODO Auto-generated constructor stub
	}

	public Sensor(Object object) {
		// TODO Auto-generated constructor stub
	}
	
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	
	public String toString() {
		return "Sensor [ query =" + query + ", location=" + getLocation() + ", sensorName=" + getSensorName() + ", sensorType=" + getSensorType() + ", state=" + getState() +"]";
	}

}
 


 