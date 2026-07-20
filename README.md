1. BANKING SYSTEM FEATURES

- Create an account
Allows a user to create a new bank account by providing a name, password, PIN, and initial balance.

- Log in using account number and password
Allows an existing user to log in by providing the account number and password.

- Check balance
Shows the current amount of money in the logged account.

- Deposit money
Adds a valid amount of money to the account balance.

- Withdraw money
Subtracts a valid amount of money from the account balance if there are enough funds.

- Transfer money
Transfers a valid amount of money from the logged account to another existing account.

- View transaction history
Shows the list of all deposits, withdrawals, and transfers with reference numbers.

- Log out
Closes the current account session and takes the user back to the authentication menu.

- Exit
Exits the banking application.

2. ACCOUNT CLASS

Purpose:
The Account class stores account data, balance, and transaction history. It also contains methods for changing the account balance.

Fields:

- private String accountNumber
Stores the account number as a six-digit string.

- private String accountName
Stores the account name.

- private String accountPassword

Stores the account password.

- private String pin
Stores the account PIN as a four-digit string.

- private double balance

Stores the current account balance as a double value.

- private ArrayList transactionHistory

Stores the list of all account transactions.

Constructor:

- Account(String accountNumber, String accountName,

String accountPassword, String pin, double balance)

Initializes a new instance of the Account class.
Sets initial values for account fields.
Sets an empty transaction history list.
Getter Methods:
- getAccountNumber()

Returns the account number.
- getAccountName()
Returns the account name.
- getAccountPassword()
Returns the account password.
- getPin()
Returns the account PIN.
- getBalance()
Returns the account balance.
- getTransactionHistory()
Returns the list of account transactions.
Setter Methods:
- setAccountNumber(String accountNumber)
Sets a new account number.
- setAccountName(String accountName)
Sets a new account name.
- setAccountPassword(String accountPassword)
Sets a new account password.
- setPin(String pin)
Sets a new account PIN.
- setBalance(double balance)
Sets a new account balance.
Rejects negative, infinite, and NaN values.
Account Methods:
- deposit(double amount)
Adds a valid amount of money to the account balance.
- withdraw(double amount)
Subtracts a valid amount of money from the account balance.
Rejects the operation if there are not enough funds.
- addTransactionHistory(String transactionHistory,
String referenceNumber)
Creates a new Transaction instance.
Adds the transaction to the account transaction history list.
3. TRANSACTION CLASS
Purpose:
The Transaction class stores the account transaction data such as transaction history and reference number.
Fields:
- private String transactionHistory
Stores the full transaction history string.
- private String referenceNum
Stores the transaction reference number as a seven-digit string.
Constructor:
- Transaction(String transactionHistory, String referenceNum)
Initializes a new instance of the Transaction class.
Getter Methods:
- getHistory()
Returns the transaction history.
- getReferenceNum()
Returns the transaction reference number.
Setter Methods:
- setTransactionHistory(String transactionHistory)
Sets a new transaction history.
- setReferenceNum(String referenceNum)
Sets a new transaction reference number.
4. BANK CLASS
Purpose:
The Bank class contains methods for managing all accounts. It also contains methods for finding accounts, logging in, and transferring money between accounts.
Field:
- private ArrayList accountList
Stores the list of all accounts.
Constructor:
- Bank()
Initializes a new instance of the Bank class.
Getter Method:
- getAccountList()
Returns the account list.
Setter Method:
- setAccountList(ArrayList accountList)
Sets a new account list.
Bank Methods:
- createAccount(Account account)
Adds a new account to the account list.
Rejects null accounts and accounts with duplicate account numbers.
- findAccountByNumber(String accountNumber)
Finds an account by number.
Returns the account instance.
- findAccountByName(String accountName)
Finds an account by name.
- login(String accountPassword, String accountNumber)
Finds an account by number.
Checks if the account password matches.
- transferMoney(String senderAccountNumber,
String receiverAccountNumber,
double amount)
Finds the sender and receiver accounts.
Subtracts the amount from the sender account.
Adds the amount to the receiver account.
5. BANKCONTROLLER CLASS
Purpose:
The BankController class contains the main program loop. It reads and processes the user input. It also contains methods for logging in and out and for displaying account operations menu.
Static Fields:
- static boolean running
Indicates if the application is running.
- static Account a
Stores the currently logged account instance.
The null value means that no account is logged in.
Main Method:
- main(String[] args)
The main program loop.
Initializes the scanner and bank instances.
Shows the authentication menu and account menu.
Controller Methods:
- printMenu()
Shows the account operations menu.
- processInput(Bank bank, Account a, Scanner sc, int c)
Processes the account menu input.
Calls appropriate methods based on the input.
- authenticate(Bank bank, Scanner sc)
Shows the authentication menu.
Logs in an existing user or creates a new account.
Private Controller Methods:
- viewTransactionHistory(Account account, Scanner sc)
Shows the transaction history reference numbers.
Finds and shows the transaction details.
- readInt(Scanner sc)
Reads an integer from the console.
Rejects invalid input.
- readDouble(Scanner sc)
Reads a double value from the console.
Rejects invalid input.
6. BANKHELPER CLASS
Purpose:
The BankHelper class contains helper methods for account validation, account number and reference number generation, and transaction history creation.
Public Validation Methods:
- isValidAmount(double amount)
Returns true if the amount is a finite positive value.
- isEnoughBalance(double balance, double amount)
Returns true if the amount is valid and the account has enough balance.
- isValidPin(String pin)
Checks if the PIN is not empty, has only digits, and has four digits.
- isValidAccountNumber(String accountNumber)
Checks if the account number is not empty, has only digits, and has six digits.
- isValidAccountName(String accountName)
Checks if the account name is not empty, has at least two characters, and has only letters and spaces.
- isValidPassword(String password)
Checks if the password is not empty and has at least four characters.
- isValidInitialBalance(double amount)
Returns true if the initial balance is a finite positive value greater than 100.
- isValidReferenceNum(String referenceNum)
Checks if the reference number is not empty, has only digits, and has seven digits.
Public Generation Methods:
- generateAccountNumber(Bank bank)
Generates a six-digit account number.
- generateReferenceNum(Account account)
Generates a seven-digit reference number.
- generateTransactionHistory(Account account,
double amount,
String type)
Generates a formatted transaction history string.
Adds the transaction to the account transaction history list.
Private Helper Methods:
- isNotAllDigit(char[] stringArray)
Returns true if the string array is not all digits.
- has4Digits(String pin)
Returns true if the string has four digits.
- has6Digits(String accountNumber)
Returns true if the string has six digits.
- has7Digits(String referenceNum)
Returns true if the string has seven digits.
- isEmpty(String input)
Returns true if the string is empty or has only whitespace characters.
- isNotDuplicatedNumber(Bank bank, String number)
Checks if the account number is not duplicated.
- isNotDuplicatedNumber(Account account, String referenceNum)
Checks if the reference number is not duplicated in the account transaction history.
7. MAIN JAVA APIs USED
- ArrayList
Used for storing Account and Transaction objects.
- ArrayList.add()
Adds an object to an ArrayList.
- ArrayList.isEmpty()
Checks whether an ArrayList is empty.
- ArrayList.size()
Returns the size of an ArrayList.
- Scanner
Reads the user input.
- Scanner.nextLine()
Reads the next line of input as a string.
- Scanner.close()
Closes the scanner.
- Integer.parseInt()
Converts a string to an integer.
- Integer.toString()
Converts an integer to a string.
- Double.parseDouble()
Converts a string to a double.
- Double.isFinite()
Checks whether a double is a finite number.
- Math.random()
Returns a random double between 0.0 and 1.0.
- Character.isDigit()
Checks whether a character is a digit.
- Character.isLetter()
Checks whether a character is a letter.
- Character.isWhitespace()
Checks whether a character is a whitespace.
- String.trim()
Removes whitespace from both ends of a string.
- String.isEmpty()
Checks whether a string is empty.
- String.length()
Returns the length of a string.
- String.toCharArray()
Converts a string to a character array.
- String.equals()
Compares the content of two strings.
- String.equalsIgnoreCase()
Compares the content of two strings ignoring the case.
- String.formatted()
Formats a string.
- System.out.println()
Prints a line of text.
- System.out.printf()
Prints formatted text.
- IllegalArgumentException
Thrown to indicate that a method has received invalid arguments.
- NumberFormatException
Thrown when an invalid string is parsed into a number.
8. MAIN PROGRAM FLOW
1. BankController creates a Bank instance.
2. The user selects an option to log in, create an account, or exit.
3. The created account is added to Bank.accountList.
4. The logged account instance is stored in BankController.a.
5. The BankController receives the account menu input.
6. The BankController calls the appropriate Bank or Account method.
7. The Account instance updates its balance.
8. The BankHelper validates the input and creates transaction records.
9. The Transaction instances are added to Account.transactionHistory.
10. Logging out sets the BankController.a to null.
11. The program returns to the authentication menu.
