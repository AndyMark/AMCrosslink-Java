package com.andymark.crosslink.Outputs;

import com.andymark.crosslink.Canipede;


public class Victor implements SpeedController{

	
	Canipede canipede;
	int pwmChannel;
	
    public Victor(Canipede canipede, int pwmChannel){
    	
        this.canipede = canipede;
        this.pwmChannel = pwmChannel;
    
    }
	
    
    @Override
	public void Throttle(double value) {
    	
        double forward = 2.1;
        double center = 1.50;
        double reverse = 1.00;
        double ms;

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

}
