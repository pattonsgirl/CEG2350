
/**
 * Driver for Banking application
 * @author Kayleigh Duncan
 * @version 1.0
 */

import java.util.*;
import java.io.*;

public class App {
    /*
     * Prints option menu to screen
     */
    public static void printMenu() {
        System.out.println("Read carefully because our menu options have changed");
        System.out.println("1 - add account");
        System.out.println("2 - account details for user");
        System.out.println("3 - account details for account number");
        System.out.println("4 - deposit to account");
        System.out.println("5 - withdraw from account");
        System.out.println("6 - transfer between accounts");
        System.out.println("7 - save bank accounts to file");
        System.out.println("8 - read bank accounts from file");
        System.out.println("9 - show all accounts");
        System.out.println("10 - exit program");
    }

    /**
     * Returns a new Account object
     * <p>
     * Prompts program user for info: name, account type, initial funds
     * <p>
     * Account constructor generates an accountNumber
     * 
     * @return Account
     * @see Account
     */
    public static Account accountCreate() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Provide info for the new account: ");
        System.out.print("Account owner: ");
        String owner = scnr.nextLine();
        System.out.print("Account type: ");
        String type = scnr.nextLine();
        System.out.print("Initial funds: ");
        Double money = scnr.nextDouble();
        System.out.flush();
        return new Account(owner, type, money);
    }

    /**
     * Modifies an Account object
     * Prompts program user for info: name, account type, initial funds
     * <p>
     * Usage:
     * <p>
     * Account newAccount = new Account(); //generates an account number only
     * <p>
     * accountCreate(newAccount);
     * 
     * @param a
     */
    public static void accountCreate(Account a) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Provide info for the new account: ");
        System.out.print("Account owner: ");
        String owner = scnr.nextLine();
        System.out.print("Account type: ");
        String type = scnr.nextLine();
        System.out.print("Initial funds: ");
        Double money = scnr.nextDouble();
        System.out.flush();
        a.setAccountOwner(owner);
        a.setAccountType(type);
        a.setAccountFunds(money);
    }

    public static void saveBank(ArrayList<Account> accounts, Scanner scnr) {
        String filename;
        FileOutputStream fileOutStream;
        PrintWriter outFS;
        Collections.sort(accounts);

        while (true) {
            try {
                System.out.print("Provide a file name: ");
                filename = scnr.next();
                System.out.flush();
                fileOutStream = new FileOutputStream(filename);

                break;
            } catch (FileNotFoundException e) {
                System.out.println("File does not exist.");
                scnr.next();
                System.out.flush();
                continue;
            }
        }
        try {
            outFS = new PrintWriter(fileOutStream);
            for (Account a : accounts) {
                outFS.println(a);
            }
            outFS.close();
            fileOutStream.close();
        } catch (IOException e) {
            System.out.println("Error occured while writing to file.");
        }
        System.out.println("Accounts written to " + filename);
    }

    public static void readBank(ArrayList<Account> accounts, Scanner scnr) {
        String filename;
        FileInputStream fileByteStream;
        Scanner inFS;
        while (true) {
            try {
                System.out.print("Enter a filename: ");
                filename = scnr.next();
                System.out.flush();
                fileByteStream = new FileInputStream(filename);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                scnr.next();
                System.out.flush();
                continue;
            }
        }
        // if file is found, read it into accounts ArrayList
        inFS = new Scanner(fileByteStream);
        while (inFS.hasNextLine()) {
            String[] line = inFS.nextLine().split(", ");
            // System.out.print(line[0]);
            Account a = new Account(Integer.parseInt(line[0]), line[1], line[2], Double.parseDouble(line[3]));
            accounts.add(a);
        }
        inFS.close();
        // fileByteStream.close();
    }

    /**
     * Driver for Banking application
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        int userchoice = 0;
        boolean keepprompting = true;
        Integer accNum; // placeholder for inputs
        boolean accountFound = false;
        ArrayList<Account> accounts = new ArrayList<>();
        printMenu();
        do {
            while (keepprompting) {
                // prompt user for input
                try {
                    userchoice = scnr.nextInt();
                    System.out.flush();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid data type given.  Expected integer.  Gobbling bad input");
                    scnr.next();
                    System.out.flush();
                    continue;
                }
            }
            switch (userchoice) {
                case 1:
                    // accountCreate creates a NEW Account object
                    // returns a reference to the Account object to
                    // store in ArrayList accounts
                    accounts.add(accountCreate());
                    break;
                case 2:
                    // Account details by username
                    // System.out.println();
                    System.out.flush();
                    scnr.nextLine();
                    System.out.print("Provide username: ");
                    String owner = scnr.nextLine();
                    for (Account a : accounts) {
                        if (a.getAccountOwner().equals(owner)) {
                            System.out.println(a);
                        }
                    }
                    break;
                case 3:
                    // Account details by account number
                    System.out.print("Provide account number: ");
                    accNum = scnr.nextInt();
                    System.out.flush();
                    for (Account a : accounts) {
                        if (a.getAccountNumber().equals(accNum)) {
                            System.out.println(a);
                        }
                    }
                    break;
                case 4:
                    // Deposit to account number
                    // System.out.flush();
                    System.out.print("Provide account number: ");
                    accNum = scnr.nextInt();
                    System.out.flush();
                    accountFound = false;
                    for (Account a : accounts) {
                        if (a.getAccountNumber().equals(accNum)) {
                            accountFound = true;
                            System.out.println("Account found.");
                            System.out.println(a);
                            System.out.println("Enter deposit amount: ");
                            Double deposit = scnr.nextDouble();
                            System.out.flush();
                            a.setAccountFunds(a.getAccountFunds() + deposit);
                            System.out.println(a);
                        }
                    }
                    if (!accountFound) {
                        System.out.println("Account " + accNum + " not found");
                    }
                    break;
                case 5:
                    // Withdraw from account number
                    // System.out.flush();
                    System.out.print("Provide account number: ");
                    accNum = scnr.nextInt();
                    System.out.flush();
                    accountFound = false;
                    for (Account a : accounts) {
                        if (a.getAccountNumber().equals(accNum)) {
                            accountFound = true;
                            System.out.println("Account found.");
                            System.out.println(a);
                            System.out.print("Enter withdrawl amount: ");
                            Double withdraw = scnr.nextDouble();
                            System.out.flush();
                            if ((a.getAccountFunds() - withdraw) >= 0) {
                                a.setAccountFunds(a.getAccountFunds() - withdraw);
                            } else {
                                System.out.println("Insufficent funds for withdrawl");
                            }
                            System.out.println(a);
                        }
                    }
                    if (!accountFound) {
                        System.out.println("Account " + accNum + " not found");
                    }
                    break;
                case 6:
                    // Transfer between accounts
                    // Transfer FROM first - if insufficient funds, transfer should not continue
                    System.out.print("Provide account number to transfer funds FROM: ");
                    accNum = scnr.nextInt();
                    System.out.flush();
                    accountFound = false;
                    Double transfer = 0.00;
                    boolean insuffFunds = true;
                    for (Account a : accounts) {
                        if (a.getAccountNumber().equals(accNum)) {
                            accountFound = true;
                            System.out.println("Account found.");
                            System.out.println(a);
                            System.out.print("Enter amount to transfer: ");
                            transfer = scnr.nextDouble();
                            System.out.flush();
                            if ((a.getAccountFunds() - transfer) >= 0) {
                                insuffFunds = false;
                                a.setAccountFunds(a.getAccountFunds() - transfer);
                            } else {
                                System.out.println("Insufficent funds for transfer");
                                insuffFunds = true;
                            }
                            System.out.println(a);
                        }
                    }
                    if (insuffFunds) {
                        System.out.println("Canceling transfer");
                        break;
                    }
                    if (!accountFound) {
                        System.out.println("Account " + accNum + " not found");
                        break;
                    }
                    System.out.print("Provide account number to transfer funds TO: ");
                    accNum = scnr.nextInt();
                    System.out.flush();
                    accountFound = false;
                    for (Account a : accounts) {
                        if (a.getAccountNumber().equals(accNum)) {
                            accountFound = true;
                            System.out.println("Account found.");
                            a.setAccountFunds(a.getAccountFunds() + transfer);
                            System.out.println(a);
                        }
                    }
                    if (!accountFound) {
                        System.out.println("Account " + accNum + " not found");
                        break;
                    }
                    break;
                case 7:
                    // Save accounts to file
                    System.out.flush();
                    saveBank(accounts, scnr);
                    break;
                case 8:
                    // Read accounts from file
                    System.out.flush();
                    accounts.clear();
                    readBank(accounts, scnr);
                    break;
                case 9:
                    // SORT accounts, then print accounts
                    Collections.sort(accounts);
                    // takes ArrayList of Account objects, converts to a String
                    // System.out.println(accounts.toString());
                    for (Account a : accounts) {
                        System.out.println(a);
                    }
                    break;
                case 10:
                    // TODO: prompt to save before exit?
                    System.exit(0);
                    break;
                case 11:
                    printMenu();
                    break;
                default:
                    System.out.println(userchoice + " is not an option");
                    printMenu();
                    break;
            }

        } while (userchoice != 10);

        scnr.close();
    }
}
