package client;

/**
 * Interface that includes all functionality of the BankingDAO
 * 
 * @author Grant Sweeney
 * @date 2/22/2016
 * @course CMSC495
 * @project Cryptography Banking Application
 * @updated by Jonathan Wojack on 2/24/2016
 * @updated by Jonathan Wojack on 2/27/2016
 * 
 * Changes:
 * 
 * Converted comments into Javadoc comments
 * 
 */

/**
 * Interface
 * 
 */

public interface DAOInterface {
    
    /**

     * Sends log in information to be checked against database records
     * 
     * @param data: username, password
     * 
     * @return User type (customer or employee) if valid combination, denied if invalid
     */
   
    public String confirmLogIn(String...data);
    
    /**
     * get customer information needed for start screen
     * 
     * @param data: username, password
     * 
     * @return customer first name, last name, and all customer account information
     */
    
    public String getCustomerScreenInfo(String...data);
        
    /**
     * get customer account information
     * 
     * @param data: accountNumber
     * 
     * @return account information including account balance, type, and number
     */
    
    public String getCustomerAccount(String...data);
    
    /**
     * Request for all customer information
     * 
     * @param data: firstName, lastName
     * 
     * @return all customer information including name, address, phone number, and account info
     */

    public String getCustomerInformation(String...data);
    
    /**
     * Request to create a new user
     * 
     * @param data: username, password, employeeStatus, firstName, lastName, address, city, state, zipCode, phoneNumber
     * 
     * @return "confirm" if created, "username taken" or "profile exists" if these errors occur
     */

    public String createUserProfile(String...data);
    
    /**
     * Request to create a new bank account
     * 
     * @param data: accountType, accountBalance, date
     * 
     * @return String including new account number and all entered information, "error" if error occurs
     */
    
    public String createNewAccount(String...data);
    
    /**
     * Request to delete a user profile
     * 
     * @param data: firstName, lastName
     * 
     * @return "confirm" if deleted, "error" if error occurs
     */
    
    public String deleteUserProfile(String...data);
    
    /**
     * Request to delete bank account
     * 
     * @param data: accountNumber
     * 
     * @return "confirm" if deleted, "error" if error occurs
     */
    
    public String deleteAccount(String...data);
    
    /**
     * Request for the transaction history of a bank account
     * 
     * @param data: accountNumber
     * 
     * @return transaction history, including all fields to populate transaction screen
     *         comma-separated fields, with newlines between transactions
     */
    
    public String getTransactionHistory(String...data);
    
    /**
     * Request to deposit money in selected account
     * 
     * @param data: accountNumber, amount
     * 
     * @return new account balance if successful, "error" if error occurs
     */
    
    public String depositMoney(String...data);

    /**
     * Request to withdraw money from selected account
     * 
     * @param data: accountNumber, amount
     *
     * @return new account balance if successful, error type if error occurs
     */
    
    public String withdrawMoney(String...data);
    
    /**
     * Request to transfer money between two accounts
     * 
     * @param data: accountFrom, amount, accountTo
     * 
     * @return new account balance for both accounts if successful, error type if error occurs
     */
    
    public String transferMoney(String...data);
    
    /**
     * Request to pay mortgage from a bank account
     * 
     * @param data: accountFrom, amount, mortgageAccount
     * 
     * @return new account balance for both accounts if successful, error type if error occurs
     */
    
    public String payMortgage(String...data);
    
}
