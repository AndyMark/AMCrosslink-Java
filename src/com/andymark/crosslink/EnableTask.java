package com.andymark.crosslink;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EnableTask implements Runnable {

	private EnablePacket packet = new EnablePacket();
	private UpdateJaguarPacket jag = new UpdateJaguarPacket();
	private RCMPacket rcm = new RCMPacket();
	
	private static UDPSender sender = new UDPSender();
	private static InetAddress broadcast;
	private static DatagramSocket socket;
	
	public EnableTask(InetAddress destinationIP, DatagramSocket sock){
		
		
		broadcast = destinationIP;
		socket = sock;
	}
	
	
	
	
	
	
	public void setEnableState(EnableState state) {
		packet.setEnableState(state);
	}
	
	public EnableState getEnableState() {
		return packet.getEnableState();
	}
	
	public void setRelayState(int relay_num, byte dir){
		
		rcm.setRelayState(relay_num, dir);
		
	}
	
	public void setSolinoidState(int channel, boolean value){
		
		rcm.setSolenoidState(channel, value);
		
	}
	
	public void setPWM(int channel, short value){
		rcm.setPWM(channel, value);		
	}
	
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
