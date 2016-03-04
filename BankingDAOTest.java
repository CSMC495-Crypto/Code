package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import client.BankingDAO;

public class BankingDAOTest {

	BankingDAO dao = new BankingDAO();

	@Test
	public void testConfirmLogIn() {
		// tests confirmLogIn method
		BankingDAO dao1 = new BankingDAO();
		String userName = "default";
		String password = "superSecretPassword";
		dao1.confirmLogIn(userName, password);

		// testing with correct user name and password
		assertTrue(dao1.getUsername().equals(userName));
		assertTrue(dao1.getPassword().equals(password));

		BankingDAO dao2 = new BankingDAO();
		String wrongName = "wrong";
		String wrongPassword = "123";
		// testing with wrong user name and password
		assertFalse(dao2.getUsername().equals(wrongName));
		assertFalse(dao2.getPassword().equals(wrongPassword));

		BankingDAO dao3 = new BankingDAO();
		// testing with wrong user name and correct password
		assertFalse(dao3.getUsername().equals(wrongName));
		assertFalse(dao3.getPassword().equals(password));

		BankingDAO dao4 = new BankingDAO();
		// testing with correct user name and wrong password
		assertFalse(dao4.getUsername().equals(userName));
		assertFalse(dao4.getPassword().equals(wrongPassword));

	}

	@Test
	public void testErrorChecking() {
		// testing errorChecking method

		String[] str = { "My", "name", "is", "Olga" };

		// pass correct number of arguments
		assertTrue(dao.errorChecking(str, 4).equals(""));

		// pass wrong number of arguments
		int numberArguments = 6;
		String errorMessage = "Error: Invalid number of arguments.  "
				+ numberArguments + " arguments expected.";
		assertTrue(dao.errorChecking(str, 6).equals(errorMessage));

		int numberArguments1 = 3;
		String errorMessage1 = "Error: Invalid number of arguments.  "
				+ numberArguments1 + " arguments expected.";
		assertTrue(dao.errorChecking(str, 3).equals(errorMessage1));

		// pass empty arguments
		String[] str2 = { "Olga", "is", "", "tired" };
		String errorMessage2 = "Error: Empty argument value.";
		assertTrue(dao.errorChecking(str2, 4).equals(errorMessage2));

	}

	@Test
	public void testGetCustomerScreenInfo() {

	}

	@Test
	public void testGetCustomerInformation() {

		String userName = "okozlova";
		String password1 = "password";
		// login
		dao.confirmLogIn(userName, password1);

		// search for a particular customer that exists in the database

		String[] customerInfo = { "Thomas", "Jefferson", "202-456-1111",
				"1600 Pennsylvania Avenue", "Washington", "DC", "20500",
				"18011809", "Savings", "5050.00", "02022016" };
		String[] returnedCustomerInfo = dao.getCustomerInformation("Thomas",
				"Jefferson").split(System.getProperty("line.separator"));

		assertTrue(customerInfo[0].equals(returnedCustomerInfo[0]));

		// search for a customer that does NOT exist in the database

		String error = "Error: No such customer";

		assertTrue(error.equals(dao.getCustomerInformation("XX", "Kazlova")));

		// pass empty argument value

		// System.out.print(dao.getCustomerInformation("Thomas", ""));

		assertTrue("Error: Empty argument value.".equals(dao
				.getCustomerInformation("Thomas", "")));

	}

	@Test
	public void testGetCustomerAccount() {
		String userName = "okozlova";
		String password1 = "password";
		// login
		dao.confirmLogIn(userName, password1);

		// search for an existing account
		String[] account = { "18011809", "Savings", "5050.00" };
		String[] returnedAccount1 = dao.getCustomerAccount("18011809").split(
				System.getProperty("line.separator"));

		assertTrue(account[0].equals(returnedAccount1[0]));

		// pass empty arguments
		String error = "Error: Empty argument value.";

		assertTrue(error.equals(dao.getCustomerAccount("")));

		// search for an account that is not in database
		String error2 = "Error: Account does not exist";

		assertTrue(error2.equals(dao.getCustomerAccount("878787")));

	}

	@Test
	public void testDeleteUserProfile() {

	}

	@Test
	public void testDeleteAccount() {

	}

	@Test
	public void testGetTransactionHistory() {
		String userName = "okozlova";
		String password1 = "password";
		// login
		dao.confirmLogIn(userName, password1);

		// passing existing account as an argument

		// check weather a string returned

		assertTrue("java.lang.String".equals(dao
				.getTransactionHistory("18011809").getClass().getName()));

	}

	@Test
	public void testDepositMoney() {
		String userName = "okozlova";
		String password1 = "password";
		// login
		dao.confirmLogIn(userName, password1);

		// depositing $1,000 to existing account 18011809

		String deposit = "1000";
		
		//get current balance
		String[] currentBalance = dao.getCustomerAccount("18011809").split(
				System.getProperty("line.separator"));
		double balance = Double.parseDouble(currentBalance[2]);
		
		//make a deposit
		String returnedAmount = dao.depositMoney("18011809", deposit);
		
		//get new balance
		double returnedAmountDouble = Double.parseDouble(returnedAmount);
	
		System.out.print("\nCurrent balence is "+balance);

		System.out.print("\nDepositing "+deposit);
		
		System.out.print("\nReturned banace after deposit is "+returnedAmount);
		
		assertTrue(returnedAmountDouble == (balance+1000));

	}

	@Test
	public void testWithdrawMoney() {
		String userName = "okozlova";
		String password1 = "password";
		// login
		dao.confirmLogIn(userName, password1);

		// withdraw $1,000 from an existing account 18011809

		//get current balance
		String[] currentBalance = dao.getCustomerAccount("18011809").split(
				System.getProperty("line.separator"));
		double balance = Double.parseDouble(currentBalance[2]);

		String withdraw = "1000";

		String returnedAmount = dao.withdrawMoney("18011809", withdraw);

		System.out.print("\nBalance before withdrawal "+balance);
		System.out.print("\nBalance after withdrawing 1,000 is "+ returnedAmount);
		assertTrue((balance - Double.parseDouble(withdraw)) == Double
				.parseDouble(returnedAmount));

	}

	@Test
	public void testTransferMoney() {
		String userName = "okozlova";
		String password1 = "password";
		// login
		dao.confirmLogIn(userName, password1);

	}

	@Test
	public void testPayMortgage() {
		String userName = "okozlova";
		String password1 = "password";
		// login
		dao.confirmLogIn(userName, password1);

		//

	}

	@Test
	public void testCreateUserProfile() {

		String userName = "default";
		String password1 = "superSecretPassword";
		dao.confirmLogIn(userName, password1);

		String firstName = "Olga";
		String lastName = "Kazlova";
		String phoneNumber = "2404479360";
		String address = "123 street";
		String city = "Arlington";
		String state = "VA";
		String zipCode = "22209";
		String username = "okozlova";
		String password = "password";
		String personType = "employee";

		String[] array = { firstName, lastName, phoneNumber, address, city,
				state, zipCode, username, password, personType };

		// System.out.print("\nCreate new auser");
		dao.createUserProfile(array);

		// System.out.print("\nAfter create new auser " +
		// Arrays.toString(array));

		// System.out.print("\n\nCreate user profile: "+dao.getCustomerInformation(firstName,
		// lastName));

		// assertTrue()
	}

	@Test
	public void testCreateNewAccount() {

		String accountNumber = "14652";
		String accountType = "Checking";
		String accountBalance = "3,000";
		String dateCreated = "02/29/2016";

		System.out.print("\nCreate new account:");

		dao.createNewAccount(accountNumber, accountType, accountBalance,
				dateCreated);

		System.out.print("\nCreate new account: "
				+ dao.getCustomerAccount(accountNumber) + "\n");

		// assertTrue
	}

}
