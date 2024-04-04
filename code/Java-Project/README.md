# Weeks 13 & 14: Practice with Classes and Objects

- Design and code a banking application

## Features of Banking Application:

User story: this application is used by tellers to update accounts. The teller can see and access all accounts of the bank.

Core practice goals by implementing features:

- creating and manipulating an ArrayList of objects
- File input and output by writing account data out to a file and reading account data from a file.
- try / catch and exceptions using files and capturing bad user input
- using doubles in comparisons to make sure accounts have sufficient funds

```
1 - add account
2 - account details for user
3 - account details for account number
4 - deposit to account
5 - withdraw from account
6 - transfer between accounts
7 - save bank accounts to file
8 - read bank accounts from file
9 - show all accounts
10 - exit program
```

## Java Class Diagram for Account

- The getters and setters needed depend on the implementation of the project.
- `toString` returns a String that is mostly used to print objects of type Account
- `compareTo` returns an int that defines if one object comes before (or after) another. Is used by `sort` to sort objects of type Account

| Account                                                               |
| --------------------------------------------------------------------- |
| -accountNumber:Integer                                                |
| -accountOwner:String                                                  |
| -accountType:String                                                   |
| -money:Double                                                         |
| +Account()                                                            |
| +Account(accOwner: String, accType: String, accFunds: Double)         |
| +Account(aNum: Integer, aOwner: String, aType: String, aFunds:Double) |
| -generateAccountNumber(s: String): Integer                            |
| +getAccountNumber(): Integer                                          |
| +getAccountOwner(): String                                            |
| +setAccountOwner(newOwner: String): void                              |
| +getAccountFunds(): Double                                            |
| +setAccountFunds(money: Double): void                                 |
| +getAccountType(): String                                             |
| +setAccountType(type: String): void                                   |
| +toString(): String                                                   |
| +compareTo(a: Account): int                                           |

## Improvements to Challenge Yourself

- Break tasks into methods
- Move `static` methods into a separate class (maybe called Bank)
- Refactor (re-work) your code to have a HashMap - use users as keys and an ArrayList of Accounts as values. Accounts should store account number, type of account, and funds in account
- Create a difference in what is displayed for a user versus a teller in terms of visible accounts. A road to travel is at program start, prompt for user name - scan account owners, keep a separate list of tellers. If name is not a teller or account owner, output permission denied. Account owners should only see their accounts. Tellers should see all accounts.
