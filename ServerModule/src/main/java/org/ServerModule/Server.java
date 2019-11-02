package org.ServerModule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.net.ServerSocket;

public class Server implements Runnable
{
	static final int port = 9999;

	public static void main(String[] args)
	{
		Runnable runnable = new Server();
		Thread thread = new Thread(runnable);
		thread.start();

	}

	public void run() {
		Object objetRecu ;
		String url="jdbc:mysql://localhost:3306/ehpadservices?serverTimezone=UTC";
		String userName="root";
		String pwd = "";

		try {
			Pool pool = Pool.create(url, userName, pwd);

			ServerSocket s = new ServerSocket(port);
			System.out.println("Socket serveur: " + s);
			
		
			Socket soc;
			ObjectInputStream in;

			ObjectOutputStream out;

			while(true)
			{
				try {
					soc = s.accept();
					System.out.println("Serveur a accepte connexion: " + soc);


					out = new ObjectOutputStream(soc.getOutputStream());

					out.flush();

					System.out.println("ObjectOutputStream");
					in = new ObjectInputStream(soc.getInputStream());
					System.out.println("Input");
					
					DeserializationDriver ser = new DeserializationDriver();

					System.out.println("essayer de lire");
					objetRecu =  in.readObject();
					Sensor sensor = (Sensor) objetRecu;
					Sensor sensors = ser.deserializer(sensor);
					System.out.println("appel insertSensors");
					ConnectionBDD.insertSensors(sensors, pool);
					System.out.println("Serveur a reçu les données du client " );
					
					
					in.close();
					out.close();
					
					soc.close();
					
					
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			


		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}

}
