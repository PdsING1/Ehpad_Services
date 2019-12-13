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
		

	}


	@Override
	public void run() {




		try {

			queryClient = new BufferedReader(new InputStreamReader(soc.getInputStream(), "UTF-8"));
			answerServer = new PrintWriter(new OutputStreamWriter(soc.getOutputStream(), "UTF-8"), true);

			System.out.println("start serveur");
			while (true){

				String rq = queryClient.readLine();
				System.out.println(rq);
				if ((rq == null) || rq.equalsIgnoreCase("QUIT")) {
					soc.close();
					return;
				} else {

					Sensor outputrq = getDoneQuery(rq);
					//answerServer.println(outputrq);

					System.out.println(outputrq.toString());


					if (outputrq.getQuery().equals( "INSERT"))
					{
						System.out.println("appel insertSensors");
						ConnectionBDD.insertSensors(outputrq, connection);
					}
					else if (outputrq.getQuery().equals( "SELECT"))
					{

						List<Sensor> sensors = ConnectionBDD.find(connection); 
						Jsonb jsonb = JsonbBuilder.create();
						String result = jsonb.toJson(sensors);
						System.out.println(result);

						answerServer.println(result);

					}
					else if (outputrq.getQuery().equals( "DELETE"))
					{
						ConnectionBDD.deleteSensor(outputrq, connection);
					}


					else 
					{
						System.out.println("Aucune requête demandée ! " );
					}
					System.out.println("Serveur a reçu les données du client " );

					//soc.close();
					
					answerServer.flush();

				}
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
