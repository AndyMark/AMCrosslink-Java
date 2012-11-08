package com.andymark.crosslink;

import java.nio.ByteBuffer;

//Construct the StatusPacket that was sent from the robot
public class StatusPacket {

	//gpio
	private byte[] gpio;					// gpio[0] = GPIO_DDR
											// gpio[1] = GPIO_OUT
	//internal Int32[] quad_in;				// gpio[2] = GPIO_IN
	private int[] quad_in;					// gpio[3] = GPIO_PUE
	
	//internal Int32[] velocity_in;
	private int[] velocity_in;
	
	//internal UInt16[] analog_in;
	private short[] analog_in;
	
	private int sig;
	
	public StatusPacket (){		
		sig = 0xaaa7;		
		gpio = new byte[4];
		quad_in = new int[4];
		velocity_in = new int[4];
		analog_in = new short[8];		
	}

	public static StatusPacket ParseFromBuffer(ByteBuffer buffer)
	{
	    StatusPacket packet = new StatusPacket();
	    //buffer[1-3] "Garbage"
	    packet.gpio[0] = buffer.get(4);								//GPIO_DDR	- Data Direction Register
	    packet.gpio[1] = buffer.get(5);								//GPIO_OUT	- Current state of outputs
	    packet.gpio[2] = buffer.get(6);								//GPIO_IN	- Current state of inputs
	    packet.gpio[3] = buffer.get(7);								//GPIO_PUE	- ???    
	    
	    //Quad Encoders	    
	    packet.quad_in[0] = buffer.getInt(8);
	    packet.quad_in[1] = buffer.getInt(12);
	    packet.quad_in[2] = buffer.getInt(16);
	    packet.quad_in[3] = buffer.getInt(20);	   	    
	    
	    //Velocities
	    packet.velocity_in[0] = buffer.getInt(24);
	    packet.velocity_in[1] = buffer.getInt(28);												//[30 MSB] [29] [28] [27 LSB]
	    packet.velocity_in[2] = buffer.getInt(32);
	    packet.velocity_in[3] = buffer.getInt(36);    
	  
	    //Analog Inputs
	    packet.analog_in[0] = buffer.getShort(40);
	    packet.analog_in[1] = buffer.getShort(42);
	    packet.analog_in[2] = buffer.getShort(44);
	    packet.analog_in[3] = buffer.getShort(46);
	    packet.analog_in[4] = buffer.getShort(48);
	    packet.analog_in[5] = buffer.getShort(50);
	    packet.analog_in[6] = buffer.getShort(52);
	    packet.analog_in[7] = buffer.getShort(54);
	    
	    return packet;
	}

	public byte  getGpioDDR(){
		return gpio[0];
	}
	
	public byte getGpioOut(){
		return gpio[1];
	}
	
	public byte getGpioIn(){
		return gpio[2];
	}
	
	public byte getGpioPUE(){
		System.out.println("What the heck is 'PUE' ?");
		return gpio[3];
	}
	
	public int getQuad (int channel){		
		return quad_in[channel - 1];
	}
	
	public int getVelocity (int channel){		
		return velocity_in[channel - 1];	
	}
	
	public short getAnalogInputRaw (int channel){		
		return analog_in[channel - 1];		
	}
	
	
}