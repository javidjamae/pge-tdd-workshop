package com.tdd.bank.service;

public enum CODENUM {
	SIXTYFOUR(64),THREE(3),SIX(6),NINE(9),TWElVE(12);
	
	private final int months;
	
	CODENUM(int months){
		this.months = months;
	}

	public int getValue() {
		// TODO Auto-generated method stub
		return this.months;
	}

}
