package org.ServerModule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializationDriver {
	

	public  Sensor deserializer(String sensor)
	{
		//		try {

		//			FileInputStream  fis = new FileInputStream("C:\\Users\\dassy\\eclipse-workspace5\\Ehpad_Services\\Sensors.txt");
		//            ObjectInputStream ois = new ObjectInputStream(fis);
		//		   
		//				ois.readObject();
		//				System.out.println(sensor);
		//				
		//				System.out.println("Deserialisation effectuée");
		//				
		//				
		//		    ois.close();
		//		    return sensor;
		//		   
		//		}catch (IOException e) {
		//			System.out.println("");
		//			e.printStackTrace();
		//		}catch (ClassNotFoundException e) {
		//			System.out.println("Erreur de lecture de la deserialiser");
		//			e.printStackTrace();
		//		
		//		return null;

		
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			
			final Sensor sensor2 = objectMapper.readValue(sensor, Sensor.class);
			 System.out.println(sensor2);
			return sensor2;
//     		ObjectMapper mapper = new ObjectMapper();
//     		return ( mapper.readValue(sensor.toString(), Sensor.class));
//			 
//			String json = sensor.toString();
//			JsonNode jsonNode = mapper.readTree(json);
			
			
//			
//			Sensor sensor2 = null;
//			
//			sensor2.location = jsonNode.get("location").asText();
//			sensor2.sensorName = jsonNode.get("sensorName").asText();
//			sensor2.sensorType = jsonNode.get("sensorType").asText();
//			sensor2.state = jsonNode.get("state").asText();
//			
//			return sensor2;
//			
			
		} catch (JsonParseException e) {
			
			
			
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null ;

	}

}
