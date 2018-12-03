package com.tdd.bank.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class CertificateOfDepositTest {

	
	@Test
	public void calculateDeposit_Sixty_Four_Months() {
		int amt =2000;
			// setup
				CertificateOfDepositService codService = new CertificateOfDepositService();

				try {
					// execute
					assertEquals((amt * 64 * 100), codService.calculateDeposit(amt,64));
					//fail("should have thrown exception");
				} catch (CODError e) {
					// verify
					assertEquals("Invalid Term for Certificate of Deposit", e.getMessage());
				}

		
	}

}
