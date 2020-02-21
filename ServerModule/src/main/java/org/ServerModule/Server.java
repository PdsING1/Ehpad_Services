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

public class Server
{



	boolean isRunning = true;
	static final int port = 9999;
	static ServerSocket server ;
	Socket socket ;




	//private static ArrayList<ThreadConnection> clients;
	//private static ExecutorService poolThread = Executors.newFixedThreadPool(4);


	public Server()
	{
		try {
			server = new ServerSocket (port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void open() 
	{

		final String url="jdbc:mysql://localhost:3306/ehpadservices?serverTimezone=UTC";
		final String userName="root";
		final String pwd = "";

		DataSource.startConnectionPool();


		Thread t = new Thread(new Runnable(){
			public void run(){
				while(isRunning == true){
					try {

					socket = server.accept();


						Connection con = DataSource.getConnection(url, userName, pwd);
						Thread th = new Thread (new ThreadConnection(socket, con));
						th.start();
						
						
                         

					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				try {
					socket.close();
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
					server = null;
				}
			}
		});


		t.start();


	}

}
