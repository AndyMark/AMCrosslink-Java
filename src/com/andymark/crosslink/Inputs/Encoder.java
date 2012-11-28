package com.andymark.crosslink.Inputs;

import com.andymark.crosslink.Toucan;

public class Encoder{	
	
	private Toucan toucan;
    private int channel;
    
	public Encoder(Toucan toucan, int channel){
	    this.toucan = toucan;
	    this.channel = channel;
	}
	

	public int Position(){	        
		return toucan.GetEncoderPosition(channel);	
	}
	
	public int Rate(){
		return toucan.GetEncoderRate(channel);
	}

}
