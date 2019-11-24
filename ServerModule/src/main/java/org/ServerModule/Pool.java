package org.ServerModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pool implements ConnectionPool {

	private String url;
	private String user;
	private String password;
	private List<Connection> connectionPool;
	private List<Connection> usedConnections = new ArrayList<>();
	private static int INITIAL_POOL_SIZE = 10;

	public Pool(String url2, String user2, String password2, List<Connection> pool) {
		this.password = password2;
		this.url = url2;
		this.user = user2;
		this.connectionPool = pool;
	}

	public static Pool create(
			String url, String user, 
			String password) throws SQLException {

		List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
		for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
			pool.add(createConnection(url, user, password));
		}
		return new Pool(url, user, password, pool);
	}

	@Override
	public Connection getConnection() {

		Connection connection = connectionPool
				.remove(connectionPool.size() - 1);
		usedConnections.add(connection);
		return connection;
	}
	@Override
	public boolean releaseConnection(Connection connection) {
		connectionPool.add(connection);
		return usedConnections.remove(connection);
	}

	private static Connection createConnection(
			String url, String user, String password) 
					throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	public int getSize() {
		return connectionPool.size() + usedConnections.size();
	}
	@Override
	public String getUrl() {
		return this.url;
	}
	@Override
	public String getUser() {
		return this.user;
	}
	@Override
	public String getPassword() {
		return this.password;
	}



}
