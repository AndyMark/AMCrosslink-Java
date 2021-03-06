package com.andymark.crosslink.Packets;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.andymark.crosslink.Message;
import com.andymark.crosslink.Utilities;

public class Canipede implements Message {
	
	private short pwm[] = new short[8];
	private byte relay[] = new byte[4];
	private byte solenoid[] = new byte[8];
	private byte led[] = new byte[3];	
	private ByteBuffer buffer = ByteBuffer.allocate(40);
	
	@Override
	public ByteBuffer getMessage() {
		
		buffer.clear();
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putShort((short) 0xaaa6);  // sig
		buffer.putShort((short) 40); // byte len
		buffer.put((byte) 1);  // rcmNodeId;
		buffer.put((byte) 0);  // reserved
		
		for (short val : pwm) {
			buffer.putShort(val);
		}
		
		for (byte val : relay) {
			buffer.put(val);
		}
		
		for (byte val : solenoid) {
			buffer.put(val);
		}
		
		for (byte val : led) {
			buffer.put(val);
		}
		
		buffer.put((byte) 0);  // empty
		
		
		short checksum = (short) Utilities.checksum(buffer, 0, 38);
		buffer.putShort(checksum);
		return buffer;
	}
	
	
	public void SetRelayValue(int channel, byte dir){
		
		relay[channel - 1] = dir;	
		
	}

	public void SetSolenoidValue(int channel, boolean value){
		solenoid[channel - 1] = (byte) (value ? 1:0);		
	}
	
	public void SetPWMValue(int channel, short value){
		//double scale = (((double)value)/100.0) * 8470.0;
		//scale += 3300;
		
		pwm[channel - 1] = value; //(short) scale;
	}
}
