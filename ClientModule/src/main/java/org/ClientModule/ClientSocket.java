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
	private  PrintWriter writeToServer ;
	Socket socket;

	public ClientSocket()
	{

	}


	public void beginSocket() throws UnsupportedEncodingException, IOException
	{
		try {
			socket = new Socket(serverName, serverPort);
			socket.setSoTimeout(5000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		writeToServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);	
		readFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

	}


	public  String getSocket(String serializer) throws IOException {



		// Send the request to the server
		System.out.println("WriteToServer will be executed");
		System.out.println(serializer);

		writeToServer.println(serializer);
		System.out.println("WriteToServer have been executed");

		
		String answerServerClient = "";


			answerServerClient = (String) readFromServer.readLine();
			System.out.println(answerServerClient);
			
			

			return answerServerClient;
			
		
			
		// readFromServer.close();

		//writeToServer.close();
		//		socket.close();









	}

}
