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

			Sensor sensors;

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

				SerializationDriver ser2 = new SerializationDriver();

				String sens = ser2.serializer(sensor);

				sensors = ser.deserializer(sens);
				System.out.println("appel insertSensors");
				boolean bool = ConnectionBDD.selectSensors2(sensors, pool);
				boolean bool2 = ConnectionBDD.selectSensors1(sensors, pool);
				if (!bool && !bool2)
				{
					ConnectionBDD.insertSensors(sensors, pool);
					System.out.println("Serveur a reçu les données du client " );
				}

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
