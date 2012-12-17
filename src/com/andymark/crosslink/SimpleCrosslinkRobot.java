package com.andymark.crosslink;

import java.net.Inet4Address;

import com.andymark.crosslink.Inputs.AnalogInput;
import com.andymark.crosslink.Packets.Canipede;

public class SimpleCrosslinkRobot {

  
	protected Toucan 	toucan; 	
	private AnalogInput battery;
	
	
	public SimpleCrosslinkRobot(Inet4Address ip){
		
		toucan = new Toucan(ip);  			
		battery = new AnalogInput(toucan, 8);
	
	}
		
	
	//public State State (){
	//
	//}
	
	public void ChangeIPAdress(Inet4Address ip){
		toucan.ChangeIPAddress(ip);
	}
		
	public boolean ReceivingPackets(){
		
		return toucan.ReceivingPackets();
	}
	
	public double GetBatteryVoltage(){		
        return battery.BatteryVoltage();
    }
	
	//private void periodic(){
	//
	//}

	public void teleop(){		
		toucan.enableCanipede();
	}
	
	public void disabled(){
		toucan.disableCanipede();
	}
	
	
	
	
	
	
	
	//=================================================
	// Java Unique Methods
	//=================================================
	
	public Canipede GetCanipede(){		
		//This need to be here. If a user is not using a Canipede, 
		//this wont be called and rcm packets wont be sent.
		//	EnableTask.GetCanipede has a flag that is set by this
		return toucan.GetCanipede();
	}
		
}
