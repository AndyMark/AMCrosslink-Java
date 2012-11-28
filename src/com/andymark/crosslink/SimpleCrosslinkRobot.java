package com.andymark.crosslink;

import java.net.Inet4Address;

import com.andymark.crosslink.Inputs.AnalogInput;

public class SimpleCrosslinkRobot {

  
	protected Toucan 	toucan; 
	
	private AnalogInput battery;
	private Canipede Canipede;
	//private Solenoid light_bar;
	
	public SimpleCrosslinkRobot(Inet4Address ip){
		
		try{
			
			toucan = new Toucan(ip);           
			battery = new AnalogInput(toucan, 8);
			Canipede = toucan.GetCanipede();
			
			//light_bar = new Solenoid(Canipede, 1);
			
			
			
		}catch (Exception e) {		
			e.printStackTrace();
		}		
	}
		
	public boolean ReceivingPackets(){
		
		return toucan.ReceivingPackets();
	}
	
	public void ChangeIPAdress(Inet4Address ip){
		toucan.ChangeIPAddress(ip);
	}
		
	//===============================================================
	//	CANDIPEDE RELATED CODE
	//===============================================================	
	public Canipede GetCanipede(){		
		return Canipede;
	}
		
	/*
	public void setSolenoid(int channel, boolean value){		
		Canipede.SetSolenoidValue(channel, value);
	}		

	
	public void setRelay(int channel, byte dir){		
		Canipede.SetRelayValue(channel, dir);			
	}
	
	public int GetEncoderPosition(int channel){		
		return toucan.GetEncoderPosition(channel);
	}
	
	public int GetEncoderRate(int channel){		
		return toucan.GetEncoderRate(channel);
	}	
	*/	
	
	public double GetBatteryVoltage(){		
        return battery.BatteryVoltage();
    }
    
	public double GetVoltage(int channel){
		AnalogInput analog = new AnalogInput(toucan, channel);		
		return analog.Voltage();
	}		
	
	//===============================================================
	//	ROBOT CODE
	//===============================================================
	public void teleop(){		
		toucan.enableCanipede();
	}
	
	public void disabled(){
		toucan.disableCanipede();
	}
	
}
