package org.ServerModule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDriver {
	
	public  Sensor deserializer(Sensor sensor)
	{
		try {
			
			FileInputStream  fis = new FileInputStream("C:\\Users\\dassy\\eclipse-workspace5\\Ehpad_Services\\Sensors.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
		   
				ois.readObject();
				System.out.println(sensor);
				
				System.out.println("Deserialisation effectuée");
				
				
		    ois.close();
		    return sensor;
		   
		}catch (IOException e) {
			System.out.println("");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.println("Erreur de lecture de la deserialiser");
			e.printStackTrace();
		}
		return null;
		
	}

}
