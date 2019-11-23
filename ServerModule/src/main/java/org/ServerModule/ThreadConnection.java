package org.ServerModule;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

public class ThreadConnection implements Runnable {
	Socket soc;

	public ThreadConnection(Socket soc) {
		System.out.println("arrive au constructeur ThreadConnection");
		this.soc = soc;
		run();

	}


	@Override
	public void run() {
		System.out.println("arrive au run");
		Object objetRecu ;
		String url="jdbc:mysql://localhost:3306/ehpadservices?serverTimezone=UTC";
		String userName="root";
		String pwd = "";

		Pool pool;
		try {
			pool = Pool.create(url, userName, pwd);



			ObjectInputStream in;

			ObjectOutputStream out;

			try {

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

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
