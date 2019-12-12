package org.ServerModule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.concurrent.ExecutorService;

import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class Server implements Runnable
{




	static final int port = 9999;
	static ServerSocket server = null;
	

	

	private static ArrayList<ThreadConnection> clients;
	private static ExecutorService poolThread = Executors.newFixedThreadPool(4);


public static void main (String []args )
{
	Server server= new Server();
	server.run();
}
	
	

		public void run() 
		{
		
		String url="jdbc:mysql://localhost:3306/ehpadservices?serverTimezone=UTC";
		String userName="root";
		String pwd = "";

		try {    
			
			DataSource.startConnectionPool();
			server = new ServerSocket (port);
			
			System.out.println("Le Serveur est lancé ");

			while (true)   {      

				Socket socket = server.accept();
				
			
				Connection con = DataSource.getConnection(url, userName, pwd);
				ThreadConnection clientThread = new ThreadConnection(socket, con);
				
			
				clients.add(clientThread);

				poolThread.execute(clientThread);
				

			}
			

			
		} catch (IOException e) {
			server = null;             
		} finally {
			try {
				
				server.close();
				server = null;
			} catch (IOException e) {              
				e.printStackTrace();
			}          
		}


	}

	//	public static ServerSocket launchServer () {
	//		if (server == null)
	//			try {
	//				
	//
	//				
	//				
	//				
	//				//Pool.create();
	//			   DataSource.startConnectionPool();
	//					
	//				
	//				
	//				
	//				server = new ServerSocket (port);          
	//				t = new Thread (new Server ());
	//				t.start();         
	//			} catch (IOException e) {
	//				e.printStackTrace();
	//			}
	//		return server;
	//	}
	//
	//	public void run() {
	//
	//		
	//		
	//		
	//
	//
	//			
	//
	//	}

}
