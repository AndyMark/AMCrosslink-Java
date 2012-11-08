package com.andymark.crosslink;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;



//For Desktop Applications
//===================================================
//
//+ Tested on Windows 7 64bit (11-8-2012)
//
//

public class SimpleCrosslinkRobot {

  
	protected ToucanController 	toucan; 
	
	public SimpleCrosslinkRobot(){
		try{
			//SetUp Toucan Controller
			toucan = new ToucanController(/*ip*/);
			
		}catch (SocketException e){
		
		} catch (UnknownHostException e) {
		
			e.printStackTrace();
		}		
	}
	
	public boolean isReceiving(){
		
		return toucan.isReceiving();
	}
	
	public void ChangeIPAdress(InetAddress addr){
		
		// toucan.ChangeIPAddress(addr); // - not imoplemented yet				
	}
	
	public void setPWM (int channel, short value){		
		//send 0 - 100. 0 = full reverse, 100 = full forward, 48-52 = neutral
		toucan.setPWM(channel, value);
	}
	
	public int getQuad(int channel){		
		return toucan.getQuad(channel);
	}
	
	public int getVelocity(int channel){		
		return toucan.getVelocity(channel);
	}	
		
	
	public double GetBatteryVoltage(){
		AnalogInput analog = new AnalogInput(toucan, 8);	
        return analog.BatteryVoltage();//battery.BatteryVoltage;
    }
	
	public double GetVoltage(int channel){
		AnalogInput analog = new AnalogInput(toucan, channel);		
		return analog.Voltage();
	}	
	
	public byte getGpioDDR(){		
		return toucan.getGpioDDR();		 
	}
	
	public byte getGpioOut(){		
		return toucan.getGpioOut();		 
	}
	
	public byte getGpioIn(){		
		return toucan.getGpioIn();		 
	}
	
	public byte getGpioPUE(){		
		return toucan.getGpioPUE();		 
	}	

	public void setRelay(int channel, byte dir){		
		toucan.setRelay(channel, dir);			
	}
	public void setSolinoid (int channel, boolean value){		
		toucan.setSolinoid( channel, value);		
	}
	
	public /*virtual*/ void teleop(){		
		toucan.enableToucan();
	}
	
	public /*virtual*/ void disabled(){
		toucan.disableToucan();
	}
	
}
