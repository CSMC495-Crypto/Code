 
package client;
import cryptography.DataProcessor;
import data.DataObject;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
/**
 * Implements the DAOInterface and converts GUI data into SQL database commands
 * and transceives data with the server
 * 
 * @author Jonathan Wojack
 * @date 2/27/2016
 * @course CMSC495
 * @project Cryptography Banking Application
 * 
 */
public class BankingDAO implements DAOInterface {
    
    String username = "";
    String password = "";
    
    public String client(String plainText, Boolean requestType) {
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
            // get user input from text field and convert to data to send to server
          
              
          
            // encrypt data to be sent to server with custom XOR encryption algorithm       
        
            DataObject clientEncryptedObject = dataProcessor.encryptData(plainText);
                
            // transmit encrypted data to the server
                
            ObjectOutputStream toServerOOS = new ObjectOutputStream(socket.getOutputStream());
            toServerOOS.writeObject(clientEncryptedObject);
            toServerOOS.flush();
            // get data from server
        
            String dataReturned = "";
                
            if (requestType) {  // if data is to be returned
                
                // get number of cells in selected SQL table
        
                DataObject cellsObject = null;        
                ObjectInputStream fromServerOISCells = new ObjectInputStream(socket.getInputStream());              
                cellsObject = (DataObject) fromServerOISCells.readObject();
                String cellsString = dataProcessor.decryptData(cellsObject).trim();
                
                // get number of columns in selected SQL table
                        
                DataObject columnsObject = null;        
                ObjectInputStream fromServerOISColumns = new ObjectInputStream(socket.getInputStream());              
                columnsObject = (DataObject) fromServerOISColumns.readObject();
                String columnsString = dataProcessor.decryptData(columnsObject).trim();
                
           //     System.out.println("cellsString: " + cellsString);
                        
                int cells = Integer.parseInt(cellsString);
                int columns = Integer.parseInt(columnsString);
                
             //   System.out.println("cells: " + cells);
                
                int rows = cells/columns;
                                      
                // get table data from server, decrypt, and then process and display data
       
                for (int i = 0; i < rows; i++) {  // rows of data in table                 
                  
                    for (int j = 0; j < columns; j++) {
                      
                        DataObject serverEncryptedObjectLoop = null;                      
                        ObjectInputStream fromServerLoop = new ObjectInputStream(socket.getInputStream());
                        serverEncryptedObjectLoop = (DataObject) fromServerLoop.readObject();
                        
                        StringBuilder stringBuilder = new StringBuilder();
                        
                        dataReturned = stringBuilder.append(dataReturned).append(dataProcessor.decryptData(serverEncryptedObjectLoop) + "\n").toString();
                        
                        
                        
                        
                //        System.out.println("dataReturned: " + dataReturned);
                                
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
                
          //      System.out.println("sggsg");
                
                DataProcessor dataProcessorFalse = new DataProcessor();
                       
          //      System.out.println("RETURNING: " + dataProcessorFalse.decryptData(serverEncryptedObject));
                
                return dataProcessorFalse.decryptData(serverEncryptedObject);    // return update status       
                        
            }
            
        }   catch (Exception ex) {
                
        }
    
        return "";
    
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
        
        // transmit request
        
        String username = data[0];
        String password = data[1];
        
        String command = ("Login " + username + " " + password);
        
        setUsername(username);
        setPassword(password);
        
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
        String count = client(command, true).trim();
        
       
        
        if (Integer.parseInt(count) == 0) {
            
            return "Error: Invalid username or password";
            
        }
        
        command = "SELECT personData.firstName, personData.lastName, accountNumber, accountType, "
                + "accountBalance FROM (SELECT * FROM personData INNER JOIN Accounts ON "
                + "personData.IDNumber = Accounts.ID)personData WHERE personData.Username='" + username +
                "' AND Password='" + password + "';";
        return client(command, true);
 
   
       
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
        
        command = "SELECT personData.firstName, personData.lastName, personData.phoneNumber, "
                + "personData.Address, personData.City, personData.State, personData.zipCode, accountNumber, "
                + "accountType, accountBalance, dateCreated FROM (SELECT * FROM personData INNER JOIN Accounts ON "
                + "personData.IDNumber = Accounts.ID)personData WHERE personData.firstName='" + firstName + 
                "' AND personData.lastName='" + lastName + "';";
        return client(command, true);
        
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
        String iD = client(command, true);
        int idNumber = Integer.parseInt(iD) + 1;
        
        command = "CREATE USER '" + username + "' IDENTIFIED BY '" + password + "';";
        client(command, false);
        
        if (employeeStatus.startsWith("employee")) {
        
            command = "GRANT ALL PRIVILEGES ON *.* TO '" + username + "' IDENTIFIED BY '" + password + "';";
            client(command, false);
        
        }
        
        else {
            
            command = "GRANT SELECT, UPDATE ON *.* TO '" + username + "' IDENTIFIED BY '" + password + "';";
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
        String confirm = client(command, true);
        
        if (Integer.parseInt(confirm) == 1) {
            
            return "Confirmed";
            
        }
        
        return "Error: User profile creation failed";
        
    }
    
    /**
     * Request to create a new bank account
     * 
     * @param data: accountType, accountBalance, date, idNumber
     * 
     * @return String including new account number and all entered information, "error" if error occurs
     */
    
    @Override
    public String createNewAccount(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 4).isEmpty()) {
            
            return errorChecking(data, 3);
            
        }
        
        String accountType = data[0];
        String accountBalance = data[1];
        String date = data[2];
      
        String command = ("getRows Accounts");        
        String idNumber = client(command, false);
        
        command = ("SELECT accountNumber FROM Accounts ORDER BY IDNumber DESC LIMIT 1;");
        String accountNumber = client(command, false);
        
        Random random = new Random();
        
        int newAccountNumber = Integer.parseInt(accountNumber) + random.nextInt(10);
        
        command = ("INSERT INTO Accounts VALUES('" + idNumber + "', '" + newAccountNumber + "', '" +
                accountBalance + "', '" + date + "');");
        
        return client(command, true);
        
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
        
        String command = ("DELETE FROM personData WHERE firstName='" + firstName + "' AND lastName='" + 
                lastName + "';");
        
        return client(command, false);
        
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
        
        String command = ("DELETE FROM Accounts WHERE accountNumber='" + accountNumber + "';");
        
        return client(command, false);
        
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
        
        String command = ("SELECT * FROM Transactions WHERE accountNumber='" + accountNumber + "';");
        
        return client(command, true);
        
    }
    
    /**
     * Request to deposit money in selected account
     * 
     * @param data: accountNumber, amount
     * 
     * @return new account balance if successful, "error" if error occurs
     */
    
    public String depositMoney(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 2).isEmpty()) {
            
            return errorChecking(data, 2);
            
        }
        
        String accountNumber = data[0];
        double amount = Integer.parseInt(data[1]);
        
        String command = ("UPDATE Accounts SET accountBalance = accountBalance + " + amount + " WHERE "
                + "accountNumber='" + accountNumber + "';");
        
        String result = client(command, false);
        
        command = ("SELECT ID FROM Accounts WHERE accountNumber='" + accountNumber + ';');        
        String idNumber = client(command, false);
        
        command = ("SELECT COUNT(*) FROM Transactions"); 
        int transactionNumber = Integer.parseInt(client(command, false).trim());
        
        command = ("SELECT endingBalance FROM Transactions WHERE accountNumber='" + accountNumber + 
                "' ORDER BY transactionNumber DESC LIMIT 1;");
        double startingBalance = Integer.parseInt(client(command, false).trim());
        
        double endingBalance = startingBalance + amount;
        
        command = ("INSERT INTO Transactions VALUES(" + transactionNumber + ", '" + idNumber + "', '" +
                accountNumber + ", " + startingBalance + ", 'Deposit', " + amount + ", " + endingBalance + ");");
        
        return client(command, false);
        
    }
    /**
     * Request to withdraw money from selected account
     * 
     * @param data: accountNumber, amount
     *
     * @return new account balance if successful, error type if error occurs
     */
    
    public String withdrawMoney(String...data){
        
        // validate arguments
        
        if (!errorChecking(data, 2).isEmpty()) {
            
            return errorChecking(data, 2);
            
        }
        
        String accountNumber = data[0];
        double amount = Integer.parseInt(data[1]);
        
        String command = ("UPDATE Accounts SET accountBalance = accountBalance - " + amount + " WHERE "
                + "accountNumber='" + accountNumber + "';");
        
        String result = client(command, false);
        
        command = ("SELECT ID FROM Accounts WHERE accountNumber='" + accountNumber + ';');        
        String idNumber = client(command, false);
        
        command = ("SELECT COUNT(*) FROM Transactions");       


        int transactionNumber = Integer.parseInt(client(command, false).trim());
        
        command = ("SELECT endingBalance FROM Transactions WHERE accountNumber='" + accountNumber + 
                "' ORDER BY transactionNumber DESC LIMIT 1;");
        double startingBalance = Integer.parseInt(client(command, false).trim());
        
        double endingBalance = startingBalance - amount;
        
        command = ("INSERT INTO Transactions VALUES(" + transactionNumber + ", '" + idNumber + "', '" +
                accountNumber + ", " + startingBalance + ", 'Withdrawal', " + amount + ", " + endingBalance + ");");
        
        return client(command, false);
        
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
        double amount = Integer.parseInt(data[1]);
        String accountTo = data[2];
        
        String command = ("SELECT accountBalance FROM Accounts WHERE accountNumber='" + accountFrom + "';");
        double amountFrom = Integer.parseInt(client(command, false).trim());
        
        command = ("SELECT accountBalance FROM Accounts WHERE accountNumber='" + accountTo + "';");
        double amountTo = Integer.parseInt(client(command, false).trim());
        
        double amountFromFinal = amountFrom - amount;
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
        
        command = ("SELECT ID FROM Accounts WHERE accountNumber='" + accountFrom + ';');        
        String idNumberFrom = client(command, false);
        
        command = ("SELECT ID FROM Accounts WHERE accountNumber='" + accountTo + ';');        
        String idNumberTo = client(command, false);
        
        command = ("getRows Transactions");        
        int transactionNumber = Integer.parseInt(client(command, false).trim());
        
        command = ("SELECT endingBalance FROM Transactions WHERE accountNumber='" + accountFrom + 
                "' ORDER BY transactionNumber DESC LIMIT 1;");
        double startingBalanceFrom = Integer.parseInt(client(command, false).trim());
        
        command = ("SELECT endingBalance FROM Transactions WHERE accountNumber='" + accountTo + 
                "' ORDER BY transactionNumber DESC LIMIT 1;");
        double startingBalanceTo = Integer.parseInt(client(command, false).trim());
        
        double endingBalanceFrom = startingBalanceFrom - amount;
        double endingBalanceTo = startingBalanceTo + amount;
        
        command = ("INSERT INTO Transactions VALUES(" + transactionNumber + ", '" + idNumberFrom + "', '" +
                accountFrom + ", " + startingBalanceFrom + ", 'Withdrawal - Transfer', " + amount + ", " + 
                endingBalanceFrom + ");");
        client(command, false);
        
        transactionNumber++;
        
        command = ("INSERT INTO Transactions VALUES(" + transactionNumber + ", '" + idNumberTo + "', '" +
                accountTo + ", " + startingBalanceTo + ", 'Deposit - Transfer', " + amount + ", " + 
                endingBalanceTo + ");");
        return client(command, false);
        
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
        double amount = Integer.parseInt(data[1]);
        String mortgageAccount = data[2];
        
        String command = ("SELECT accountBalance FROM Accounts WHERE accountNumber='" + accountFrom + "';");
        double amountFrom = Integer.parseInt(client(command, false).trim());
        
        command = ("SELECT accountBalance FROM Accounts WHERE accountNumber='" + mortgageAccount + "';");
        double amountTo = Integer.parseInt(client(command, false).trim());
        
        double amountFromFinal = amountFrom - amount;
        double amountToFinal = amountTo + amount;
        
        if (amountFromFinal < 0) {
            
            return "Error: Insufficient funds";
            
        }
        
        command = ("UPDATE Accounts SET accountBalance = " + amountFromFinal + " WHERE "
                + "accountNumber='" + accountFrom + "';");        
        client(command, false);
        
        command = ("UPDATE Accounts SET accountBalance = " + amountToFinal + " WHERE "
                + "accountNumber='" + mortgageAccount + "';");        
        client(command, false);
        
        command = ("SELECT IDNumber FROM Accounts WHERE accountNumber='" + accountFrom + ';');        
        String idNumberFrom = client(command, false);
        
        command = ("SELECT IDNumber FROM Accounts WHERE accountNumber='" + mortgageAccount + ';');        
        String idNumberTo = client(command, false);
        
        command = ("getRows Transactions");        
        int transactionNumber = Integer.parseInt(client(command, false).trim());
        
        command = ("SELECT endingBalance FROM Transactions WHERE accountNumber='" + accountFrom + 
                "' ORDER BY transactionNumber DESC LIMIT 1;");
        double startingBalanceFrom = Integer.parseInt(client(command, false).trim());
        
        command = ("SELECT endingBalance FROM Transactions WHERE accountNumber='" + mortgageAccount + 
                "' ORDER BY transactionNumber DESC LIMIT 1;");
        double startingBalanceTo = Integer.parseInt(client(command, false).trim());
        
        double endingBalanceFrom = startingBalanceFrom - amount;
        double endingBalanceTo = startingBalanceTo + amount;
        
        command = ("INSERT INTO Transactions VALUES(" + transactionNumber + ", '" + idNumberFrom + "', '" +
                accountFrom + ", " + startingBalanceFrom + ", 'Withdrawal - Transfer', " + amount + ", " + 
                endingBalanceFrom + ");");
        client(command, false);
        
        transactionNumber++;
        
        command = ("INSERT INTO Transactions VALUES(" + transactionNumber + ", '" + idNumberTo + "', '" +
                mortgageAccount + ", " + startingBalanceTo + ", 'Deposit - Transfer', " + amount + ", " + 
                endingBalanceTo + ");");
        return client(command, false);
        
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
    
    public void setUsername(String username) {
        
        this.username = username;
        
    }
    
    public void setPassword(String password) {
        
        this.password = password;
        
    }
    
    public String getUsername() {
        
        return this.username;
        
    }
    
    public String getPassword() {
        
        return this.password;
        
    }
    
}