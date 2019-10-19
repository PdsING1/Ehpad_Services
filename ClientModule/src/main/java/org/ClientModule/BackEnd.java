package org.ClientModule;



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
	
	public boolean convert(String s) {
		  if(s.toUpperCase() =="ON") return true;
		  else return false;
		}
	
	
	public void start (){
		
		boolean state = convert(State);
		
		//Sensor sensor = new Sensor(location, SensorName, SensorType,state);
		
	}
	

}
