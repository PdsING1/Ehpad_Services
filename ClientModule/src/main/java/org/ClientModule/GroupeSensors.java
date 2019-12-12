package org.ClientModule;

import java.util.ArrayList;
import java.util.List;

public class GroupeSensors {
	
	private final List<org.ServerModule.Sensor> sensors = new ArrayList();

	  public GroupeSensors() {
	    super();
	   
	  }

	  
	  public List<org.ServerModule.Sensor> getSensors() {
	    return this.sensors;
	  }

	  public void ajouter(final org.ServerModule.Sensor sensor) {
	    this.sensors.add(sensor);
	  }

	  @Override
	  public String toString() {
	    return "GroupeSensors [ Sensor=" + this.sensors  + "]";
	  }
	  
	  

}
