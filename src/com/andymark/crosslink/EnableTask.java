package com.andymark.crosslink;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EnableTask implements Runnable {

	private EnablePacket packet = new EnablePacket();
	private UpdateJaguarPacket jag = new UpdateJaguarPacket();
	private Canipede rcm = new Canipede();
	
	private static UDPSender sender = new UDPSender();
	private static InetAddress broadcast;
	private static DatagramSocket socket;
	
	public EnableTask(InetAddress destinationIP, DatagramSocket sock){
		broadcast = destinationIP;
		socket = sock;
	}	
	
	public void ChangeIPAddress(InetAddress ip){		
		broadcast = ip;				
	}	
	
	public void setEnableState(EnableState state) {
		packet.setEnableState(state);
	}
	
	public EnableState getEnableState() {
		return packet.getEnableState();
	}

	
	public Canipede GetCanipede(){			
		return rcm;		
	}
	
	
	//===============================================================
	//	
	//===============================================================
	
	@Override
	public void run() {
		try {			
			sender.SendMessage(packet, broadcast, socket);
			//UDPSender.SendMessage(jag);
			sender.SendMessage(rcm, broadcast, socket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
