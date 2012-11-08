package com.andymark.crosslink;

import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;





public class ToucanController {
	
	private EnableTask enableTask;
	private UDPReceiver receiver;
	private static InetAddress broadcastIP;
	
	
	public ToucanController() throws SocketException, UnknownHostException {
		broadcastIP = Inet4Address.getByName("10.10.0.121");
		
		receiver = new UDPReceiver(1218);
		ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
		threadPool.execute(receiver);
		
		enableTask = new EnableTask(broadcastIP, new DatagramSocket());
		enableTask.setEnableState(EnableState.DISABLED);
		threadPool.scheduleWithFixedDelay(enableTask, 0, 20, TimeUnit.MILLISECONDS);		
	}
	

	public boolean isReceiving(){	
		return receiver.isReceiving();
	}
	
	public byte getGpioDDR(){		
		return receiver.getGpioDDR();		 
	}
	
	public byte getGpioOut(){		
		return receiver.getGpioOut();		 
	}
	
	public byte getGpioIn(){		
		return receiver.getGpioIn();		 
	}
	
	public byte getGpioPUE(){		
		return receiver.getGpioPUE();		 
	}	
	
	public int getQuad(int channel){
		
		return receiver.getQuad(channel);
	}
	
	public int getVelocity(int channel){
		
		return receiver.getVelocity(channel);
	}	
	
	public short GetAnalogRaw(int channel){
		
		return receiver.getAnalogVoltageRaw(channel);			
	}
	
		
	public double getBattery(){
					
		return receiver.getBatteryVoltage();
	}
	
	
	public void setRelay(int relay_num, byte dir){
		
		enableTask.setRelayState(relay_num, dir);	
	}
	
	public void setSolinoid(int channel, boolean value){
		
		enableTask.setSolinoidState((channel), value);
	}
	
	public void setPWM(int channel, short value){		
		
		enableTask.setPWM(channel, value);
	}
	
	public void enableToucan (){
		
		enableTask.setEnableState(EnableState.TELEOP);		
	}
		
	public void disableToucan(){
		enableTask.setEnableState(EnableState.DISABLED);
	}	

}
