package org.ServerModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





public class ConnectionBDD {

	
	public static List<Sensor> selectAllSensors( Pool pool) throws SQLException {
		Connection conn = pool.getConnection();

		String strSelectCount = "SELECT *  FROM sensor ;" ;
	
        List<Sensor>  list= new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement(strSelectCount);
			
			ResultSet resultats = ps.executeQuery();

			while(resultats.next())
			{
				int col1= resultats.getInt(1);
				String col2 = resultats.getString(2);
				String col3 = resultats.getString(3);
				String col4 = resultats.getString(4);
				String col5 = resultats.getString(5);
				
				Sensor sensor1 = new Sensor(col2, col3, col4, col5);
				list.add(sensor1);
			
			}
		
			resultats.close();
			ps.close();




		}
		catch (SQLException e) {

		}


		conn.close();
		return null;


	}

	public static boolean selectSensors1(Sensor sensor, Connection conn) throws SQLException {
		

		String strSelectCount = "SELECT idsensor, location, sensorname, sensortype, state  FROM sensor WHERE location = ? AND sensorname = ? AND sensortype = ? AND state = ? ;" ;
		boolean bool = true;


		try {
			PreparedStatement ps = conn.prepareStatement(strSelectCount);
			ps.setString(1, sensor.getLocation().toUpperCase() );
			ps.setString(2, sensor.getSensorName().toUpperCase() );
			ps.setString(3, sensor.getSensorType().toUpperCase() );
			ps.setString(4, sensor.getState().toUpperCase() );


			ResultSet resultats = ps.executeQuery();

			bool = resultats.next();
			resultats.close();
			ps.close();




		}
		catch (SQLException e) {

		}


		//conn.close();
		return bool;


	}

	public static boolean selectSensors2(Sensor sensor, Connection conn) {
		


		String strSelectCountFilter = "SELECT idsensor, location,sensortype FROM sensor WHERE location = ? AND sensortype = ? ;" ;

		boolean bool = false ;

		try {
			PreparedStatement ps = conn.prepareStatement(strSelectCountFilter);
			ps.setString(1, sensor.location.toUpperCase() );
			ps.setString(2, sensor.sensorType.toUpperCase() );

			ResultSet resultats = ps.executeQuery();
            int nb = resultats.getFetchSize();
			
            if(nb < 2 )
            {
			bool = false;
            }
            else {
            	bool = true;
            }
			resultats.close();
			ps.close();




		}
		catch (SQLException e) {
			
			

		}
	//	try {
			//conn.close();
		
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return bool;

	}
	
	
	public static List<Sensor> find( Connection connection) {
		List<Sensor> sensorList = new ArrayList<Sensor>();

		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SENSOR");
				ResultSet rs = preparedStatement.executeQuery();
				Sensor sensor ;
				while (rs.next()) {
					
					sensor = sensorsHandler(rs);
					if(sensor != null)
					{
						sensorList.add(sensor);
					}
				}
			} catch (Exception e) {
					e.printStackTrace();
			}
		}

		return sensorList;
	}
	
	
	public static void updateSensors(Sensor sensor, Connection conn )
	{
       String strDelete = "UPDATE sensor SET state = 'ON' where state ='ALERTE' AND location ='" 
				
				+sensor.location.toUpperCase()+"';"; 

		System.out.println("totoUpdate");
		Statement getInf;
		
		try {
			getInf = conn.createStatement();


			getInf.executeUpdate(strDelete);

			System.out.println("totoUpdateOK");


			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	public static  Sensor sensorsHandler(ResultSet rs) {
		{
			Sensor sensors = null;
			try {
				sensors = new Sensor(rs.getString("location"), rs.getString("sensorname"), rs.getString("sensortype"), rs.getString("state"));
			} catch (SQLException e) {
		    }
			return sensors;
		}
	}
	
	public static void deleteSensor (Sensor sensor, Connection conn )
	{
		
		String strDelete = "DELETE FROM sensor where " 
				
				+ "location = '"+sensor.location.toUpperCase()+"' AND sensorname = '"+sensor.sensorName.toUpperCase()+"' AND sensortype = '"+sensor.sensorType.toUpperCase()+"' AND state = '"+sensor.state.toUpperCase()+"';"; 

		System.out.println("totoDelete");
		Statement getInf;
		
		try {
			getInf = conn.createStatement();


			getInf.executeUpdate(strDelete);

			System.out.println("toto5");


			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
	}

	public static  void insertSensors(Sensor sensor, Connection conn )
	{
//		String url="jdbc:mysql://localhost:3306/ehpadservices?serverTimezone=UTC";
//		String userName="root";
//		String pwd = "";
//
//		String ls1 = "";
//		String ls2 = "";
//		String strClassName = "com.mysql.cj.jdbc.Driver"; 
//		
		
	
		

		String strInsert = "INSERT INTO sensor " 
				+ "(location, sensorname, sensortype, state) " 
				+ "VALUES ('"+ sensor.location.toUpperCase()+"', '"+sensor.sensorName.toUpperCase()+"', '"+sensor.sensorType.toUpperCase()+"', '"+sensor.state.toUpperCase()+"');"; 




		
		System.out.println("toto6");
		Statement getInf2;
		try {
			getInf2 = conn.createStatement();


			getInf2.executeUpdate(strInsert);

			System.out.println("toto5");


			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


	}
}
