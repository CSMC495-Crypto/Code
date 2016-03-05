package client;

import cryptography.DataProcessor;
import data.DataObject;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Implements the DAOInterface and converts GUI data into SQL database commands
 * and transceives data with the server
 * 
 * @author Jonathan Wojack
 * @date 2/27/2016
 * @project Cryptography Banking Application
 * @updated by Jonathan Wojack on 3/4/2016
 * 
 * Changes:
 * 
 * 1.  Completed code for all methods and specified all database commands except for database login
 * 2.  Beautified code
 * 3.  Added comments
 * 
 */

public class BankingDAO implements DAOInterface {
    
    String username = "";
    String password = "";
    
    /**
     * 
     * @param plainText
     * @param requestType
     * @return Decrypted server response as a String 
     */
    
    private String client(String plainText, Boolean requestType) {

        // declare I/O streams
  
        DataOutputStream toServer;
        DataInputStream fromServer;  
    
        // establish connection to server
    
        try {
        
            //  Socket socket = new Socket("localhost", 8000); // local connection
            Socket socket = new Socket("68.134.160.249", 8000);  // network connection
          
            // create an input stream to receive data from the server
      
            fromServer = new DataInputStream(socket.getInputStream());
      
            // create an output stream to send data to the server
      
            toServer = new DataOutputStream(socket.getOutputStream());                 
            DataProcessor dataProcessor = new DataProcessor();

            // get user input, encrypt it, package in an object ready to be sent to the server       
        
            DataObject clientEncryptedObject = dataProcessor.encryptData(plainText);
                
            // transmit encrypted data to the server
                
            ObjectOutputStream toServerOOS = new ObjectOutputStream(socket.getOutputStream());
            toServerOOS.writeObject(clientEncryptedObject);
            toServerOOS.flush();

            // get data from server
        
            String dataReturned = "";
                
            if (requestType) {  // if data is to be returned from the database
                
                // get number of cells in selected SQL table
        
                DataObject cellsObject = null;        
                ObjectInputStream fromServerOISCells = new ObjectInputStream(socket.getInputStream());              
                cellsObject = (DataObject) fromServerOISCells.readObject();
                String cellsString = dataProcessor.decryptData(cellsObject).trim();
                
                // get number of columns, cells, and rows in selected SQL table
                        
                DataObject columnsObject = null;        
                ObjectInputStream fromServerOISColumns = new ObjectInputStream(socket.getInputStream());              
                columnsObject = (DataObject) fromServerOISColumns.readObject();
                String columnsString = dataProcessor.decryptData(columnsObject).trim();
                int cells = Integer.parseInt(cellsString);
                int columns = Integer.parseInt(columnsString);
                int rows = cells/columns;
                                      
                // get table data from server, decrypt, and then process and display data
       
                for (int i = 0; i < rows; i++) {                 
                  
                    for (int j = 0; j < columns; j++) {
                      
                        DataObject serverEncryptedObjectLoop = null;                      
                        ObjectInputStream fromServerLoop = new ObjectInputStream(socket.getInputStream());
                        serverEncryptedObjectLoop = (DataObject) fromServerLoop.readObject();
                        
                        // concatenate output into one String separated by newlines
                        
                        StringBuilder stringBuilder = new StringBuilder();                        
                        dataReturned = stringBuilder.append(dataReturned).append(dataProcessor.decryptData(serverEncryptedObjectLoop) + "\n").toString();
                        
                    }
                                              
                } 
                
                return dataReturned;    // return requested data from database
                        
            }
                    
            else {  // if only a database update is to be performed        
                        
                DataObject serverEncryptedObject = null;            
                ObjectInputStream fromServerOIS = new ObjectInputStream(socket.getInputStream());
                        
                // get response from server                
              
                serverEncryptedObject = (DataObject) fromServerOIS.readObject();
              
                // decrypt and report server response
                
                DataProcessor dataProcessorFalse = new DataProcessor();
                
                return dataProcessorFalse.decryptData(serverEncryptedObject);    // return update status       
                        
            }
            
        }   catch (Exception ex) {
                
        }
    
        return null;
    
    }
    
    /**
     * Sends login information to be checked against database records
     * 
     * @param data: username, password
     * 
     * @return User type (customer or employee) if valid combination, denied if invalid
     */
   
    @Override
    public String confirmLogIn(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 2).isEmpty()) {
            
            return errorChecking(data, 2);
            
        }
        
        // store parameters
        
        String username = data[0];
        String password = data[1];
        
        // send login request to server
        
        String command = ("Login " + username + " " + password);       
        return client(command, false);
        
    }
    
    /**
     * get customer information needed for start screen
     * 
     * @param data: username, password
     * 
     * @return customer first name, last name, and all customer account information
     */
    
    @Override
    public String getCustomerScreenInfo(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 2).isEmpty()) {
            
            return errorChecking(data, 2);
            
        }
        
        // transmit request
        
        String username = data[0];
        String password = data[1];
        
        String command = "SELECT COUNT(*) FROM personData WHERE Username='" + username + "' AND Password='" +
                password + "';";
        int count = Integer.parseInt(client(command, true).trim());
       
        if (count == 0) {
            
            return "Error: Invalid username or password";
            
        }
        
        command = "SELECT firstName, lastName FROM personData "
                + "WHERE Username='" + username + "' AND Password='" + password + "' ORDER BY IDNumber DESC "
                + "LIMIT 1;";
        String info = client(command, true);
        
        command = "SELECT IDNumber FROM personData WHERE Username='" + username + "' AND Password='" + 
                password + "' ORDER BY IDNumber DESC LIMIT 1;";
        String id = client(command, true).trim();
        
        command = "SELECT accountNumber, accountType, accountBalance FROM Accounts WHERE ID='" + 
                id + "';";
        return info + client(command, true);
 
   
       
    }
        
    /**
     * get customer account information
     * 
     * @param data: accountNumber
     * 
     * @return account information including account balance, type, and number
     */
    
    @Override
    public String getCustomerAccount(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 1).isEmpty()) {
            
            return errorChecking(data, 1);
            
        }
        
        // transmit request
        
        String accountNumber = data[0];
        
        String command = "SELECT COUNT(*) FROM Accounts WHERE accountNumber='" + accountNumber + "';";
        String count = client(command, true).trim();
        
       
        
        if (Integer.parseInt(count) == 0) {
            
            return "Error: Account does not exist";
            
        }
        
        command = "SELECT accountNumber, accountType, accountBalance FROM Accounts WHERE accountNumber='" + 
                accountNumber + "';";
        return client(command, true);
    }
    
    /**
     * Request for all customer information
     * 
     * @param data: firstName, lastName
     * 
     * @return all customer information including name, address, phone number, and account info
     */

    @Override
    public String getCustomerInformation(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 2).isEmpty()) {
            
            return errorChecking(data, 2);
            
        }
        
        // transmit request
        
        String firstName = data[0];
        String lastName = data[1];
        
        String command = ("SELECT COUNT(*) FROM personData WHERE firstName='" + firstName + "' AND lastName='" + lastName + "';");
        String count = client(command, true).trim();
        
                
        if (Integer.parseInt(count) == 0) {
            
            return "Error: No such customer";
            
        }
        
        command = "SELECT phoneNumber, Address, City, State, zipCode FROM personData WHERE "
                + "firstName='" + firstName + "' AND lastName='" + lastName + "' ORDER BY IDNumber DESC LIMIT "
                + "1;";
        String info = client(command, true);
        
        command = "SELECT IDNumber FROM personData WHERE firstName='" + firstName + "' AND lastName='" + 
                lastName + "' ORDER BY IDNumber DESC LIMIT 1;";
        String id = client(command, true).trim();
        
        command = "SELECT accountNumber, accountType, accountBalance, dateCreated FROM Accounts WHERE ID='" + 
                id + "';";
        return firstName + "\n" + lastName + "\n" + info + client(command, true);
        
    }
    
    /**
     * Request to create a new user
     * 
     * @param data: firstName, lastName, phoneNumber, address, city, state, zipCode, username, password, employeeStatus
     * 
     * @return "confirm" if created, "username taken" or "profile exists" if these errors occur
     */

    @Override
    public String createUserProfile(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 10).isEmpty()) {
            
            return errorChecking(data, 10);
            
        }
        
        if (data[6].matches(".*[a-zA-Z]+.*")) { // if ZIP code field contains a letter
            
            return "Error: Invalid ZIP Code";
            
        }
        
        // transmit request
        
        String firstName = data[0];
        String lastName = data[1];
        String phoneNumber = data[2];
        String address = data[3];
        String city = data[4];
        String state = data[5];
        String zipCode = data[6];
        String username = data[7];
        String password = data[8];
        String employeeStatus = data[9];
        
        String command = "SELECT COUNT(*) FROM personData WHERE firstName='" + firstName + "' AND lastName='" +
                lastName + "' AND phoneNumber='" + phoneNumber + "' AND Address='" + address + "' AND City='" +
                city + "' AND State='" + state + "' AND zipCode='" + zipCode + "' AND employeeStatus='" +
                employeeStatus + "';";
        String duplicate = client(command, true).trim();
        
        if (Integer.parseInt(duplicate) > 0) {
            
            return "Error: Profile already exists";
        
        }
        
        command = "SELECT COUNT(*) FROM personData WHERE Username='" + username + "';";
        duplicate = client(command, true).trim();
        
        if (Integer.parseInt(duplicate) > 0) {
            
            return "Error: Username already exists";
        
        }
        
        command = "SELECT COUNT(*) FROM personData";        
        String idNumber = client(command, true).trim();
        idNumber = Integer.toString(Integer.parseInt(idNumber) + 1);
        
        command = "CREATE USER '" + username + "' IDENTIFIED BY '" + password + "';";
        client(command, false);
        
        if (employeeStatus.startsWith("employee")) {
        
            command = "GRANT ALL PRIVILEGES ON *.* TO '" + username + "' IDENTIFIED BY '" + password + "'"
                    + " WITH GRANT OPTION;";
            client(command, false);
        
        }
        
        else {
            
            command = "GRANT SELECT, UPDATE ON *.* TO '" + username + "' IDENTIFIED BY '" + password + 
                    "' WITH GRANT OPTION;";
            client(command, false);
        
        }
        
        command = "INSERT INTO personData VALUES('" + firstName + "', '" + lastName + "', '" + phoneNumber + 
                "', '" + address + "', '" + city + "', '" + state + "', '" + zipCode + "', '" + username + 
                "', '" + password + "', '" + idNumber + "', '" + employeeStatus + "');";
        client(command, false);
        
        command = "SELECT COUNT(*) FROM personData WHERE firstName='" + firstName + "' AND lastName='" +
                lastName + "' AND phoneNumber='" + phoneNumber + "' AND Address='" + address + "' AND City='" +
                city + "' AND State='" + state + "' AND zipCode='" + zipCode + "' AND Username='" + username +
                "' AND Password='" + password + "' AND IDNumber='" + idNumber + "' AND employeeStatus='" +
                employeeStatus + "';";
        String confirm = client(command, true).trim();
        
        if (Integer.parseInt(confirm) == 1) {
            
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            String dateString = dateFormat.format(date).toString();
            
            return "Confirmed" + "\n" + createNewAccount("Savings", "1000", dateString, firstName, lastName);
            
        }
        
        return "Error: User profile creation failed";
        
    }
    
    /**
     * Request to create a new bank account
     * 
     * @param data: accountType, accountBalance, date, firstName, lastName
     * 
     * @return String including new account number and all entered information, "error" if error occurs
     */
    
    @Override
    public String createNewAccount(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 5).isEmpty()) {
            
            return errorChecking(data, 5);
            
        }
        
        String accountType = data[0];
        String accountBalance = data[1];
        String date = data[2];
        String firstName = data[3];
        String lastName = data[4];
      
        String command = "SELECT COUNT(*) FROM personData WHERE firstName='" + firstName + "' AND lastName='"
                + lastName + "';";        
        String duplicate = client(command, true).trim();
        
        if (Integer.parseInt(duplicate) == 0) {
            
            return "Error: No such customer";
            
        }
        
        command = "SELECT IDNumber FROM personData WHERE firstName='" + firstName + "' AND lastName='"
                + lastName + "' ORDER BY IDNumber DESC LIMIT 1;";
        String id = client(command, true).trim();
        
        command = ("SELECT accountNumber FROM Accounts ORDER BY ID DESC LIMIT 1;");
        String accountNumber = client(command, true).trim();
        
        Random random = new Random();
        String newAccountNumber = null;
        
        do {
            
            int x = 1;
            
            newAccountNumber = Integer.toString(Integer.parseInt(accountNumber) + random.nextInt(10 * x));
            
            command = "SELECT COUNT(*) FROM Accounts WHERE accountNumber='" + newAccountNumber + "';";
            
            x++;
        
        } while(Integer.parseInt(client(command, true).trim()) != 0);
        
        command = ("INSERT INTO Accounts VALUES('" + id + "', '" + newAccountNumber + "', '" +
                accountType + "', '" + accountBalance + "', '" + date + "');");
        client(command, false);
        
        command = ("SELECT COUNT(*) FROM Transactions;");        
        int transactionNumber = Integer.parseInt(client(command, true).trim()) + 1;
        
        command = "INSERT INTO Transactions VALUES(" + transactionNumber + ", '" + id + "', '" + 
                accountNumber + "', 0, 'Open Account', 1000, 1000);";
        client(command, false);
        
        return newAccountNumber + "\n" + accountType + "\n" + accountBalance + "\n" + date;
        
    }
    
    /**
     * Request to delete a user profile
     * 
     * @param data: firstName, lastName
     * 
     * @return "confirm" if deleted, "error" if error occurs
     */
    
    public String deleteUserProfile(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 2).isEmpty()) {
            
            return errorChecking(data, 2);
            
        }
        
        String firstName = data[0];
        String lastName = data[1];
        String command = "SELECT COUNT(*) FROM personData WHERE firstName='" + firstName + "' AND lastName='" 
                + lastName + "';";
        int person = Integer.parseInt(client(command, true).trim());
        if (person == 0) {
            return "Error: User does not exist";
        }
        
        command = "SELECT Username FROM personData WHERE firstName='" + firstName + "' AND lastName='" + lastName + "';";
        String username = client(command, true).trim();
        command = ("DELETE FROM personData WHERE firstName='" + firstName + "' AND lastName='" + 
                lastName + "';");
        client(command, false);       
        command = "DROP USER '" + username + "';";
        client(command, false);
        return "Confirmed: User deleted";
    }
    
    /**
     * Request to delete bank account
     * 
     * @param data: accountNumber
     * 
     * @return "confirm" if deleted, "error" if error occurs
     */
    
    public String deleteAccount(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 1).isEmpty()) {
            
            return errorChecking(data, 1);
            
        }
        
        String accountNumber = data[0];
        String command = "SELECT COUNT(*) FROM Accounts WHERE accountNumber='" + accountNumber + "';";
        int account = Integer.parseInt(client(command, true).trim());
        if (account == 0) {
            return "Error: Account does not exist";
        }        
        
        command = ("DELETE FROM Accounts WHERE accountNumber='" + accountNumber + "';");        
        client(command, false);
        command = ("DELETE FROM Transactions WHERE accountNumber='" + accountNumber + "';");        
        client(command, false);
        return "Confirmed: Account deleted";


        
    }
    
    /**
     * Request for the transaction history of a bank account
     * 
     * @param data: accountNumber
     * 
     * @return transaction history, including all fields to populate transaction screen
     *         comma-separated fields, with newlines between transactions
     */
    
    public String getTransactionHistory(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 1).isEmpty()) {
            
            return errorChecking(data, 1);
            
        }
        
        String accountNumber = data[0];
        
        String command = "SELECT COUNT(*) FROM Accounts WHERE accountNumber='" + accountNumber + "';";
        int account = Integer.parseInt(client(command, true).trim());
        
        if (account == 0) {
            
            return "Error: Account does not exist";
            
        }
        
        command = ("SELECT COUNT(*) FROM Transactions WHERE accountNumber='" + accountNumber + "';");
        account = Integer.parseInt(client(command, true).trim());
        
        if (account == 0) {
            
            return "Error: Account has no transaction history";
            
        }
        
        command = "SELECT @rownum:=@rownum+1 'endingBalance', p.accountNumber, p.startingBalance, "
                + "p.transactionType, p.Amount, p.endingBalance FROM Transactions p, (SELECT @rownum:=0) "
                + "r WHERE accountNumber='" + accountNumber + "';";
        return client(command, true);
        
    }
    
    /**
     * Request to deposit money in selected account
     * 
     * @param data: accountNumber, amount
     * 
     * @return new account balance if successful, "error" if error occurs
     */
    
    @Override
    public String depositMoney(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 2).isEmpty()) {
            
            return errorChecking(data, 2);
            
        }
        
        String accountNumber = data[0];
        
        String command = "SELECT COUNT(*) FROM Accounts WHERE accountNumber='" + accountNumber + "';";
        int account = Integer.parseInt(client(command, true).trim());
        
        if (account == 0) {
            
            return "Error: Account does not exist";
            
        }
        
        double amount = 0;
        
        try {
            
            amount = Double.parseDouble(data[1]);
            
        } catch(NumberFormatException ex) {
            
            return "Error: Amount is not numeric";
            
        }
        
        
        if (amount < 0) {
            
            return "Error: Amount must be a positive value";
            
        }
        
        command = "SELECT accountBalance FROM Accounts WHERE accountNumber='" + accountNumber + "';";
        double balance = Double.parseDouble(client(command, true));
        
        double result = balance + amount;
        
        
        command = ("UPDATE Accounts SET accountBalance = " + result + " WHERE "
                + "accountNumber='" + accountNumber + "';");
        
        client(command, false);
        
        command = ("SELECT ID FROM Accounts WHERE accountNumber='" + accountNumber + "';");        
        String idNumber = client(command, true).trim();
        
        command = ("SELECT COUNT(*) FROM Transactions;");        
        int transactionNumber = Integer.parseInt(client(command, true).trim()) + 1;
        
        command = ("SELECT endingBalance FROM Transactions WHERE accountNumber='" + accountNumber + 
                "' ORDER BY transactionNumber DESC LIMIT 1;");
        double startingBalance = Double.parseDouble(client(command, true).trim());
        double endingBalance = startingBalance + amount;
        
        command = ("INSERT INTO Transactions VALUES(" + transactionNumber + ", '" + idNumber + "', '" +
                accountNumber + "', " + balance + ", 'Deposit', " + amount + ", " + result + 
                ");");        
        client(command, false);
        
        command = "SELECT endingBalance FROM Transactions WHERE transactionNumber = " + transactionNumber +
                ";";
        return client(command, true).trim();
        
        
        
    }

    /**
     * Request to withdraw money from selected account
     * 
     * @param data: accountNumber, amount
     *
     * @return new account balance if successful, error type if error occurs
     */
    
    @Override
    public String withdrawMoney(String...data){
        
        // validate arguments
        
        if (!errorChecking(data, 2).isEmpty()) {
            
            return errorChecking(data, 2);
            
        }
        
        String accountNumber = data[0];
        
        String command = "SELECT COUNT(*) FROM Accounts WHERE accountNumber='" + accountNumber + "';";
        int account = Integer.parseInt(client(command, true).trim());
        
        if (account == 0) {
            
            return "Error: Account does not exist";
            
        }
        
        
        
        double amount = 0;
        
        try {
            
            amount = Double.parseDouble(data[1]);
            
        } catch(NumberFormatException ex) {
            
            return "Error: Amount is not numeric";
            
        }
        
        if (amount < 0) {
            
            return "Error: Amount must be a positive value";
            
        }
        
        command = "SELECT accountBalance FROM Accounts WHERE accountNumber='" + accountNumber + "';";
        double balance = Double.parseDouble(client(command, true));
        
        double result = balance - amount;
        
        if (result < 0) {
            
            return "Error: Insufficient funds";
            
        }
        
        command = ("UPDATE Accounts SET accountBalance = " + result + " WHERE "
                + "accountNumber='" + accountNumber + "';");
        
        client(command, false);
        
        command = ("SELECT ID FROM Accounts WHERE accountNumber='" + accountNumber + "';");        
        String idNumber = client(command, true).trim();
        
        command = ("SELECT COUNT(*) FROM Transactions;");        
        int transactionNumber = Integer.parseInt(client(command, true).trim()) + 1;
        
        command = ("SELECT endingBalance FROM Transactions WHERE accountNumber='" + accountNumber + 
                "' ORDER BY transactionNumber DESC LIMIT 1;");
        double startingBalance = Double.parseDouble(client(command, true).trim());
        
        double endingBalance = startingBalance - amount;
        
        if (endingBalance < 0) {
            
            return "Error: Insufficient funds";
            
        }
        
        command = ("INSERT INTO Transactions VALUES(" + transactionNumber + ", '" + idNumber + "', '" +
                accountNumber + "', " + balance + ", 'Withdrawal', " + amount + ", " + result + 
                ");");        
        client(command, false);
        
        command = "SELECT endingBalance FROM Transactions WHERE transactionNumber = " + transactionNumber + 
                ";";
        return client(command, true).trim();
        
        
        
    }
    
    /**
     * Request to transfer money between two accounts
     * 
     * @param data: accountFrom, amount, accountTo
     * 
     * @return new account balance for both accounts if successful, error type if error occurs
     */
    
    public String transferMoney(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 3).isEmpty()) {
            
            return errorChecking(data, 3);
            
        }
        
        String accountFrom = data[0];
        
        String command = "SELECT COUNT(*) FROM Accounts WHERE accountNumber='" + accountFrom + "';";
        int account = Integer.parseInt(client(command, false).trim());
        
        if (account == 0) {
            
            return "Error: Source account does not exist";
            
        }
        
        
        double amount = 0;
        
        try {
            
            amount = Double.parseDouble(data[1]);
            
        } catch(NumberFormatException ex) {
            
            return "Error: Amount is not numeric";
            
        }
        
        if (amount < 0) {
            
            return "Error: Amount must be a positive value";
            
        }
        String accountTo = data[2];
        
        command = "SELECT COUNT(*) FROM Accounts WHERE accountNumber='" + accountTo + "';";
        account = Integer.parseInt(client(command, true).trim());
        
        if (account == 0) {
            
            return "Error: Destination account does not exist";
            
        }
        
        command = ("SELECT accountBalance FROM Accounts WHERE accountNumber='" + accountFrom + "';");
        double amountFrom = Double.parseDouble(client(command, true).trim());
        
        command = ("SELECT accountBalance FROM Accounts WHERE accountNumber='" + accountTo + "';");
        double amountTo = Double.parseDouble(client(command, true).trim());
        
        double amountFromFinal = amountFrom - amount;
        
        if (amountFromFinal < 0) {
            
            return "Error: Insufficient funds";
            
        }
        
        double amountToFinal = amountTo + amount;
        
        if (amountFromFinal < 0) {
            
            return "Error: Insufficient funds";
            
        }
        
        command = ("UPDATE Accounts SET accountBalance = " + amountFromFinal + " WHERE "
                + "accountNumber='" + accountFrom + "';");        
        client(command, false);
        
        command = ("UPDATE Accounts SET accountBalance = " + amountToFinal + " WHERE "
                + "accountNumber='" + accountTo + "';");        
        client(command, false);
        
        command = ("SELECT ID FROM Accounts WHERE accountNumber='" + accountFrom + "';");        
        String idNumberFrom = client(command, true).trim();
        
        command = ("SELECT ID FROM Accounts WHERE accountNumber='" + accountTo + "';");        
        String idNumberTo = client(command, true).trim();
        
        command = ("SELECT COUNT(*) FROM Transactions;");        
        int transactionNumber = Integer.parseInt(client(command, true).trim()) + 1;
        
        command = ("SELECT endingBalance FROM Transactions WHERE accountNumber='" + accountFrom + 
                "' ORDER BY transactionNumber DESC LIMIT 1;");
        double startingBalanceFrom = Double.parseDouble(client(command, true).trim());
        
        command = ("SELECT endingBalance FROM Transactions WHERE accountNumber='" + accountTo + 
                "' ORDER BY transactionNumber DESC LIMIT 1;");
        double startingBalanceTo = Double.parseDouble(client(command, true).trim());
        
        double endingBalanceFrom = startingBalanceFrom - amount;
        double endingBalanceTo = startingBalanceTo + amount;
     
        command = ("INSERT INTO Transactions VALUES(" + transactionNumber + ", '" + idNumberFrom + "', '" +
                accountFrom + "', " + amountFrom + ", 'Withdrawal - Transfer', " + amount + ", " + 
                amountFromFinal + ");");
        client(command, false);
        
        int transactionNumberNext = transactionNumber + 1;
        
        command = ("INSERT INTO Transactions VALUES(" + transactionNumberNext + ", '" + idNumberTo + "', '" +
                accountTo + "', " + amountTo + ", 'Deposit - Transfer', " + amount + ", " + 
                amountToFinal + ");");
        client(command, false);
        
        command = "SELECT endingBalance FROM Transactions WHERE transactionNumber = " + transactionNumber +
                " OR transactionNumber = " + transactionNumberNext + " ORDER BY transactionNumber ASC LIMIT 2;";
        return client(command, true).trim();
        
        
        
        
    }
    
    /**
     * Request to pay mortgage from a bank account
     * 
     * @param data: accountFrom, amount, mortgageAccount
     * 
     * @return new account balance for both accounts if successful, error type if error occurs
     */
    
    public String payMortgage(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 3).isEmpty()) {
            
            return errorChecking(data, 3);
            
        }
        
        String accountFrom = data[0];
        
        String command = "SELECT COUNT(*) FROM Accounts WHERE accountNumber='" + accountFrom + "';";
        int account = Integer.parseInt(client(command, true).trim());
        
        if (account == 0) {
            
            return "Error: Source account does not exist";
            
        }
        
        double amount = 0;
        
        try {
            
            amount = Double.parseDouble(data[1]);
            
        } catch(NumberFormatException ex) {
            
            return "Error: Amount is not numeric";
            
        }
        
        if (amount < 0) {
            
            return "Error: Amount must be a positive value";
            
        }
        String mortgageAccount = data[2];
        
        command = "SELECT COUNT(*) FROM Accounts WHERE accountNumber='" + mortgageAccount + "' AND "
                + "accountType='Mortgage';";
        account = Integer.parseInt(client(command, true).trim());
        
        if (account == 0) {
            
            return "Error: Mortgage account does not exist";
            
        }
        
        command = ("SELECT accountBalance FROM Accounts WHERE accountNumber='" + accountFrom + "';");
        double amountFrom = Double.parseDouble(client(command, true).trim());
        
        command = ("SELECT accountBalance FROM Accounts WHERE accountNumber='" + mortgageAccount + "';");
        double amountTo = Double.parseDouble(client(command, true).trim());
        
        double amountFromFinal = amountFrom - amount;
        
        if (amountFromFinal < 0) {
            
            return "Error: Insufficient funds";
            
        }
        
        double amountToFinal = amountTo - amount;
        
        if (amountFromFinal < 0) {
            
            return "Error: Insufficient funds";
            
        }
        
        command = ("UPDATE Accounts SET accountBalance = " + amountFromFinal + " WHERE "
                + "accountNumber='" + accountFrom + "';");        
        client(command, false);
        
        command = ("UPDATE Accounts SET accountBalance = " + amountToFinal + " WHERE "
                + "accountNumber='" + mortgageAccount + "';");        
        client(command, false);
        
        command = ("SELECT ID FROM Accounts WHERE accountNumber='" + accountFrom + "';");        
        String idNumberFrom = client(command, true).trim();
        
        command = ("SELECT ID FROM Accounts WHERE accountNumber='" + mortgageAccount + "';");        
        String idNumberTo = client(command, true).trim();
        
        command = ("SELECT COUNT(*) FROM Transactions;");        
        int transactionNumber = Integer.parseInt(client(command, true).trim()) + 1;
        
        command = ("SELECT endingBalance FROM Transactions WHERE accountNumber='" + accountFrom + 
                "' ORDER BY transactionNumber DESC LIMIT 1;");
        double startingBalanceFrom = Double.parseDouble(client(command, true).trim());
        
        command = ("SELECT endingBalance FROM Transactions WHERE accountNumber='" + mortgageAccount + 
                "' ORDER BY transactionNumber DESC LIMIT 1;");
        double startingBalanceTo = Double.parseDouble(client(command, true).trim());
        
        double endingBalanceFrom = startingBalanceFrom - amount;
        double endingBalanceTo = startingBalanceTo - amount;
        
        command = ("INSERT INTO Transactions VALUES(" + transactionNumber + ", '" + idNumberFrom + "', '" +
                accountFrom + "', " + amountFrom + ", 'Withdrawal - Mortgage Payment', " + amount + ", " + 
                amountFromFinal + ");");
        client(command, false);
        
        int transactionNumberNext = transactionNumber + 1;
        
        command = ("INSERT INTO Transactions VALUES(" + transactionNumberNext + ", '" + idNumberTo + "', '" +
                mortgageAccount + "', " + amountTo + ", 'Deposit - Mortgage Payment', " + amount + ", " + 
                amountToFinal + ");");
        client(command, false);
        
        command = "SELECT endingBalance FROM Transactions WHERE transactionNumber = " + transactionNumber +
                " OR transactionNumber = " + transactionNumberNext + " ORDER BY transactionNumber ASC "
                + "LIMIT 2;";
        return client(command, true).trim();
        
       
        
    }
    
    public String errorChecking(String[] data, int numberArguments) {
        
        // check for valid number of arguments
        
        if (data.length != numberArguments) {
            
            return "Error: Invalid number of arguments.  " + numberArguments + " arguments expected.";
            
        }
        
        // verify that none of the arguments are empty strings
        
        for (int i = 0; i < numberArguments; i++) {
            
            if (data[i].isEmpty()) {
                
                return "Error: Empty argument value.";
                
            }
            
        }
        
        return "";
        
    }
    
   
    

    
}
