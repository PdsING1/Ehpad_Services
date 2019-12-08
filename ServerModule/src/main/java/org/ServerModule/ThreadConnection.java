package org.ServerModule;

import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ThreadConnection implements Runnable {
	Socket soc;
	Connection connection; 
	private BufferedReader queryClient;
	// to be able to response the client
	private PrintWriter answerServer;
	private Object deserializedObject;

	public ThreadConnection(Socket soc, Connection connection) {
		System.out.println("arrive au constructeur ThreadConnection");
		this.soc = soc;
		this.connection = connection; 
		run();

	}


	@Override
	public void run() {


		//		try {

		//			Sensor sensors;
		//
		//			ObjectInputStream in;
		//
		//			ObjectOutputStream out;
		//
		//			try {
		//
		//				System.out.println("Serveur a accepte connexion: " + soc);
		//
		//
		//				out = new ObjectOutputStream(soc.getOutputStream());
		//
		//				out.flush();
		//
		//				System.out.println("ObjectOutputStream");
		//				in = new ObjectInputStream(soc.getInputStream());
		//				System.out.println("Input");
		//
		//				DeserializationDriver ser = new DeserializationDriver();
		//
		//				System.out.println("essayer de lire");
		//				objetRecu =  in.readObject();
		//				Sensor sensor = (Sensor) objetRecu;
		//
		//				SerializationDriver ser2 = new SerializationDriver();
		//
		//				String sens = ser2.serializer(sensor);
		//
		//				sensors = ser.deserializer(sens);
		//				System.out.println("appel insertSensors");
		//				boolean bool = ConnectionBDD.selectSensors2(sensors, pool);
		//				boolean bool2 = ConnectionBDD.selectSensors1(sensors, pool);
		//				if (!bool && !bool2)
		//				{
		//					ConnectionBDD.insertSensors(sensors, pool);
		//					System.out.println("Serveur a reçu les données du client " );
		//				}
		//
		//				in.close();
		//				out.close();
		//
		//				soc.close();
		//
		//
		//			} catch (ClassNotFoundException e) {
		//
		//				e.printStackTrace();
		//			} catch (IOException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//
		//		} catch (SQLException e1) {
		//			// TODO Auto-generated catch block
		//			e1.printStackTrace();
		//		}


		try {

			queryClient = new BufferedReader(new InputStreamReader(soc.getInputStream(), "UTF-8"));
			answerServer = new PrintWriter(new OutputStreamWriter(soc.getOutputStream(), "UTF-8"), true);

			System.out.println("start serveur");
			while (true){

				String rq = queryClient.readLine();
				System.out.println(rq);

				Sensor outputrq = getDoneQuery(rq);
				//answerServer.println(outputrq);
				
				System.out.println("appel insertSensors");
				
					ConnectionBDD.insertSensors(outputrq, connection);
					System.out.println("Serveur a reçu les données du client " );
				
				//soc.close();
//					  
  		    	        queryClient.close();
//                    
//                       answerServer.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public Sensor getDoneQuery(String jsQuery){		


		Sensor sensor = new Sensor();
		Jsonb jsonb = JsonbBuilder.create();

		sensor = jsonb.fromJson(jsQuery, Sensor.class);

		System.out.println(sensor);	
		return sensor;

	}






}
