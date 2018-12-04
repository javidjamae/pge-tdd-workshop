package com.tdd.bank.service;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class BalanceAlertTest {

	@Test
	public void balanceUnder50() {

		// setup
		BalanceService balanceService = new BalanceService();

		try {
			// execute
			balanceService.checkBalance(49);
			fail("should have thrown exception");
		} catch (BalanceAlertError e) {
			// verify
			assertEquals("Low balance alert email sent", e.getMessage());
		}
	}

	@Test
	public void balanceAbove50() {

		// setup
		BalanceService balanceService = new BalanceService();

		// execute
		String alert = balanceService.checkBalance(51);

		// verify
		assertNull(alert);
	}

}
