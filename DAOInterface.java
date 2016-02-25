package client;

/**
 * Interface that includes all functionality of the BankingDAO
 * 
 * @author Grant Sweeney
 * @date 2/22/2016
 * @course CMSC495
 * @project Cryptography Banking Application
 * @updated by Jonathan Wojack on 2/24/2016
 * 
 * Changes:
 * 
 * Changed all methods to accept a variable number of arguments to permit
 * returning an error message and not terminating the application
 * if an incorrect quantity is passed to the corresponding method
 * 
 * Each method stores its parameters as String[]
 * 
 */

// interface

public interface DAOInterface {
    
    /**

     * Sends log in information to be checked against database records
     * 
     * @param data
     * 
     * @return User type (customer or employee) if valid combination, denied if invalid
     */
   
    public String confirmLogIn(String...data);
    
        // method parameters:

        // username
        // password
    
    /**
     * get customer information needed for start screen
     * 
     * @param data
     * 
     * @return customer first name, last name, and all customer account information
     */
    
    public String getCustomerScreenInfo(String...data);
    
        // method parameters:

        // username
        // password
    
    /**
     * get customer account information
     * 
     * @param data
     * 
     * @return account information including account balance, type, and number
     */
    
    public String getCustomerAccount(String...data);
    
        // method parameters:
    
        // accountNumber
    
    /**
     * Request for all customer information
     * 
     * @param data
     * 
     * @return all customer information including name, address, phone number, and account info
     */

    public String getCustomerInformation(String...data);
    
        // method parameters:
    
        // firstName
        // lastname
    
    /**
     * Request to create a new user
     * 
     * @param data
     * 
     * @return "confirm" if created, "username taken" or "profile exists" if these errors occur
     */

    public String createUserProfile(String...data);
        
        // method parameters:

        // username
        // password
        // employeeStatus
        // firstName
        // lastName
        // address
        // city
        // state
        // zipCode
        // phoneNumber
    
    /**
     * Request to create a new bank account
     * 
     * @param data
     * 
     * @return String including new account number and all entered information, "error" if error occurs
     */
    
    public String createNewAccount(String...data);
        
        // method parameters:
        
        // accountType
        // accountBalance
        // date
    
    /**
     * Request to delete a user profile
     * 
     * @param data
     * 
     * @return "confirm" if deleted, "error" if error occurs
     */
    
    public String deleteUserProfile(String...data);
    
        // method parameters:
    
        // firstName
        // lastName
    
    /**
     * Request to delete bank account
     * 
     * @param data
     * 
     * @return "confirm" if deleted, "error" if error occurs
     */
    
    public String deleteAccount(String...data);
    
        // method parameters:

        // accountNumber
    
    /**
     * Request for the transaction history of a bank account
     * 
     * @param data
     * 
     * @return transaction history, including all fields to populate transaction screen
     *         comma-separated fields, with newlines between transactions
     */
    
    public String getTransactionHistory(String...data);
    
        // method parameters:

        // accountNumber
    
    /**
     * Request to deposit money in selected account
     * 
     * @param data
     * 
     * @return new account balance if successful, "error" if error occurs
     */
    
    public String depositMoney(String...data);
    
        // method parameters:

        // accountNumber
        // amount
    
    /**
     * Request to withdraw money from selected account
     * 
     * @param data
     *
     * @return new account balance if successful, error type if error occurs
     */
    
    public String withdrawMoney(String...data);
    
        // method parameters:

        // accountNumber
        // amount
    
    /**
     * Request to transfer money between two accounts
     * 
     * @param data
     * 
     * @return new account balance for both accounts if successful, error type if error occurs
     */
    
    public String transferMoney(String...data);
    
        // method parameters:

        // accountFrom
        // amount
        // accountTo
    
    /**
     * Request to pay mortgage from a bank account
     * 
     * @param data
     * 
     * @return new account balance for both accounts if successful, error type if error occurs
     */
    
    public String payMortgage(String...data);
    
        // method parameters:

        // accountFrom
        // amount
        // mortgageAccount
    
} // end interface
