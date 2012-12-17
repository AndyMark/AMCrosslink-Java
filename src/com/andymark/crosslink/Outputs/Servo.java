package com.andymark.crosslink.Outputs;

import com.andymark.crosslink.Packets.Canipede;


public class Servo {
	
	
	private Canipede canipede;
    private int pwmChannel;

    private double lastPosition = 0;
    
    public Servo(Canipede canipede, int pwmChannel){
        this.canipede = canipede;
        this.pwmChannel = pwmChannel;
    }

    public void Position (double value){
    	
            double forward = 2.1;
            double center = 1.50;
            double reverse = 1.00;
            double ms;
            
            lastPosition = value;
            
            value = (value > 1) ? 1 : value;
            value = (value < -1) ? -1 : value;

            if (value > 0)
            {
                ms = center + value * (forward - center);
            }
            else
            {
                ms = center + value * (center - reverse);
            }

            canipede.SetPWMValue(pwmChannel, (short)(ms * 1e6 / 200));
   }
    
   public void DeltaPosition(double value){
	   
	   lastPosition += value;	   
	   lastPosition = (lastPosition > 1.0)?1.0:lastPosition;
	   lastPosition = (lastPosition < -1.0)?-1.0:lastPosition;	   
	   Position(lastPosition);  
	   
   }
}

