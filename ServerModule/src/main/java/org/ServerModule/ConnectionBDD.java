package org.ServerModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectionBDD {

	public void insertSensors(Sensor sensor )
	{

		try { String strClassName = "com.mysql.cj.jdbc.Driver"; 
		String strUrl = "jdbc:mysql://hostname:3306;" 
				+ "user=root;password=;DatabaseName=ehpadservices"; 
		String strInsert = "INSERT INTO sensor " 
				+ "(location, sensorname, sensortype, state) " 
				+ "VALUES ('"+ sensor.location+"', '"+sensor.sensorName+"', '"+sensor.sensorType+"', '"+sensor.state+"');"; 
		Class.forName(strClassName); 
		Connection conn = DriverManager.getConnection(strUrl); 

		Statement getInf = conn.createStatement(); 
		getInf.executeUpdate(strInsert); 


		conn.close(); 
		} 
		catch(ClassNotFoundException e) { 
			System.out.print("ClassNotFound Class Connection");

		} catch(SQLException e) {
			System.out.println("SqlException Class Connection");
		} 
	}


}
