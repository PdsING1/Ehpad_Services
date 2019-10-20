package org.ServerModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDriver {

	public  void serializer(Sensor sensor)
	{
		try {
			
		    System.out.println(sensor.toString());
		    
		    FileOutputStream fos = new FileOutputStream("C:\\Users\\dassy\\eclipse-workspace5\\Ehpad_Services\\Sensors.txt");
		    
            ObjectOutputStream oos = new ObjectOutputStream(fos);
           
            System.out.println("ObjectOutputStream ");
		    oos.writeObject(sensor);
		    
			System.out.println("Serialisation effectuée");
			System.out.println("Serialisation effectuée");
            oos.close();


		} catch (FileNotFoundException e) {

			System.out.println("Erreur de serialization");
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("Erreur au niveau de ObjectOutputStream ");
			e.printStackTrace();
		}
	}
	
	
	

}
