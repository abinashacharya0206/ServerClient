package client.server2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public Server() throws IOException {
		ServerSocket server_socket=new ServerSocket(2020);//opening a new port
		System.out.println("port 2020 is now open");
		
		Socket socket=server_socket.accept();//accepting connections
		System.out.println("Client"+socket.getInetAddress()+"has connected");
		
		//i/o buffer-data coming to the socket
		BufferedReader in_socket=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//out going data
		PrintWriter out_socket=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		String message;
		int secret_number=(int)(Math.random()*10+1);
		
		do {
			out_socket.println("Guess a number");
			message=in_socket.readLine();
		}
		while(!(Integer.parseInt(message)==secret_number));
		
		out_socket.println("You got it!");
		System.out.println("You have guessed it");
		
/*		out_socket.println("Welcome");
		
		//reading from input socket
		String message=in_socket.readLine();
		System.out.println("Client says"+ message);
		*/
		socket.close();
		System.out.println("Socket is closed");
		
	}

	
	public static void main(String[] args) {
		try {
			new Server();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
