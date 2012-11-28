package com.andymark.crosslink;

import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;





public class Toucan {
	
	private EnableTask enableTask;
	private UDPReceiver receiver;
	private static Inet4Address broadcastIP;
	private ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
	
	public Toucan(Inet4Address ip) throws SocketException, UnknownHostException {
		broadcastIP = ip; //Inet4Address.getByName("10.10.0.121");
		
		receiver = new UDPReceiver(1218);		
		threadPool.execute(receiver);
		
		
		enableTask = new EnableTask(broadcastIP, new DatagramSocket());
		enableTask.setEnableState(EnableState.DISABLED);
		threadPool.scheduleWithFixedDelay(enableTask, 0, 20, TimeUnit.MILLISECONDS);		
	}
	
	public void ChangeIPAddress(Inet4Address ip) {
		
		broadcastIP = ip;		
		enableTask.ChangeIPAddress(broadcastIP);	
		
	}	
	
	public void enableCanipede (){		
		enableTask.setEnableState(EnableState.TELEOP);		
	}
		
	public void disableCanipede(){
		enableTask.setEnableState(EnableState.DISABLED);
	}	
	
	public boolean ReceivingPackets(){	
		return receiver.isReceiving();
	}
	
	public short GetAnalogRaw(int channel){
		
		return receiver.getAnalogVoltageRaw(channel);			
	}
	
	public int GetEncoderPosition(int channel){
		
		return receiver.getQuad(channel);
	}
	
	public int GetEncoderRate(int channel){
		
		return receiver.getVelocity(channel);
	}	

	public Canipede GetCanipede(){
		
		return enableTask.GetCanipede();
	}

	public boolean GetGPIO(int channel) {
		System.out.println("GPIO Not Created yet...");
		return false;
	}
	

	

	
	

}
