package com.andymark.crosslink.Outputs;

import com.andymark.crosslink.Packets.Canipede;


public class Relay{
	
    private Canipede canipede;
    private int channel;

    public Relay(Canipede canipede, int channel){
        this.canipede = canipede;
        this.channel = channel;
    }
  
    public void State (RelayState value){
    	canipede.SetRelayValue(channel, (byte) value.ordinal());    
    }
    
}


