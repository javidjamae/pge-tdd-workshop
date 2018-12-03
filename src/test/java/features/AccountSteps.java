package features;

import static org.junit.Assert.assertEquals;

import com.pge.bank.service.BankService;

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
	
	private String actualAccountNumber;

	@When("^I ask for my account balance$")
	public void i_ask_for_my_account_balance() throws Exception {
		throw new PendingException();
	}

	@Given("^a valid account number with a balance of \\$(\\d+)\\.(\\d+)$")
	public void aValidAccountNumberWithABalanceOf$(int dollars, int cents) throws Throwable {
		throw new PendingException();
	}

	@Then("^an invalid account error occurs$")
	public void anInvalidAccountErrorOccurs() throws Throwable {
		throw new PendingException();
	}

	@Then("^the balance is \\$(\\d+)\\.(\\d+)$")
	public void theBalanceIs$(int dollars, int cents) throws Throwable {
		throw new PendingException();
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
		BankService bankService = new BankService();
		bankService.createAccount(firstName, lastName, depositInCents, governmentIdNumber);
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
		assertEquals("Account number must be exactly 9 digits", 9, this.governmentIdNumber.length());
	}

}
