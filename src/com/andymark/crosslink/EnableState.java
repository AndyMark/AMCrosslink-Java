package com.andymark.crosslink;

public enum EnableState {
	
	DISABLED {
		public byte getValue() {
			return 0;
		}
	},
	TELEOP {
		public byte getValue() {
			return 1;
		}
	},
	AUTONOMOUS {
		public byte getValue() {
			return 2;
		}
	};
	
	public abstract byte getValue();
}
