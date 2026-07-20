1. BANKING SYSTEM FEATURES


- Create an account
  Allows a user to create a new bank account by entering a name, password, PIN, and initial balance.

- Log in using account number and password
  Allows an existing user to access an account using the generated account number and saved password.

- Check balance
  Displays the current amount of money stored in the logged-in account.

- Deposit money
  Adds a valid amount of money to the account balance.

- Withdraw money
  Removes a valid amount from the account balance if enough money is available.

- Transfer money
  Moves money from the logged-in account to another existing account.

- View transaction history
  Displays saved deposits, withdrawals, and transfers using transaction reference numbers.

- Log out
  Ends the current account session and returns the user to the authentication menu.

- Exit
  Stops the banking program.



2. ACCOUNT CLASS


Purpose:
The Account class represents one bank account. It stores the account information, balance, and transaction history. It is responsible for changing its own balance.

Fields:

- private String accountNumber
  Stores the unique six-digit number used to identify the account.

- private String accountName
  Stores the name of the account owner.

- private String accountPassword
  Stores the password used to log in to the account.

- private String pin
  Stores the four-digit PIN used for account security.

- private double balance
  Stores the current amount of money available in the account.

- private ArrayList<Transaction> transactionHistory
  Stores all Transaction objects connected to the account.

Constructor:

- Account(String accountNumber, String accountName,
          String accountPassword, String pin, double balance)
  Creates a new Account object and gives its fields their starting values.
  It also creates an empty transaction history list.

Getter Methods:

- getAccountNumber()
  Returns the account number.

- getAccountName()
  Returns the account owner's name.

- getAccountPassword()
  Returns the saved account password.

- getPin()
  Returns the saved PIN.

- getBalance()
  Returns the current account balance.

- getTransactionHistory()
  Returns the list of Transaction objects stored in the account.

Setter Methods:

- setAccountNumber(String accountNumber)
  Changes the account number field.

- setAccountName(String accountName)
  Changes the account owner's name.

- setAccountPassword(String accountPassword)
  Changes the account password.

- setPin(String pin)
  Changes the account PIN.

- setBalance(double balance)
  Changes the account balance.
  It rejects negative, infinite, or invalid values.

Account Methods:

- deposit(double amount)
  Adds a valid amount to the current balance.

- withdraw(double amount)
  Removes a valid amount from the current balance.
  It rejects the operation when the account does not have enough money.

- addTransactionHistory(String transactionHistory,
                        String referenceNumber)
  Creates a Transaction object and adds it to the account's transaction history.



3. TRANSACTION CLASS


Purpose:
The Transaction class represents one saved account activity, such as a deposit, withdrawal, or transfer.

Fields:

- private String transactionHistory
  Stores the complete transaction information.

- private String referenceNum
  Stores the unique seven-digit reference number of the transaction.

Constructor:

- Transaction(String transactionHistory, String referenceNum)
  Creates a Transaction object and gives it a history description and reference number.

Getter Methods:

- getHistory()
  Returns the complete transaction information.

- getReferenceNum()
  Returns the transaction reference number.

Setter Methods:

- setTransactionHistory(String transactionHistory)
  Changes the saved transaction information.

- setReferenceNum(String referenceNum)
  Changes the transaction reference number.



4. BANK CLASS


Purpose:
The Bank class manages all Account objects. It creates accounts, searches for accounts, logs users in, and transfers money between accounts.

Field:

- private ArrayList<Account> accountList
  Stores all Account objects registered in the banking system.

Constructor:

- Bank()
  Creates a Bank object with an empty account list.

Getter Method:

- getAccountList()
  Returns the collection of Account objects.

Setter Method:

- setAccountList(ArrayList<Account> accountList)
  Replaces the current account list with another valid account list.

Bank Methods:

- createAccount(Account account)
  Adds a new Account object to the bank.
  It rejects null accounts and duplicated account numbers.

- findAccountByNumber(String accountNumber)
  Searches the account list using an account number.
  It returns the matching Account object.

- findAccountByName(String accountName)
  Searches the account list using the account owner's name.

- login(String accountPassword, String accountNumber)
  Finds the account using the account number and checks whether the password is correct.

- transferMoney(String senderAccountNumber,
                String receiverAccountNumber,
                double amount)
  Finds the sender and receiver accounts.
  It withdraws money from the sender and deposits it into the receiver.



5. BANKCONTROLLER CLASS


Purpose:
The BankController class runs the program. It receives user input, displays menus, calls methods from other classes, and controls login and logout.

Static Fields:

- static boolean running
  Controls whether the whole banking program continues running.

- static Account a
  Stores the reference to the currently logged-in Account object.
  A null value means that no account is logged in.

Main Method:

- main(String[] args)
  Starts the program.
  It creates the Scanner and Bank objects.
  It controls the authentication menu and account menu.

Controller Methods:

- printMenu()
  Displays the account operations menu.

- processInput(Bank bank, Account a, Scanner sc, int c)
  Processes the selected account-menu option.
  It handles balance checking, deposit, withdrawal, transfer, history, and logout.

- authenticate(Bank bank, Scanner sc)
  Displays the login, account creation, and exit menu.
  It logs in an existing user or creates a new account.

Private Controller Methods:

- viewTransactionHistory(Account account, Scanner sc)
  Displays transaction reference numbers.
  It searches for and displays the selected transaction.

- readInt(Scanner sc)
  Reads a complete line and converts it into an int.
  It rejects invalid whole-number input.

- readDouble(Scanner sc)
  Reads a complete line and converts it into a double.
  It rejects invalid, infinite, or non-numeric input.



6. BANKHELPER CLASS


Purpose:
The BankHelper class is a utility class. It contains static methods for validation, account-number generation, reference-number generation, and transaction-history creation.

Public Validation Methods:

- isValidAmount(double amount)
  Returns true when the amount is finite and greater than zero.

- isEnoughBalance(double balance, double amount)
  Returns true when the amount is valid and the balance is enough.

- isValidPin(String pin)
  Checks that the PIN is not empty, contains digits only, and has exactly four digits.

- isValidAccountNumber(String accountNumber)
  Checks that the account number is not empty, contains digits only, and has exactly six digits.

- isValidAccountName(String accountName)
  Checks that the name has at least two characters and contains only letters and spaces.

- isValidPassword(String password)
  Checks that the password is not empty and contains at least four characters.

- isValidInitialBalance(double amount)
  Returns true when the starting balance is finite and at least 100.

- isValidReferenceNum(String referenceNum)
  Checks that the reference number is not empty, contains digits only, and has exactly seven digits.

Public Generation Methods:

- generateAccountNumber(Bank bank)
  Generates a unique six-digit account number.

- generateReferenceNum(Account account)
  Generates a unique seven-digit transaction reference number.

- generateTransactionHistory(Account account,
                             double amount,
                             String type)
  Creates a formatted transaction description and adds it to the account history.

Private Helper Methods:

- isNotAllDigit(char[] stringArray)
  Returns true when at least one character is not a digit.

- has4Digits(String pin)
  Returns true when the string contains exactly four characters.

- has6Digits(String accountNumber)
  Returns true when the string contains exactly six characters.

- has7Digits(String referenceNum)
  Returns true when the string contains exactly seven characters.

- isEmpty(String input)
  Returns true when the input is null, empty, or contains spaces only.

- isNotDuplicatedNumber(Bank bank, String number)
  Checks that an account number is not already used by another account.

- isNotDuplicatedNumber(Account account, String referenceNum)
  Checks that a reference number is not already used in the account's transaction history.


7. MAIN JAVA APIs USED


- ArrayList
  A resizable collection used to store Account and Transaction objects.

- ArrayList.add()
  Adds an object to an ArrayList.

- ArrayList.isEmpty()
  Checks whether an ArrayList contains no elements.

- ArrayList.size()
  Returns the number of stored elements.

- Scanner
  Reads keyboard input.

- Scanner.nextLine()
  Reads one complete line of input as a String.

- Scanner.close()
  Closes the Scanner after the program ends.

- Integer.parseInt()
  Converts a String into an int.

- Integer.toString()
  Converts an int into a String.

- Double.parseDouble()
  Converts a String into a double.

- Double.isFinite()
  Checks whether a double is a valid finite number.

- Math.random()
  Produces a random double from 0.0 up to, but not including, 1.0.

- Character.isDigit()
  Checks whether a character is a digit.

- Character.isLetter()
  Checks whether a character is a letter.

- Character.isWhitespace()
  Checks whether a character is a space or another whitespace character.

- String.trim()
  Removes spaces from the beginning and end of a String.

- String.isEmpty()
  Checks whether a String contains zero characters.

- String.length()
  Returns the number of characters in a String.

- String.toCharArray()
  Converts a String into an array of characters.

- String.equals()
  Compares the content of two Strings.

- String.equalsIgnoreCase()
  Compares two Strings without considering letter case.

- String.formatted()
  Inserts values into a formatted String.

- System.out.println()
  Prints text and moves to the next line.

- System.out.printf()
  Prints formatted text.

- IllegalArgumentException
  Represents invalid input or an invalid operation.

- NumberFormatException
  Occurs when text cannot be converted into a number.



8. MAIN PROGRAM FLOW


1. BankController creates a Bank object.
2. The user chooses login, account creation, or exit.
3. A created account is added to Bank.accountList.
4. A logged-in Account reference is stored in BankController.a.
5. BankController receives a menu choice.
6. It calls the correct Bank or Account method.
7. Account changes its own balance.
8. BankHelper validates data and creates transaction records.
9. Transaction objects are stored inside Account.transactionHistory.
10. Logout sets BankController.a to null.
11. The program returns to the authentication menu.
