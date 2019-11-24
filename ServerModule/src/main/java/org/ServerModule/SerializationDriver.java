package org.ServerModule;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class SerializationDriver  {

	

		public  String serializer(Sensor sensor) throws JsonProcessingException
		{
			//		try {
			//			
			//		    System.out.println(sensor.toString());
			//		    
			//		    FileOutputStream fos = new FileOutputStream("C:\\Users\\dassy\\eclipse-workspace5\\Ehpad_Services\\Sensors.txt");
			//		    
			//            ObjectOutputStream oos = new ObjectOutputStream(fos);
			//           
			//            System.out.println("ObjectOutputStream ");
			//		    oos.writeObject(sensor);
			//		    
			//			System.out.println("Serialisation effectuée");
			//			System.out.println("Serialisation effectuée");
			//            oos.close();
			//
			//
			//		} catch (FileNotFoundException e) {
			//
			//			System.out.println("Erreur de serialization");
			//			e.printStackTrace();
			//		}catch (IOException e) {
			//			System.out.println("Erreur au niveau de ObjectOutputStream ");
			//			e.printStackTrace();
			//		}

	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			final String json = objectMapper.writeValueAsString(sensor);
			System.out.println(json);
			return json;
			



		}
	
}
