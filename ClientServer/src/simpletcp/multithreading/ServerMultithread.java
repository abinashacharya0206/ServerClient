package simpletcp.multithreading;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerMultithread implements Runnable{
	
	private Socket socket;
	
	public ServerMultithread(Socket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader in_socket=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//out going data
			PrintWriter out_socket=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			out_socket.println("Welcome whats your name");
			
			//reading from input socket
			String message=in_socket.readLine();
			System.out.println("Client says"+ message);
			
			socket.close();
			System.out.println("Socket is closed");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
