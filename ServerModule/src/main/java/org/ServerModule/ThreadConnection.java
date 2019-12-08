package org.ServerModule;

import java.util.List;
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
		run();

	}


	@Override
	public void run() {


		//		try {

		//			Sensor sensors;
		//
		//			ObjectInputStream in;
		//
		//			ObjectOutputStream out;
		//
		//			try {
		//
		//				System.out.println("Serveur a accepte connexion: " + soc);
		//
		//
		//				out = new ObjectOutputStream(soc.getOutputStream());
		//
		//				out.flush();
		//
		//				System.out.println("ObjectOutputStream");
		//				in = new ObjectInputStream(soc.getInputStream());
		//				System.out.println("Input");
		//
		//				DeserializationDriver ser = new DeserializationDriver();
		//
		//				System.out.println("essayer de lire");
		//				objetRecu =  in.readObject();
		//				Sensor sensor = (Sensor) objetRecu;
		//
		//				SerializationDriver ser2 = new SerializationDriver();
		//
		//				String sens = ser2.serializer(sensor);
		//
		//				sensors = ser.deserializer(sens);
		//				System.out.println("appel insertSensors");
		//				boolean bool = ConnectionBDD.selectSensors2(sensors, pool);
		//				boolean bool2 = ConnectionBDD.selectSensors1(sensors, pool);
		//				if (!bool && !bool2)
		//				{
		//					ConnectionBDD.insertSensors(sensors, pool);
		//					System.out.println("Serveur a reçu les données du client " );
		//				}
		//
		//				in.close();
		//				out.close();
		//
		//				soc.close();
		//
		//
		//			} catch (ClassNotFoundException e) {
		//
		//				e.printStackTrace();
		//			} catch (IOException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//
		//		} catch (SQLException e1) {
		//			// TODO Auto-generated catch block
		//			e1.printStackTrace();
		//		}


		try {

			queryClient = new BufferedReader(new InputStreamReader(soc.getInputStream(), "UTF-8"));
			answerServer = new PrintWriter(new OutputStreamWriter(soc.getOutputStream(), "UTF-8"), true);

			System.out.println("start serveur");
			while (true){

				String rq = queryClient.readLine();
				System.out.println(rq);

				String outputrq = getDoneQuery(rq);
				answerServer.println(outputrq);
			}

		} catch (IOException e) {
			e.printStackTrace();
			try {
				exit();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private void exit() throws IOException {
		DataSource.putConnection(connection);
		this.connection=null;
		soc.close();	
	}
	public String getDoneQuery(String jsQuery){		
		String execution = "";
		try {
			System.out.println("TITI1");
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("TITI2");
			JsonNode js = mapper.readTree(jsQuery);
			System.out.println(js);
			JsonNode QNode = js.get(JSONExample.INFO.baseExample());
			System.out.println("TITI3");
			
			String perim = QNode.get(JSONExample.PERIM.baseExample()).textValue();
			System.out.println("TITI4");
			
			Class<?> perimCl = Class.forName(perim);
			
			System.out.println(perimCl);
			JsonNode seriaObjN = js.get(JSONExample.SERIALIZE.baseExample());
			System.out.println("Serialisation");
			System.out.println(seriaObjN);
			Queries siud = Queries.getQueries(QNode.get(JSONExample.QUERY.baseExample()).textValue());
			System.out.println(siud);
			System.out.println("okkkk");
			switch(siud){
			case SELECT:
				execution = select(perimCl, seriaObjN);
				break;
			case INSERT:
				execution = insert(perimCl, seriaObjN);
				break;
			case DELETE:
				execution =  delete(perimCl,  seriaObjN);
				break;
			}

		} 
		catch (Exception e) {
			}
		System.out.println(execution);	
		return execution;

	}


	// this function will handle the insert request, new data
	private String insert(Class<?> perimCl,JsonNode srzdONode) throws Exception{
		
		System.out.println(" deserialize start ");
		Object deserializedObject = Tools.deserializeObject(srzdONode.toString());
		System.out.println(" deserialize fin ");
		System.out.println(perimCl);
		System.out.println(deserializedObject);
		AbDAO d = DAOHundler.getDAOHandler(connection, perimCl);
		System.out.println(d);
		System.out.println(" step 1 start ");
		Object obj = d.create(perimCl.cast(deserializedObject));
		System.out.println(" step 2 start ");
		String result = Tools.serializeObject(perimCl.cast(obj),perimCl, "");
		System.out.println(" step 3 start ");

		return result;
	}

	// this function will handle the delete request.
	private String delete(Class<?> perimCl, JsonNode srzdONode) throws Exception{
		Object deserObjt = Tools.deserializeObject(srzdONode.toString());
		AbDAO d = DAOHundler.getDAOHandler(connection, perimCl);
		d.delete(perimCl.cast(deserObjt));
		String result = Tools.serializeObject(null, perimCl, "");
		return result;
	}

	// this function will handle the update request. 
//	private String update(Class<?> perimCl,JsonNode srzdONode) throws Exception {
//
//
//		System.out.println(" deserialize start ");
//		Object deserializedObject = Tools.deserializeObject(srzdONode.toString());
//		System.out.println(" deserialize fin ");
//		System.out.println(perimCl.toString());
//		AbDAO d = DAOHandler.getDAOHandler(connection, perimCl);
//		System.out.println("Step10 start");
//		d.update(perimCl.cast(deserializedObject));
//		String result = Tools.serializeObject(null, perimCl, "");
//		System.out.println(result);
//		return result;
//	}


	// this function will handle the select request. 
	private String select(Class<?> perimCl, JsonNode srzdONode) throws Exception {
		
		System.out.println(perimCl.toString());
		System.out.println("1");
		ObjectMapper mapper = new ObjectMapper();
		Object deserializedObject = Tools.deserializeObject(srzdONode.toString());
		System.out.println(deserializedObject);
		String result = "";		
		String getStringJson = srzdONode.get(JSONExample.INFO.baseExample()).textValue();
		List<String> values = null;
		System.out.println(getStringJson);
		if(getStringJson != null && getStringJson.trim().length() > 0) {
			values = mapper.readValue(getStringJson, mapper.getTypeFactory().constructCollectionType(List.class, String.class));
		}
		AbDAO d = DAOHundler.getDAOHandler(connection, perimCl);
		//result = Tools.serializeObject(d.find(values), perimCl, "");
		result = Tools.serializeObject(d.findAll(), perimCl, "");
		return result;		
	}





}
