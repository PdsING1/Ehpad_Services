package org.ServerModule;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
	
//	    Connection getConnection();
//	    boolean releaseConnection(Connection connection);
//	    String getUrl();
//	    String getUser();
//	    String getPassword();

	
    public void loadConnectionPool() throws SQLException;
	
	public Connection getConnection() throws Exception;
	
	public void putConnection(Connection connection);
	
	public void closeAllConnections();
	
}
