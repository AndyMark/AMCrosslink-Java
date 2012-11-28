package com.andymark.crosslink.Inputs;

import com.andymark.crosslink.Toucan;

public class GPIO {
   
	private Toucan toucan;
	private int channel;
	
	
	public GPIO(Toucan toucan, int channel){
	    this.toucan = toucan;
	    this.channel = channel;
	}

	public boolean Value(){
		return toucan.GetGPIO(channel);
	}
}