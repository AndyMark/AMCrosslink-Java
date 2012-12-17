package com.andymark.crosslink;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.andymark.crosslink.Packets.Canipede;
import com.andymark.crosslink.Packets.EnablePacket;
import com.andymark.crosslink.Packets.JaguarPacket;

public class EnableTask implements Runnable {

	private EnablePacket packet = new EnablePacket();
	private JaguarPacket jag = new JaguarPacket();
	private Canipede rcm = new Canipede();
	
	private static UDPSender sender = new UDPSender();
	private static InetAddress broadcast;
	private static DatagramSocket socket;
	
	
	private static boolean JaguarExist = false;
	private static boolean CanipedeExist = false;	
	private static boolean[] Flags = new boolean[2];
	
	private static int 		totalTX = 0;
	
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
		CanipedeExist = true;
		return rcm;		
	}
	
	public JaguarPacket GetJaguar(){
		JaguarExist = true;
		return jag;
	}
	
	public boolean[] getFlags(){
		
		Flags[0] = JaguarExist;
		Flags[1] = CanipedeExist;
		return Flags;
	}
	
	public int PacketsSent(){
		return totalTX;		
	}
	
	@Override
	public void run() {
		try {			
			sender.SendMessage(packet, broadcast, socket);
			totalTX++;
			
			if (JaguarExist){
				sender.SendMessage(jag, broadcast, socket);
				totalTX++;
			}
			
			if (CanipedeExist){
				sender.SendMessage(rcm, broadcast, socket);
				totalTX++;
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
