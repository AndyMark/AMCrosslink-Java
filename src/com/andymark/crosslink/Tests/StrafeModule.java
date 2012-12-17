package com.andymark.crosslink.Tests;

import com.andymark.crosslink.Inputs.Encoder;
import com.andymark.crosslink.Outputs.Victor;

public class StrafeModule implements Runnable{
	
	private boolean strafing = false;
	private boolean forward = false;
	
	private double speed = 0;
	private double adj = 0.0;
	
	protected Victor FL;
	protected Victor FR;
	protected Victor RC;
	
	protected Encoder RC_E;
	private float start_pos = 0;
	
	float gyro[] = new float[3];
	
	public StrafeModule (Victor fl, Victor fr, Victor rc){
				
		FL = fl;
		FR = fr;
		RC = rc;
	}
	
	public void Strafe(double value){
		if (!strafing){
			start_pos = gyro[0];
		}
		strafing = true;
		
		speed = (value > 0)?0.3:-0.3;//*value;
	}
	
	public void Stop(){
		strafing = false;
		forward = false;
		
		speed = 0;
	}
	
	public void UpdateGyro(float[] gyro){		
		this.gyro = gyro;
	}
	
	public void Forward(double value){		
		if (!forward){
			start_pos = gyro[0];
		}
		forward = true;
		speed = 1.2*value;
		
	}
	
	@Override
	public void run() {	
		System.out.print(".");
		if (strafing){			
			float yaw = (float) ((gyro[0]-start_pos)/20.0);
			
	        double rearValue = speed + -yaw;
	        double rightValue = (-speed / 2.0) + -yaw;
	        double leftValue = (-speed / 2.0) +  -yaw;
	        
			//Update Motor Values	
			FL.Throttle(leftValue);
			FR.Throttle(rightValue);
			RC.Throttle(rearValue);			
		}
		
		if(forward){
			float yaw = (float) ((gyro[0]-start_pos)/20.0);
			
	        double rearValue = 0 /*speed*/ + -yaw;
	        double rightValue = (-speed) + -yaw;
	        double leftValue = (speed) +  -yaw;
	        
			//Update Motor Values	
			FL.Throttle(leftValue);
			FR.Throttle(rightValue);
			RC.Throttle(rearValue);					
		}
		
		
	}
	
	
	
	
	

}
