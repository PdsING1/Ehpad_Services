package org.ServerModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectionBDD {

	public static  void insertSensors(Sensor sensor, Pool pool )
	{
		String url="jdbc:mysql://localhost:3306/ehpadservices?serverTimezone=UTC";
		String userName="root";
		String pwd = "";
		

		try { String strClassName = "com.mysql.cj.jdbc.Driver"; 
		
//		
//	    System.out.println("toto1");
//	       
//		Class.forName(strClassName); 
//		 System.out.println("toto2");
//		Connection conn = DriverManager.getConnection(url,userName,pwd); 
//		 System.out.println("toto3");
		
//		
		Connection conn = pool.getConnection();
		
		 String strInsert = "INSERT INTO sensor " 
					+ "(location, sensorname, sensortype, state) " 
					+ "VALUES ('"+ sensor.location+"', '"+sensor.sensorName+"', '"+sensor.sensorType+"', '"+sensor.state+"');"; 
			
		Statement getInf = conn.createStatement(); 
		 System.out.println("toto4");
		getInf.executeUpdate(strInsert); 

		 System.out.println("toto5");
		//conn.close(); 
		} 
		catch(SQLException e) {
			System.out.println("SqlException Class ConnectionBDD");
		} 
	}
			

}
