package org.ServerModule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.ServerSocket;

public class Server 
{
	static final int port = 9999;
	public static void main(String args[]) throws IOException {
		Object objetRecu ;

		ServerSocket s = new ServerSocket(port);
		System.out.println("Socket serveur: " + s);

		Socket soc = s.accept();

		System.out.println("Serveur a accepte connexion: " + soc);

		ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
		out.flush();

		System.out.println("ObjectOutputStream");
		ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
		System.out.println("Input");



		try {
			DeserializationDriver ser = new DeserializationDriver();
			 
			System.out.println("essayer de lire");
			objetRecu =  in.readObject();
			Sensor sensor = (Sensor) objetRecu;
			Sensor sensors = ser.deserializer(sensor);
			System.out.println("appel insertSensors");
			ConnectionBDD.insertSensors(sensors);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}


		System.out.println("Serveur a reçu les données du client " );

		in.close();
		out.close();
		soc.close();



	}

}
