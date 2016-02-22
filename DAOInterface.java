package client;

/**
 * Interface that includes all functionality of the BankingDAO
 * 
 * @author Grant
 */

/*
 * Project: CryptographyBankingApplication
 * Course: CMSC 495
 * Date: 02/22/2016
 */
public interface DAOInterface {
    /**
     * Sends log in information to be checked against database records
     * 
     * @param username Entered Username to be checked
     * @param password Entered Password to be checked
     * @return User type (customer or employee) if valid combination, denied if invalid
     */
    public String confirmLogIn(String username, String password);
    
    /**
     * Requests information needed for customer start screen
     * 
     * @param username customer username
     * @param password customer password
     * @return customer first name, last name, and all customer account information
     */
    public String getCustomerScreenInfo(String username, String password);
    
    /**
     * Request for account information
     * 
     * @param accountNumber account number being searched for
     * @return account information including account balance, type, and number
     */
    public String getCustomerAccount(String accountNumber);
    
    /**
     * Request for all customer information
     * 
     * @param firstName customer first name used for search
     * @param lastName customer last name used for search
     * @return all customer information including name, address, phone number, and account info
     */
    public String getCustomerInformation(String firstName, String lastName);
    
    /**
     * Reqest to create a new user
     * 
     * @param username entered username
     * @param password entered password
     * @param employeeStatus yes if employee checkbox is checked
     * @param firstName entered first name
     * @param lastName entered last name
     * @param address entered address
     * @param city entered city
     * @param state entered state
     * @param zipCode entered zip code
     * @param phoneNumber entered phone number
     * @return "confirm" if created, "username taken" or "profile exists" if these errors occur
     */
    public String createUserProfile(String username, String password, String employeeStatus,
                                    String firstName, String lastName, String address, String city,
                                    String state, String zipCode, String phoneNumber);
    
    /**
     * Request to create a new bank account
     * 
     * @param accountType string containing the selected combobox type
     * @param accountBalance balance for the new account
     * @param date date the account is create
     * @return string including new account number and all entered information, "error" if error occurs
     */
    public String createNewAccount(String accountType, String accountBalance, String date);
    
    /**
     * Request to delete a user profile
     * 
     * @param firstName name used to search for profile
     * @param lastName name used to search for profile
     * @return "confirm" if deleted, "error" if error occurs
     */
    public String deleteUserProfile(String firstName, String lastName);
    
    /**
     * Request to delete bank account
     * 
     * @param accountNumber account number used to search for account
     * @return "confirm" if deleted, "error" if error occurs
     */
    public String deleteAccount(String accountNumber);
    
    /**
     * Request for the transaction history of a bank account
     * 
     * @param accountNumber account number used to search for account
     * @return transaction history, including all fields to populate transaction screen
     */
    public String getTransactionHistory(String accountNumber);
    
    /**
     * Request to deposit money in selected account
     * 
     * @param accountNumber account to deposit money
     * @param amount amount to deposit
     * @return new account balance if successful, "error" if error occurs
     */
    public String depositMoney(String accountNumber, String amount);
    
    /**
     * Request to withdraw money from selected account
     * 
     * @param accountNumber account to withdraw money from
     * @param amount amount to withdraw
     * @return new account balance if successful, error type if error occurs
     */
    public String withdrawMoney(String accountNumber, String amount);
    
    /**
     * Request to transfer money between two accounts
     * 
     * @param accountFrom account money is transfered from
     * @param amount amount to transfer
     * @param accountTo account money is transfered to
     * @return new account balance for both accounts if successful, error type if error occurs
     */
    public String transferMoney(String accountFrom, String amount, String accountTo);
    
    /**
     * Request to pay mortgage from a bank account
     * 
     * @param accountFrom account money is taken from
     * @param amount amount to pay
     * @param mortgageAccount mortgage to be payed
     * @return new account balance for both accounts if successful, error type if error occurs
     */
    public String payMortgage(String accountFrom, String amount, String mortgageAccount);
    
} //end interface