package com.andymark.crosslink;

public class AnalogInput {

	private ToucanController toucan;	
	int channel; 
	
	
	public AnalogInput(ToucanController toucan, int channel){		
		this.toucan = toucan;
		this.channel = channel;		
	}
		
	public short Raw() {		
		return toucan.GetAnalogRaw(channel);		
	}
	
	
	public double Voltage(){		
		return ((int)Raw()) * 0.0048984375;
	}
	
	public double BatteryVoltage(){
            return ((int)Raw()) * 0.02745703125; // raw * 3.3/1024 * ( 70 + 5.2 + 10) /  (10)
        }
    }