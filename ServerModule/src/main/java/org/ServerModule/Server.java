package org.ServerModule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.net.ServerSocket;

public class Server implements Runnable
{
	static final int port = 9999;
	static ServerSocket server = null;
	static Thread t;
	static boolean isRunning = false;

	//		Runnable runnable = new Server();
	//		Thread thread = new Thread(runnable);
	//		thread.start();

	public static void main (String[] args) {
		if (launchServer () == null)
			System.out.println("Erreur lors du lancement du serveur -- voir le lunchServer");



	}

	public static ServerSocket launchServer () {
		if (server == null)
			try {
				server = new ServerSocket (port);          
				t = new Thread (new Server ());
				t.start();         
			} catch (IOException e) {
				e.printStackTrace();
			}
		return server;
	}

	public void run() {


		try {          
			System.out.println("Le Serveur est lancé ");
			isRunning = true;
			while (isRunning)   {      
				Socket socket = server.accept();
				new Thread (new ThreadConnection(socket));             
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

}
