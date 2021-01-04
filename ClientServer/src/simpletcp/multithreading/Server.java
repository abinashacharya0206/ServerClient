package simpletcp.multithreading;

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
		

		//infinite loop for new connections
		while(true) {
			Socket socket=server_socket.accept();
			ServerMultithread server_thread=new ServerMultithread(socket);
			Thread thread=new Thread(server_thread);
			thread.start();
		}
		
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
