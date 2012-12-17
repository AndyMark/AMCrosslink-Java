package com.andymark.crosslink.Outputs;

import com.andymark.crosslink.Toucan;


public class Jaguar implements SpeedController{
    
	private Toucan toucan;
    private int nodeId;
	Direction direction = Direction.None;

    
    public Jaguar(Toucan toucan, int nodeId)
    {
        this.toucan = toucan;
        this.nodeId = nodeId;
    }

    public void Throttle (double value){
	    value = (value > 1) ? 1 : value;
	    value = (value < -1) ? -1 : value;
	    toucan.SetJaguar(nodeId, (short) (value * 0x7FFF));
    }

	@Override
	public void DisableDirection(Direction direction) {
		this.direction = direction;
		
	}
}


