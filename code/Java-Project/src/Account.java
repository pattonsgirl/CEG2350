
/**
 * Class to create objects of Accounts.
 * <p>
 * Account objects include a unique account number, an account owner, 
 * account type, and funds 
 * 
 * @author Kayleigh Duncan
 * @version 1.0
 */

import java.util.Random;
import java.lang.Comparable;

public class Account implements Comparable<Account> {
    // public class Account implements Comparable<Account>{

    private Integer accountNumber;
    private String accountOwner;
    private String accountType;
    private Double money;

    /**
     * Class constructor if no account details are given when creating
     * the account.
     * <p>
     * Minimum of accountNumber is generated from dummy String
     * <p>
     * Object's properties can then be modified using setter methods
     */
    public Account() {
        // there is no point in having an account with no info
        // could write set of prompts here to set object's values
        this.accountNumber = generateAccountNumber("abcdefghijklmnopqrstuvwxyz");
    }

    /**
     * Class constructor when owner, account type, and initial funds are known
     * on object creation
     * <p>
     * generates an account number based on owner name
     */
    public Account(String owner, String type, Double money) {
        this.accountOwner = owner;
        this.accountType = type;
        this.money = money;
        // create unique account number
        this.accountNumber = generateAccountNumber(owner);
    }

    /**
     * Class constructor loading account from file (account number exists)
     * 
     */
    public Account(Integer accNum, String owner, String type, Double money) {
        this.accountNumber = accNum;
        this.accountOwner = owner;
        this.accountType = type;
        this.money = money;
    }

    /**
     * Returns unique account number hashed from string + random int
     * <p>
     * Private because accountNumbers should not be something modified
     * on a whim - this method is only accessible by methods in this class
     * 
     * @param s string to generate hashCode
     * @return Integer accountNumber
     */
    private Integer generateAccountNumber(String s) {
        Random randGen = new Random();
        Integer accountNum = s.hashCode() + randGen.nextInt(2000);
        System.out.println("Generated account number " + accountNum);
        // got annoyed by negative numbers for accounts
        return Math.abs(accountNum);
    }

    /**
     * Returns account number
     * 
     * @return Integer
     */
    public Integer getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Sets new account owner for account object
     * 
     * @param newowner String new account owner
     */
    public void setAccountOwner(String newowner) {
        this.accountOwner = newowner;
    }

    /**
     * Returns account owner
     * 
     * @return String
     */
    public String getAccountOwner() {
        return this.accountOwner;
    }

    /**
     * Returns funds in account
     * 
     * @return Double money in account
     */
    public Double getAccountFunds() {
        return this.money;
    }

    /**
     * Sets initial account funds
     * 
     * @param money inital funds for account
     */
    public void setAccountFunds(Double money) {
        this.money = money;
    }

    /**
     * sets account type (Checking, Savings, Credit)
     * 
     * @param type account type
     */
    public void setAccountType(String type) {
        this.accountType = type;
    }

    /**
     * Returns formatted String for objects of type Account
     * <p>
     * Formatting in csv - comma separated value - syntax
     * <p>
     * Note: Override is optional here
     * 
     * @return String formatted data
     */
    @Override
    public String toString() {
        return this.accountNumber + ", " + this.accountOwner + ", " + this.accountType + ", " + this.money;
    }

    /**
     * Returns ASCENDING order sort based first on
     * <p>
     * accountOwner, then by money in Account object
     * <p>
     * Step 1: What is the setup for the class definition?
     * <p>
     * Step 2: what ranks one Account "before" another
     * <p>
     * Step 3: return postive if A is before B
     * <p>
     * return 0 if neither is "before" the other
     * <p>
     * return negative if B is before A
     * <p>
     * Note: first needed to have this class implement
     * Comparable Account object
     * 
     * @param a Account object to compare with
     * @return int determining object order
     */
    @Override
    public int compareTo(Account a) {
        // ascending order
        // - return positive if this.properties comes BEFORE a.properties
        // sort rule one - check accountOwner strings
        // if compare is POSTIVE number, this.accountOwner is alphabetically
        // BEFORE a.accountOwner
        if (this.accountOwner.compareTo(a.accountOwner) > 0) {
            return 1;
        }

        // check if this.accountOwner is alphabetically AFTER a.accountOwner
        else if (this.accountOwner.compareTo(a.accountOwner) < 0) {
            return -1;
        } else {
            // sort rule 2 - if accountOwner is same, sort by money in account
            // alternative sort rule 2 - sort by accountType
            // owner name is the same, sort by money
            // if (this.money > a.money) { // would give same result
            if (this.money.compareTo(a.money) > 0) {
                return 1;
            } else if (this.money.compareTo(a.money) < 0) {
                return -1;
            } else {
                // both accounts have same owner & same amount of funds
                // sort rule 3 - sort by accountNumber?
                return 0;
            }
        }

        // this return statement never hits because nested if / else if / else
        // above takes care of all cases
        // return 0;
    }

}
