package org.ServerModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;

public class SensorsDAO extends AbDAO<Sensor> {
	
	// to be able to convert Json into a readable file
			private JsonFactory factory = new JsonFactory();
			
			
			public SensorsDAO(Connection connection) {
				super(connection);
				// TODO Auto-generated constructor stub
			}
			
			private Sensor sensorsHandler(ResultSet rs) {
				{
					Sensor sensors = null;
					try {
						sensors = new Sensor(rs.getString("location"), rs.getString("sensorName"), rs.getString("sensorType"), rs.getString("state"));
					} catch (SQLException e) {
							}
					return sensors;
				}
			}
			
			public Sensor create(Sensor sensors) {
				// TODO Auto-generated method stub
				if(connection != null)
				{
					try {
						PreparedStatement preparedStatement = connection
								.prepareStatement("INSERT INTO sensor (location, sensorName, sensorType, state)"
										+ " VALUES (? , ? , ? , ? )", Statement.RETURN_GENERATED_KEYS);
						preparedStatement.setString(1, sensors.getLocation());
						preparedStatement.setString(2, sensors.getSensorName());
						preparedStatement.setString(3, sensors.getSensorType());
						preparedStatement.setString(4, sensors.getState());
			
						preparedStatement.execute();
						ResultSet rs = preparedStatement.getGeneratedKeys();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}	
				return sensors;
			}

			
			@Override
			public void delete(Sensor obj) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public List<Sensor> find(List<String> values) {
				List<Sensor> sensorList = new ArrayList<Sensor>();

				if(connection != null)
				{
					try {
						PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SENSOR");
						ResultSet rs = preparedStatement.executeQuery();
						Sensor sensor;
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

			@Override
			public List<Sensor> findAll() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void update(Sensor obj) {
				// TODO Auto-generated method stub
				
			}


}
