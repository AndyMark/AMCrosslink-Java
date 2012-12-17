package com.andymark.crosslink;

import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.andymark.crosslink.Packets.Canipede;


public class Toucan {
	
	private EnableTask enableTask;
	private UDPReceiver receiver;
	private static Inet4Address broadcastIP;
	private ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
	
	public Toucan(Inet4Address ip) {
		//EnableTask handles sending the JaguarPacket, EnablePacket out on time
		//UDPReceiver handles receiving StatusPacket
		
		try{			
		
			broadcastIP = ip; //Inet4Address.getByName("10.10.0.121");
			
			receiver = new UDPReceiver(1218);		
			threadPool.execute(receiver);
			
			
			enableTask = new EnableTask(broadcastIP, new DatagramSocket());
			enableTask.setEnableState(EnableState.DISABLED);
			threadPool.scheduleWithFixedDelay(enableTask, 0, 20, TimeUnit.MILLISECONDS);		
		
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	}
	
	public void ChangeIPAddress(Inet4Address ip) {
		
		broadcastIP = ip;		
		enableTask.ChangeIPAddress(broadcastIP);	
		
	}	
	
	//private void SendPackets(Object state){
	//	EnableTask.java Handles sending packets	
	//}
	
	//private void ReceivePacket(IAsyncResult ar){
	//	UDPReceiver.java handles receiving packets
	//}

	public int TimeSinceLastRx (){
		return receiver.TimeFromLastRx();
	}
	
	public int PacketsSent (){
		return enableTask.PacketsSent();
	}
	
    public int PacketsReceived(){
    	return receiver.PacketsReceived();
    }
	
	//public State State() {
	//  Not Used
	//}
	
	public Canipede GetCanipede(){
		
		return enableTask.GetCanipede();
	}
	
	public void SetJaguar(int jaguar, short value) {
		enableTask.GetJaguar().SetJaguarVoltage(jaguar, value);
	}
		
	public short GetAnalogRaw(int channel){		
		return receiver.getAnalogVoltageRaw(channel);			
	}
	
	public boolean GetGPIO(int channel) {
		System.out.println("GPIO Not Created yet...");
		return false;
	}
	
	public int GetEncoderPosition(int channel){		
		return receiver.getQuad(channel);
	}
	
	public int GetEncoderRate(int channel){		
		return receiver.getVelocity(channel);
	}	

	//public enum State{
	// Not used yet	
	//}
	
	
	
	
	
	
	
	//=================================================
	// Java Specific Methods
	//=================================================

	public boolean ReceivingPackets(){	
		return receiver.isReceiving();
	}
	
	public boolean[] getFlags(){
		return enableTask.getFlags();
	}
	
	public void enableCanipede (){		
		enableTask.setEnableState(EnableState.TELEOP);		
	}
		
	public void disableCanipede(){
		enableTask.setEnableState(EnableState.DISABLED);
	}	
	
}
