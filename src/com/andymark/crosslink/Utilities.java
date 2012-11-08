package com.andymark.crosslink;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Utilities {
	
	private static final int ENCRYPT_ROUNDS = 16;

	public static int checksum(ByteBuffer data, int offset, int length) {
		data.order(ByteOrder.LITTLE_ENDIAN);
		short sum = 0;
		for (int i = offset; i < offset + length; i += 2) {
			sum += data.getShort(i);
		}
		return ((~sum + 1) & 0xffff);
	}

	public static void encrypt(int[] value, int[] key) {
		int sum = 0;
		int delta = 0x9E3779B9;
		for (int i = 0; i < ENCRYPT_ROUNDS; i++) {
			value[0] += (((value[1] << 4) ^ (value[1] >> 5)) + value[1])
					^ (sum + key[sum & 3]);
			sum += delta;
			value[1] += (((value[0] << 4) ^ (value[0] >> 5)) + value[0])
					^ (sum + key[(sum >> 11) & 3]);
		}
	}

	public static void decrypt(int[] value, int[] key) {
		final int num_rounds = 16;
		int delta = 0x9E3779B9;
		int sum = delta * num_rounds;
		for (int i = 0; i < num_rounds; i++) {
			value[1] -= (((value[0] << 4) ^ (value[0] >> 5)) + value[0]) ^ (sum + key[(sum >> 11) & 3]);
			sum -= delta;
			value[0] -= (((value[1] << 4) ^ (value[1] >> 5)) + value[1]) ^ (sum + key[sum & 3]);
		}
	}
}
