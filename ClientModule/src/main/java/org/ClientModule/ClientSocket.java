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

	

	public void getSocket(Object serializer) {
		try {

			Socket socket = new Socket(serverName, serverPort);
			System.out.println("Socket client: " + socket);
			// Send a request to connect to the server is listening
			// on machine 'localhost' port 7777.            


			// Create output stream at the client (to send data to the server)
			ObjectOutputStream out =  new ObjectOutputStream(socket.getOutputStream());
			

			// Input stream at Client (Receive data from the server).
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());


         

			// Write data to the output stream of the Client Socket.
			out.writeObject(serializer);

			out.close();
			in.close();

			socket.close();



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
