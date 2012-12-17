package com.andymark.crosslink.Outputs;

import com.andymark.crosslink.Packets.Canipede;


public class Solenoid {
	
	private Canipede canipede;
	private int channel;
	
	public Solenoid(Canipede canipede, int channel){
		
		this.canipede = canipede;
        this.channel = channel;	        
	}
	
	public void State(boolean value){		
		canipede.SetSolenoidValue(channel, value);	
	}
	
	public int GetChannel(){
		return channel;		
	}
}
