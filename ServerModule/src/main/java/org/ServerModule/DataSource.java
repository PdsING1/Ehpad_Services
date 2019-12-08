package org.ServerModule;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
	
	
	private static Pool connectionPool = new Pool();

	public DataSource() {}
	
	public static synchronized Connection getConnection(String myUrl, String user, String passwd)
	{
		try {
			return connectionPool.getConnection();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public static synchronized void putConnection(Connection connection){
		connectionPool.putConnection(connection);
	}
	

	public static void closeConnectionPool(){
		connectionPool.closeAllConnections();
	}
	
	public static void startConnectionPool() {
		try {
			connectionPool.loadConnectionPool();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}	
	
	public static int connectionsAvailable(){
		return connectionPool.connectionStillAlives();
	}

}
