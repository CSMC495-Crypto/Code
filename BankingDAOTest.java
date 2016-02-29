import static org.junit.Assert.*;

import org.junit.Test;

import client.BankingDAO;

public class BankingDAOTest {
	
	BankingDAO dao = new BankingDAO();
	
	@Test
	public void testConfirmLogIn(){
		//tests confirmLogIn method
		BankingDAO dao1 = new BankingDAO(); 
		String userName = "default";
		String password = "superSecretPassword";
		dao1.confirmLogIn(userName, password);
		
		//testing with correct user name and password
		assertTrue(dao1.getUsername().equals(userName));
		assertTrue(dao1.getPassword().equals(password));
		
		BankingDAO dao2 = new BankingDAO(); 
		String wrongName = "wrong";
		String wrongPassword = "123";
		//testing with wrong user name and password
		assertFalse(dao2.getUsername().equals(wrongName));
		assertFalse(dao2.getPassword().equals(wrongPassword));
		
		BankingDAO dao3 = new BankingDAO(); 
		//testing with wrong user name and correct password
		assertFalse(dao3.getUsername().equals(wrongName));
		assertFalse(dao3.getPassword().equals(password));
		
		BankingDAO dao4 = new BankingDAO(); 
		//testing with correct user name and wrong password
		assertFalse(dao4.getUsername().equals(userName));
		assertFalse(dao4.getPassword().equals(wrongPassword));
				
	}
	
	@Test
	public void testErrorChecking(){
		//testing errorChecking method
		
		
		String[] str = {"My", "name", "is", "Olga"};
		
		//pass correct number of arguments
		assertTrue(dao.errorChecking(str, 4).equals(""));
		
		//pass wrong number of arguments
		int numberArguments = 6;
		String errorMessage = "Error: Invalid number of arguments.  " + numberArguments + " arguments expected.";
		assertTrue(dao.errorChecking(str, 6).equals(errorMessage));
		
		int numberArguments1 = 3;
		String errorMessage1 = "Error: Invalid number of arguments.  " + numberArguments1 + " arguments expected.";
		assertTrue(dao.errorChecking(str, 3).equals(errorMessage1));
		
		//pass empty arguments
		String[] str2 = {"Olga", "is", "", "tired"};
		String errorMessage2 = "Error: Empty argument value.";
		assertTrue(dao.errorChecking(str2, 4).equals(errorMessage2));
		
	}
	

}
