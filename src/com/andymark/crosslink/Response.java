package com.andymark.crosslink;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Response {
	
	private InetAddress address;
	private ByteBuffer buffer = ByteBuffer.allocateDirect(90);
	private boolean isreceiving = false;
	private static StatusPacket stsPacket;
	
	
	
	public Response(/*DatagramPacket packet*/) {
		/*buffer = ByteBuffer.allocate(packet.getLength());
		buffer.put(packet.getData(), 0, packet.getLength());
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		address = packet.getAddress();	
		isreceiving = true;
		*/
	}

	public void updatePacket(DatagramPacket packet){	
		
		//buffer = ByteBuffer.allocateDirect(packet.getLength());
		buffer.clear();
		buffer.put(packet.getData(), 0, packet.getLength());
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		address = packet.getAddress();	
		isreceiving = true;
		stsPacket = StatusPacket.ParseFromBuffer(buffer);			
		
	}
	
	
	public InetAddress getAddress() {
		return address;
	}
	
	public boolean isReceiving(){
		return isreceiving;
	}

	public byte  getGpioDDR(){
		return stsPacket.getGpioDDR();
	}
	
	public byte getGpioOut(){
		return stsPacket.getGpioOut();
	}
	
	public byte getGpioIn(){
		return stsPacket.getGpioIn();
	}
	
	public byte getGpioPUE(){
		return stsPacket.getGpioPUE();
	}
	
	
	
	public int getQuad(int channel){
		
		return stsPacket.getQuad(channel);
	}
	
	public int getVelocity(int channel){
		
		return stsPacket.getVelocity(channel);
	}
	
	public short getAnalogs(int channel){
		
		return stsPacket.getAnalogInputRaw(channel - 1);
	}
	 	
	public StatusPacket getStatus(){
		StatusPacket packet = StatusPacket.ParseFromBuffer(buffer);		
		return packet;
	}
	
	
	public double getBatteryVoltage(){
		return   getStatus().getAnalogInputRaw(7) * 0.02745703125;
	}
}
