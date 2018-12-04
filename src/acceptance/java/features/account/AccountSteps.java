package features.account;

import static org.junit.Assert.assertEquals;

import com.tdd.bank.domain.Account;
import com.tdd.bank.service.AccountCreationError;
import com.tdd.bank.service.AccountNumberGenerator;
import com.tdd.bank.service.BankService;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccountSteps {
	
	private String firstName;
	private String lastName;
	private int depositInCents;
	private String governmentIdNumber;
	private Account account;
	
	private String actualAccountNumber;
	private String actualErrorMessage;
	private int actualBalance;

	@When("^I ask for my account balance$")
	public void i_ask_for_my_account_balance() throws Exception {
		this.actualBalance = account.getBalanceInPennies();
	}

	@Given("^a valid account with a balance of \\$(\\d+)\\.(\\d+)$")
	public void aValidAccountWithABalanceOf(int dollars, int cents) throws Throwable {
		this.account = new Account();
		account.deposit(dollars * 100 + cents);
	}

	@Then("^an invalid account error occurs$")
	public void anInvalidAccountErrorOccurs() throws Throwable {
		throw new PendingException();
	}

	@Then("^the account balance is \\$(\\d+)\\.(\\d+)$")
	public void theAccountBalanceIs(int dollars, int cents) throws Throwable {
		assertEquals("Incorrect account balance", dollars*100 + cents, actualBalance);
	}

	@Given("^an invalid government id number$")
	public void anInvalidGovernmentIdNumber() throws Throwable {
		throw new PendingException();
	}

	@Given("^a valid government id number$")
	public void aValidGovernmentIdNumber() throws Throwable {
		this.governmentIdNumber = "2345678901";
	}

	@And("^a valid first name$")
	public void aValidFirstName() throws Throwable {
		this.firstName = "Javid";
	}

	@And("^a valid last name$")
	public void aValidLastName() throws Throwable {
		this.lastName = "Jamae";
	}

	@And("^an initial deposit of \\$(\\d+)\\.(\\d+)$")
	public void anInitialDepositOf(int dollars, int cents) throws Throwable {
		this.depositInCents = 100 * dollars + cents;
	}

	@Then("^the account creation is (.*)$")
	public void theAccountCreationIs(String expectedStatus) throws Throwable {

		String actualStatus;
		if ( this.actualAccountNumber != null ) {
			actualStatus = "successful";
		} else {
			actualStatus = "unsuccessful";
		}
		
		assertEquals( expectedStatus, actualStatus );
	}

	@When("^I attempt to create an account$")
	public void iAttemptToCreateAnAccount() throws Throwable {
		//TODO: Instead of loading a fake AccountNumberGenerator, create a real one and use it here
		AccountNumberGenerator generator = new AccountNumberGenerator() {
			@Override
			public String generateAccountNumber() {
				return "123456789";
			}
		};
		BankService bankService = new BankService();
		bankService.setAccountNumberGenerator(generator);
		try {
			this.actualAccountNumber = bankService.createAccount(firstName, lastName, depositInCents, governmentIdNumber);
		} catch ( AccountCreationError e ) {
			this.actualErrorMessage = e.getMessage();
		}
	}
	

	@And("^an invalid first name$")
	public void anInvalidFirstName() throws Throwable {
		this.firstName = "";
	}

	@And("^an invalid last name$")
	public void anInvalidLastName() throws Throwable {
		this.lastName = "";
	}

	@Given("^a government id number of (.*)$")
	public void aGovernmentIdNumberOf(String accountNumber) throws Throwable {
		this.governmentIdNumber = accountNumber;
	}

	@And("^the account number is valid$")
	public void theAccountNumberIsValid() throws Throwable {
		assertEquals("Account number length incorrect:", 9, this.actualAccountNumber.length());
	}

	@And("^the error is \"([^\"]*)\"$")
	public void theErrorIs(String errorMessage) throws Throwable {
		if( errorMessage.length() > 0 ) {
			assertEquals("The error message is incorrect", errorMessage, this.actualErrorMessage);
		}
	}
}
