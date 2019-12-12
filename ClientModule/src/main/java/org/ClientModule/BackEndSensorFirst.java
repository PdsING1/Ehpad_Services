package org.ClientModule;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.swing.JButton;

import org.ServerModule.Sensor;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BackEndSensorFirst implements ActionListener {

	

	public String location;
	public String sensorName;
	public String sensorType; 
	public String state;


	public BackEndSensorFirst(SensorFirst sensorFirst) {
		
	}



	public void start(){

		System.out.println("action Window Opened");
		ClientSocket client = new ClientSocket();

		Sensor sensor = new Sensor();
		sensor.query = "SELECT";
		sensor.location = "location";
		sensor.sensorName ="sensorName"  ;
		sensor.sensorType = "sensorType" ;
		sensor.state = "state" ;

		SensorFirst sensorFirst = new SensorFirst(1);
	    sensorFirst.setVisible(true);


		System.out.println(sensor.toString());
		Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(sensor);
		System.out.println(result);



		String answer = client.getSocket(result);

		List<Sensor> sensors = getDeserializedObject(answer);
		
		
		for (int i = 0; i < sensors.size (); i++)
		{

			if(	sensors.get(i).location.toUpperCase().equals("CORRIDOR1"))
			{
				if(sensors.get(i).state.toUpperCase().equals("ON"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.GREEN);
						btn.setBounds(50, 50,50,50);
						
						
						sensorFirst.corridor1.add(btn);
					
						
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.GREEN);
						btn.setBounds(50, 50,50,50);
						sensorFirst.corridor1.add(btn);
						btn.setVisible(true);

					}else {}

				}else if(sensors.get(i).state.toUpperCase().equals("OFF"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.GRAY);
						btn.setBounds(50, 50,50,50);
						sensorFirst.corridor1.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.GRAY);
						btn.setBounds(50, 50,50,50);
						sensorFirst.corridor1.add(btn);
						btn.setVisible(true);

					}else {}

				}else if(sensors.get(i).state.toUpperCase().equals("ALERTE"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.RED);
						btn.setBounds(50, 50,50,50);
						sensorFirst.corridor1.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.RED);
						btn.setBounds(50, 50,50,50);
						sensorFirst.corridor1.add(btn);
						btn.setVisible(true);

					}else {}

				}else
				{

				}

			}else if(	sensors.get(i).location.toUpperCase().equals("CORRIDOR2"))
			{
				if(sensors.get(i).state.toUpperCase().equals("ON"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.GREEN);
						btn.setBounds(50, 50,50,50);
						sensorFirst.panelCorridor2.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.GREEN);
						btn.setBounds(50, 50,50,50);
						sensorFirst.panelCorridor2.add(btn);
						btn.setVisible(true);

					}else {}

				}else if(sensors.get(i).state.toUpperCase().equals("OFF"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.GRAY);
						btn.setBounds(50, 50,50,50);
						sensorFirst.panelCorridor2.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.GRAY);
						btn.setBounds(50, 50,50,50);
						sensorFirst.panelCorridor2.add(btn);
						btn.setVisible(true);

					}else {}

				}else if(sensors.get(i).state.toUpperCase().equals("ALERTE"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.RED);
						btn.setBounds(50, 50,50,50);
						sensorFirst.panelCorridor2.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.RED);
						btn.setBounds(50, 50,50,50);
						sensorFirst.panelCorridor2.add(btn);
						btn.setVisible(true);

					}else {}

				}else
				{

				}

			}else if(	sensors.get(i).location.toUpperCase().equals("KITCHEN"))
			{
				if(sensors.get(i).state.toUpperCase().equals("ON"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.GREEN);
						btn.setBounds(30, 30,30,30);
						sensorFirst.kitchen.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.GREEN);
						btn.setBounds(30, 30,30,30);
						sensorFirst.kitchen.add(btn);
						btn.setVisible(true);

					}else {}

				}else if(sensors.get(i).state.toUpperCase().equals("OFF"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.GRAY);
						btn.setBounds(30, 30,30,30);
						sensorFirst.kitchen.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.GRAY);
						btn.setBounds(30, 30,30,30);
						sensorFirst.kitchen.add(btn);
						btn.setVisible(true);

					}else {}

				}else if(sensors.get(i).state.toUpperCase().equals("ALERTE"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.RED);
						btn.setBounds(30, 30,30,30);
						sensorFirst.kitchen.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.RED);
						btn.setBounds(30, 30,30,30);
						sensorFirst.kitchen.add(btn);
						btn.setVisible(true);

					}else {}

				}else
				{

				}

			}else if(	sensors.get(i).location.toUpperCase().equals("LIBRARY"))
			{
				if(sensors.get(i).state.toUpperCase().equals("ON"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.GREEN);
						btn.setBounds(30, 30,30,30);
						sensorFirst.panelLibrary.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.GREEN);
						btn.setBounds(30, 30,30,30);
						sensorFirst.panelLibrary.add(btn);
						btn.setVisible(true);

					}else {}

				}else if(sensors.get(i).state.toUpperCase().equals("OFF"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.GRAY);
						btn.setBounds(30, 30,30,30);
						sensorFirst.panelLibrary.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.GRAY);
						btn.setBounds(30, 30,30,30);
						sensorFirst.panelLibrary.add(btn);
						btn.setVisible(true);
					}else {}

				}else if(sensors.get(i).state.toUpperCase().equals("ALERTE"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.RED);
						btn.setBounds(30, 30,30,30);
						sensorFirst.panelLibrary.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.RED);
						btn.setBounds(30, 30,30,30);
						sensorFirst.panelLibrary.add(btn);
						btn.setVisible(true);

					}else {}

				}else
				{

				}

			}else if(	sensors.get(i).location.toUpperCase().equals("LIVINGROOM"))
			{
				if(sensors.get(i).state.toUpperCase().equals("ON"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.GREEN);
						btn.setBounds(30, 30,30,30);
						sensorFirst.panelLivingRoom.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.GREEN);
						btn.setBounds(30, 30,30,30);
						sensorFirst.panelLivingRoom.add(btn);
						btn.setVisible(true);

					}else {}

				}else if(sensors.get(i).state.toUpperCase().equals("OFF"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.GRAY);
						btn.setBounds(30, 30,30,30);
						sensorFirst.panelLivingRoom.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.GRAY);
						btn.setBounds(30, 30,30,30);
						sensorFirst.panelLivingRoom.add(btn);
						btn.setVisible(true);

					}else {}

				}else if(sensors.get(i).state.toUpperCase().equals("ALERTE"))
				{
					if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
					{
						JButton btn = new JButton("F");
						btn.setBackground(Color.RED);
						btn.setBounds(30, 30,30,30);
						sensorFirst.panelLivingRoom.add(btn);
						btn.setVisible(true);

					}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
					{
						JButton btn = new JButton("H");
						btn.setBackground(Color.RED);
						btn.setBounds(30, 30,30,30);
						sensorFirst.panelLivingRoom.add(btn);
						btn.setVisible(true);

					}else {}

				}else
				{

				}

			}else
			{

			}

		}


	}

	public List<Sensor> getDeserializedObject(String jsQuery){		

		
		List<Sensor> liste = new ArrayList();
//		Jsonb jsonb = JsonbBuilder.create();
//
//		final GroupeSensors groupe = jsonb.fromJson(jsQuery, GroupeSensors.class);
//
//		System.out.println(groupe);	
		
		Jsonb jsonb = JsonbBuilder.create();
		 
		Sensor[] sensorArray = jsonb.fromJson(jsQuery, Sensor[].class);  
		 
		for(Sensor sensor : sensorArray) {
			liste.add(sensor);
			System.out.println(sensor);	
		
		}
		
		return liste;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}




}

