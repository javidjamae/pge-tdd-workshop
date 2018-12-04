package com.tdd.bank.service;

@SuppressWarnings("serial")
public class AccountCreationError extends Error {
	public AccountCreationError(String message) {
		super(message);
	}
}