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


		public  String getSocket(String serializer) {
			try {

				
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
