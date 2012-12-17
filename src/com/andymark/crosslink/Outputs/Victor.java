package com.andymark.crosslink.Outputs;

import com.andymark.crosslink.Packets.Canipede;


public class Victor implements SpeedController{

	
	Canipede canipede;
	int pwmChannel;
	
	Direction direction = Direction.None;
	Direction current 	= Direction.None;
	
    public Victor(Canipede canipede, int pwmChannel){
    	
        this.canipede = canipede;
        this.pwmChannel = pwmChannel;
    
    }
	
    
    @Override
	public void Throttle(double value) {
    	
        double forward = 2.1;
        double center  = 1.50;
        double reverse = 1.00;
        double ms;

        value = (value > 1) ? 1 : value;
        value = (value < -1) ? -1 : value;

                        
        switch (direction){
				
		case Positive:
	        value = (value > 0.0) ? 0.0 : value;			
			break;
					
		case Negative:			
	        value = (value < 0.0) ? 0.0 : value;
			break;
		case All:
			value = 0;
			
		default:
			break;
		
		}
           
        
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

	@Override
	public void DisableDirection(Direction direction) {
		
		this.direction = direction;
		

		
		if(current != direction){
			if(current != Direction.None){
				if(direction != Direction.None){
					if(direction != Direction.All){
						this.direction = Direction.All;
					}				
				}				
			}
		}

		current = this.direction;	
	}

}


