package com.andymark.crosslink;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class UpdateJaguarPacket implements Message {
	
	private short[] uiMode = new short[20];
	private short[] uiSetVoltage = new short[20];

	@Override
	public ByteBuffer getMessage() {
		
		for (int i = 16; i < 20; i++) {
			uiMode[i] = (short) 0xffff;
		}
		
		uiSetVoltage[1] = (short) 0x1999;
		
		ByteBuffer buffer = ByteBuffer.allocate(86);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putShort((short) 0xaaa0);  // sig
		buffer.putShort((short) 86); // byte len
		
		for (short val : uiMode) {
			buffer.putShort(val);
		}
		
		for (short val : uiSetVoltage) {
			buffer.putShort(val);
		}
		
		short checksum = (short) Utilities.checksum(buffer, 0, 84);
		buffer.putShort(checksum);
		return buffer;
	}

}
