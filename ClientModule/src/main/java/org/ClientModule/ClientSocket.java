package org.ClientModule;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.ServerModule.Sensor;

public class ClientSocket 
{

	static final String serverName = "localhost";
	static final int serverPort = 9999;
	private  BufferedReader readFromServer;
	private  PrintWriter writeToServer;
	 Socket socket;

	public  String getSocket(String serializer) {
		try {

			socket = new Socket(serverName, serverPort);
			System.out.println("Socket client: " + socket);
			// Send a request to connect to the server is listening
			// on machine 'localhost' port 7777.            


			// Create output stream at the client (to send data to the server)
			//			ObjectOutputStream out =  new ObjectOutputStream(socket.getOutputStream());
			//			
			//
			//			// Input stream at Client (Receive data from the server).
			//			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			//
			//
			//			System.out.println(serializer);
			//
			//			// Write data to the output stream of the Client Socket.
			//			out.writeObject(serializer);
			//			System.out.println("serializer2");
			//			
			//			
			//			out.close();
			//			in.close();
			//
			//			socket.close();



			//

			writeToServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);	
			readFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			String answerServerClient = "";


			// Send the request to the server
			System.out.println("WriteToServer will be executed");
			System.out.println(serializer);
			writeToServer.println(serializer);
			System.out.println("WriteToServer have been executed");


			// Receive an answer from the the server
			answerServerClient = readFromServer.readLine();
			System.out.println("toto6");

			return answerServerClient;


			//return socket;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return null;
		}

		try {
			readFromServer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		writeToServer.close();
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}
}
