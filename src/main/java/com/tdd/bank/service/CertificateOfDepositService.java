package com.tdd.bank.service;

import com.tdd.bank.domain.CDAccount;

public class CertificateOfDepositService {

	public int calculateDeposit(int amt, int months) {

		if (amt < 0) {
			throw new CODError("Invalid Amount");
		}
		if (CODENUM.NINE.getValue() == months) {
			return amt * 9 * 100;
		} else if (CODENUM.SIXTYFOUR.getValue() == months) {
			return amt * 64 * 100;
		} else if (CODENUM.THREE.getValue() == months) {
			return amt * 3 * 100;
		} else if (CODENUM.SIX.getValue() == months) {
			return amt * 6 * 100;
		} else if (CODENUM.TWElVE.getValue() == months) {
			return amt * 12 * 100;
		} else {
			throw new CODError("Invalid Term for Certificate of Deposit");
		}
	}

	public boolean depositeIntoCD(CDAccount account) throws CODError {
		if (!account.getAccountType().equals("CD")) {
			throw new CODError("Invalid Account type");
		}
		if (account.getDespositAmt() != 1000.00 && account.getDespositAmt() != 5000.00) {
			throw new CODError("Invalid Amount deposited");
		}
		return true;
	}

}
