package org.ClientModule;

public class BackEndDelete {

	String location;
	String SensorName;
	String SensorType; 
	String State;


	public BackEndDelete (String location, String SensorName, String SensorType, String State)
	{
		this.location = location;
		this.SensorName = SensorName;
		this.SensorType = SensorType;
		this.State = State;


	}

	public void start (){

		//		SerializationDriver ser = new SerializationDriver();
		//
		//		System.out.println("start du back");
		//		Sensor sensor = new Sensor(location, SensorName, SensorType,State);
		//		ClientSocket client = new ClientSocket();
		//		try {
		//			System.out.println("ser");
		//			ser.serializer(sensor);
		//
		//		} catch (JsonProcessingException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		client.getSocket(sensor);
		//		System.out.println("appeler a socket");





	} 




}


