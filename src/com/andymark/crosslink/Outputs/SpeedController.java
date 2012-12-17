package com.andymark.crosslink.Outputs;

public interface SpeedController{
		
	public void Throttle(double value);
	
	public void DisableDirection(Direction direction);		
	
	public enum Direction {
	
		None,
		Positive,
		Negative,
		All,
		
	}
}

