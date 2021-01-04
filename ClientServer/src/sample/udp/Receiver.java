package sample.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Receiver {
	
	public Receiver() throws Exception{
		
		//Receiving 
		//define port no
		DatagramSocket socket=new DatagramSocket(2020);
		System.out.println("Receiver is running");
		Scanner keyboard=new Scanner(System.in);
		
		//array of bytes for buffer(this is maximum transferable data size called mtu
		byte[] buffer=new byte[1500];
		//packet definition same as a frame where the detail of the data will be transfered
		DatagramPacket packet=new DatagramPacket(buffer, buffer.length);
		//receiving packet from the sender, putting the message into our newly created packet
		socket.receive(packet);
		//if the received data is shorter we need to trim it
		String message=new String(buffer).trim();
		System.out.println("Received: "+ message);
		
		//sending
		
		InetAddress sender_address=packet.getAddress();
		int sender_port=packet.getPort();
		
		System.out.println("Enter your message: ");
		message=keyboard.nextLine();
		buffer=message.getBytes();
		packet=new DatagramPacket(buffer, buffer.length, sender_address, sender_port);
		socket.send(packet);
		System.out.println("Sent: "+ message);
		
	}
	
	public static void main(String[] args) {
		try {
			new Receiver();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
