package org.ServerModule;

import java.sql.Connection;

public class DAOHundler {
	
public static AbDAO  getDAOHandler(Connection connection, Class entityClass) throws Exception {
		
		// run some test with sysout
		// TODO remvoe sysout
		
		 if(entityClass.equals(Sensor.class)){
			System.out.println("not here");
			return new SensorsDAO(connection);
		}
		else{
			System.out.println("Not found !!");
		
			throw new Exception();
			}
	}


}
