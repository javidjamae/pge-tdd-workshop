package com.tdd.bank.service;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CertificateOfDepositTest {
	
	@Test
	public void invalidAmount(){
		//setup
		int amt = -1;
		CertificateOfDepositService codService = new CertificateOfDepositService();
		// execute
		try {
			// execute
			codService.calculateDeposit(amt, 64);
			fail("Should have thrown error");
		} catch (CODError e) {
			// verify
			assertEquals("Invalid Amount", e.getMessage());
		}
		
		
	}

	@Test
	public void calculateDeposit_Sixty_Four_Months() {

		// setup
		int amt = 2000;
		CertificateOfDepositService codService = new CertificateOfDepositService();

			// execute
			assertEquals((amt * 64 * 100), codService.calculateDeposit(amt, 64));

	}
	
	@Test
	public void calculateDeposit_THREE_Months() {
		// setup
		int amt = 2000;
		CertificateOfDepositService codService = new CertificateOfDepositService();
		// execute
			assertEquals((amt * 3 * 100), codService.calculateDeposit(amt, 3));
	}
	
	@Test
	public void calculateDeposit_NINE_Months() {
		// setup
		int amt = 2000;
		CertificateOfDepositService codService = new CertificateOfDepositService();
		// execute
			assertEquals((amt * 9 * 100), codService.calculateDeposit(amt, 9));
	}
	
	@Test
	public void calculateDeposit_TWELVE_Months() {
		// setup
		int amt = 2000;
		CertificateOfDepositService codService = new CertificateOfDepositService();
		// execute
			assertEquals((amt * 12 * 100), codService.calculateDeposit(amt, 12));
	}
	
	@Test
	public void calculateDeposit_Invalid_Months() {
		int amt = 2000;
		// setup
		CertificateOfDepositService codService = new CertificateOfDepositService();
		try {
			// execute
			codService.calculateDeposit(amt, 10);
			fail("should have thrown exception");
		} catch (CODError e) {
			// verify
			assertEquals("Invalid Term for Certificate of Deposit",e.getMessage());
		}
	}

	@Test
	public void calculateDeposit_SIX_Months() {
		int amt = 2000;
		// setup
		CertificateOfDepositService codService = new CertificateOfDepositService();
			// execute
			assertEquals((amt * 6 * 100), codService.calculateDeposit(amt, 6));
	}

}
