package org.ClientModule;

import java.util.List;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Tools {
	
	public static String serializeObject(Object obj, Class Class, String message)
	{		
		String JSONobj = null;

		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		ObjectNode node = mapper.createObjectNode();
		message = (message == null) ? "" : message;
		System.out.println(message);
		node.put(JSONExample.ERROR.baseExample(), message);
		try {

			if(obj != null && Class != null)
			{
				
				if(obj instanceof List)
				{
					
					node.put(JSONExample.LIST.baseExample(), true);	
				}
				else
				{
					node.put(JSONExample.LIST.baseExample(), false);
				}				
				
				String className = Class.getName();
				
				node.put(JSONExample.PERIM.baseExample(), className);
				node.putPOJO(JSONExample.INFO.baseExample(), obj);
				
				}
			else
			{
					}

			JSONobj = mapper.writeValueAsString(node);
		} 
		catch (Exception e) 
		{
			System.out.println("ERROR " + obj.toString());
			System.out.println("Exception " +e.toString());
		}			
		System.out.println(JSONobj);
		return JSONobj;
	}
	
	// this function will be able to convert a json string into a java object
	public static Object deserializeObject(String objectInJSONString) {

		Object jstObj = null;
		ObjectMapper mapper = new ObjectMapper();

		try {

			if(objectInJSONString == null || objectInJSONString.trim().length() == 0)
				throw new Exception("Sorry, We can't load to serialize, check again!");

			JsonNode stringJs = mapper.readTree(objectInJSONString);
			// the next implementation corresponds to our enum JSONExample
			JsonNode perimNode = stringJs.get(JSONExample.PERIM.baseExample());
		
			JsonNode infoNode = stringJs.get(JSONExample.INFO.baseExample());
			
			JsonNode listNode = stringJs.get(JSONExample.LIST.baseExample());

			
			String className = perimNode.textValue();
			System.out.println(className);
			// the object <?> it is called a wildcard and it takes all kinds of objects in Java 
			Class<?> objectClass = Class.forName(className);

			boolean isListOfEntities = listNode.booleanValue();			

			if(isListOfEntities)
				jstObj = mapper.readValue(infoNode.toString(), mapper.getTypeFactory().constructCollectionType(List.class, objectClass));
			else
				jstObj = mapper.readValue(infoNode.toString(), objectClass);

			
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return jstObj;		
	}

	public static String jsonNode(JSONExample example, String js){
		String result = "";		

		try 
		{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode objectFromStringNode = mapper.readTree(js);
			JsonNode dataNode = objectFromStringNode.get(example.baseExample());
			result = dataNode.textValue();			
		} 
		catch (IOException e) 
		{
			}
			return result;
	}
	
	// this function should be able to reflect pretty line 
	// this function is not mandatory, but we implement it to get a pretty answer of Json
	public static String getPrettyJson(String jsString){
		ObjectMapper mapper = new ObjectMapper();
		// indent_ouput : display the answer in multiple lines, as a pretty display
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		try {
			JsonNode jsonNode = mapper.readTree(jsString);
			return mapper.writeValueAsString(jsonNode);
		} catch (IOException e) {
				return "";
		}
	}
	
	// this function will help us to serialize all kinds of request (CRUD). 
	public static String serializeQuery(Queries queryExample, Class entityClass,String serializedObject, 
			List<String> values) {	
		String objectToJSON = "";
			try {
				if(queryExample == null || entityClass == null)
					throw new IOException("Sorry, this information could not be empty !");
				else 
				{
				
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode rootNode = mapper.createObjectNode();
				ObjectNode requestNode = mapper.createObjectNode();

				if(serializedObject == null)
					serializedObject = "";
				else
				{
				JsonNode serializedObjectNode = mapper.readTree(serializedObject);

				requestNode.put(JSONExample.QUERY.baseExample(), queryExample.toString());		
				requestNode.put(JSONExample.PERIM.baseExample(), entityClass.getName());	
				requestNode.putPOJO(JSONExample.INFO.baseExample(), values);
				
				rootNode.putPOJO(JSONExample.INFO.baseExample(), requestNode);
				rootNode.putPOJO(JSONExample.SERIALIZE.baseExample(), serializedObjectNode);

				objectToJSON = mapper.writeValueAsString(rootNode);
				}
				}
		} catch (IOException e) {
			}

		return objectToJSON;
	}	

}
