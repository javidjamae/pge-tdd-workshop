package com.tdd.bank.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class CertificateOfDepositTest {

	@Test
	public void calculateDeposit_Sixty_Four_Months() {

		// setup
		int amt = 2000;
		CertificateOfDepositService codService = new CertificateOfDepositService();

		try {
			// execute
			assertEquals((amt * 64 * 100), codService.calculateDeposit(amt, 64));
		} catch (CODError e) {
			// verify
			assertEquals("Invalid Term for Certificate of Deposit", e.getMessage());
		}

	}

}
