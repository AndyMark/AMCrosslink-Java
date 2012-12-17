package com.andymark.crosslink.Tests;

import java.net.Inet4Address;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.andymark.crosslink.SimpleCrosslinkRobot;
import com.andymark.crosslink.Inputs.AnalogInput;
import com.andymark.crosslink.Inputs.Encoder;
import com.andymark.crosslink.Inputs.GPIO;
import com.andymark.crosslink.Outputs.Jaguar;
import com.andymark.crosslink.Outputs.Relay;
import com.andymark.crosslink.Outputs.Servo;
import com.andymark.crosslink.Outputs.Solenoid;
import com.andymark.crosslink.Outputs.Victor;
import com.andymark.crosslink.Packets.Canipede;

public class Bench extends SimpleCrosslinkRobot{

	private Canipede canipede;
	
	protected Solenoid light_1;
	protected Solenoid light_2;
	protected Solenoid light_3;
	protected Solenoid light_4;
	protected Solenoid light_5;
	protected Solenoid light_6;
	protected Solenoid light_7;
	protected Solenoid light_8;
	
	protected Relay relay_1;		
	protected Relay relay_2;		
	protected Relay relay_3;		
	protected Relay relay_4;		
		
	protected AnalogInput A1;
	protected AnalogInput A2;
	protected AnalogInput A3;
	protected AnalogInput A4;
	protected AnalogInput A5;
	protected AnalogInput A6;
	protected AnalogInput A7;
	protected AnalogInput A8;
	
	protected Encoder E1;
	protected Encoder E2;
	protected Encoder E3;
	protected Encoder E4;
	
	protected GPIO gpio;
	
	
	protected Victor testMotor;
	protected Victor otherMotor;
	protected Victor rearMotor;
	
	protected Jaguar testJag;
	
	protected Servo penFlipper;
	
	private StrafeModule strafeMod;
	
	
	public Bench(Inet4Address ip) {
		super(ip);
		
		canipede = this.GetCanipede();
		
		light_1 = new Solenoid(canipede, 1);
		light_2 = new Solenoid(canipede, 2);
		light_3 = new Solenoid(canipede, 3);
		light_4 = new Solenoid(canipede, 4);
		light_5 = new Solenoid(canipede, 5);
		light_6 = new Solenoid(canipede, 6);
		light_7 = new Solenoid(canipede, 7);
		light_8 = new Solenoid(canipede, 8);
		
		relay_1 = new Relay(canipede, 1);		
		relay_2 = new Relay(canipede, 2);		
		relay_3 = new Relay(canipede, 3);		
		relay_4 = new Relay(canipede, 4);	
		
		testMotor = new Victor(canipede, 1);
		otherMotor = new Victor(canipede, 2);
		rearMotor = new Victor(canipede, 3);
		
		testJag = new Jaguar(toucan,1);
		
		penFlipper = new Servo(canipede, 4);
		
		A1 = new AnalogInput(toucan, 1);
		A2 = new AnalogInput(toucan, 2);
		A3 = new AnalogInput(toucan, 3);
		A4 = new AnalogInput(toucan, 4);
		A5 = new AnalogInput(toucan, 5);
		A6 = new AnalogInput(toucan, 6);
		A7 = new AnalogInput(toucan, 7);
		A8 = new AnalogInput(toucan, 8);		
		
		E1 = new Encoder(toucan, 1);
		E2 = new Encoder(toucan, 2);
		E3 = new Encoder(toucan, 3);
		E4 = new Encoder(toucan, 4);
		
		//strafeMod = new StrafeModule(testMotor, otherMotor, rearMotor, E1);		
	}
	
	
	
	public void TurnOnLights(){
		
		light_1.State(true);
		light_2.State(true);
		light_3.State(true);
		light_4.State(true);
		light_5.State(true);
		light_6.State(true);
		light_7.State(true);
		light_8.State(true);	
		
		
	}
	
	
	public void TurnOffLights(){
		
		light_1.State(false);
		light_2.State(false);
		light_3.State(false);
		light_4.State(false);
		light_5.State(false);
		light_6.State(false);
		light_7.State(false);
		light_8.State(false);			
		
	}
	
	
	
	public void Strafe(double value){
		
		strafeMod.Strafe(value);
		
	}
	

	
	
}
