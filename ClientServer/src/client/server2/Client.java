package client.server2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	
	public Client() throws Exception{
		Socket socket=new Socket("192.168.43.143", 2020);
		System.out.println("Successful connection to the server");
		
		
		//i/o streams
		BufferedReader in_socket=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		Scanner keyboard=new Scanner(System.in);
		
		String message;
		
		String user_number;
		
		while((in_socket.readLine()).startsWith("Guess")) {
			System.out.println("Server says \"Guess a number\"");
			user_number=keyboard.nextLine();
			out_socket.println(user_number);
		}
		System.out.println("you got it!");
/*		message=in_socket.readLine();
		
		System.out.println("Client says"+ message);
		System.out.println("Say something to the server: ");
		message=keyboard.nextLine();
		out_socket.println(message);*/
		
		
		
		
		
		socket.close();
		System.out.println("Socket closed");
		
	}
	public static void main(String[] args) {
		
		
		try {
			new Client();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
