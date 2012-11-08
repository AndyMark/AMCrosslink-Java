package com.andymark.crosslink;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class UDPSender {
	
	//private static 	DatagramSocket 	socket;
	private static 	DatagramPacket 	packet;// = new DatagramPacket();
	private static	ByteBuffer		buffer;
	
	public UDPSender(){		
		byte[] duh = new byte[1];
		duh[0] = (byte) 0;
		
		packet = new DatagramPacket(duh, 1);		
	}
	
	public static void SendMessage(Message message, InetAddress broadcast, DatagramSocket socket) throws IOException {
		//socket = new DatagramSocket();
		//final InetAddress broadcast = Inet4Address.getByName("10.10.0.121"); //IP of the device to send to
		buffer = message.getMessage();
		//packet = new DatagramPacket(buffer.array(), buffer.capacity(), broadcast,  1217);
		
		
		/**/
		packet.setData(buffer.array());
		packet.setLength(buffer.capacity());
		
		packet.setAddress(broadcast);
		packet.setPort(1217);
		/**/
		
		socket.send(packet);
		
	}
}