package com.andymark.crosslink;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver implements Runnable {

	private DatagramSocket socket;
	private Response response = new Response();
	private boolean isreceiving = false;
	private static byte[] buffer = new byte[256];
	private static DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
	
	private int lastTS = 0;
	private int thisTS = 0;
	private int totalRX = 0;
	
	public UDPReceiver(int port) throws SocketException {
		
		socket = new DatagramSocket(port);
	}
	
	@Override
	public void run() {
		try {
			processPackets();
		} catch (IOException e) {
			isreceiving = false;
			e.printStackTrace();
		} finally {
			isreceiving = false;
			socket.close();
		}
	}

	private void processPackets() throws IOException {
		while (true) {
			
			lastTS = thisTS;
		
			socket.receive(packet);
				
			thisTS = (int) System.currentTimeMillis();
			totalRX++;
			
			response.updatePacket(packet);
			
			
			isreceiving = response.isReceiving();			 	
		}
	}

	public boolean isReceiving(){
		return isreceiving;
	}
	public double getBatteryVoltage(){		
		
		return response.getBatteryVoltage();
		
	}
	
	public byte getGpioDDR(){		
		return response.getGpioDDR();		 
	}
	
	public byte getGpioOut(){		
		return response.getGpioOut();		 
	}
	
	public byte getGpioIn(){		
		return response.getGpioIn();		 
	}
	
	public byte getGpioPUE(){		
		return response.getGpioPUE();		 
	}	
	
	public int getQuad(int channel){
		
		return response.getQuad(channel);
	}
	
	public int getVelocity(int channel){
		
		return response.getVelocity(channel);
	}
		
	public short getAnalogVoltageRaw(int channel){	
		
		return response.getStatus().getAnalogInputRaw(channel);
		
	}

	public DatagramPacket getResponse() {
		while (true) {

		}
	}

	public int TimeFromLastRx(){
		return thisTS - (int) System.currentTimeMillis();
	}
	
	public int TimeBetweenRx(){		
		return thisTS - lastTS;
	}
	
	public int PacketsReceived(){
		return totalRX;
	}
}
