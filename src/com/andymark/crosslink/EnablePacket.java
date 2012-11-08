package com.andymark.crosslink;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class EnablePacket implements Message {
	
	private short sequence = 0;
	private EnableState state = EnableState.DISABLED;
	private ByteBuffer buffer = ByteBuffer.allocate(18);
	
	
	
	@Override
	public ByteBuffer getMessage() {
		
		buffer.clear();
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putShort((short) 0xaaac);  // sig
		buffer.putShort((short) 18);  // byte len
		buffer.put(state.getValue());  // enable state
		buffer.put((byte) 0x0);  // reserved
		
		buffer.putLong(0xffffffffffffffffl);  // output enables
		buffer.putShort(sequence++);  // sequence
		buffer.putShort((short) Utilities.checksum(buffer, 0, 16));  // crc
		return buffer;
	}
	
	public EnableState getEnableState() {
		return state;
	}
	
	public void setEnableState(EnableState state) {
		this.state = state;
	}
}
