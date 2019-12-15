package org.ClientModule;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class SocketConnection {
	
	private static ClientSocket sclient;

	
	public static void callSocket() throws UnsupportedEncodingException, IOException
	{
		sclient = new ClientSocket();
		
		
		sclient.beginSocket();
	

	}

	
	public static ClientSocket returnClientSocket() {
		/*if(sclient == null) {
			callSocket();
		}*/
		return sclient;
	}

}
