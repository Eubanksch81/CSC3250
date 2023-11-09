/*
Charles Eubanks
Assignment #3
Create an inheritance structure that can be accessed and changed using a polymorphic container.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();
        Scanner scnr = new Scanner(System.in);
        int menuInput = 0;

        System.out.println("Welcome to your account system!");
        System.out.println("Press 1 to select options for your Checking account");
        System.out.println("Press 2 to select options for your Interest account");
        System.out.println("Press 3 to select options for your Fixed Deposit account");
        System.out.println("Press 4 to print the information of all your accounts");
        System.out.println("Press 5 to exit\n");
        menuInput = scnr.nextInt();

        while (menuInput != 5) {
            if (menuInput == 1) {
                checkingOptions(accountList, scnr);
            }
            else if (menuInput == 2) {
                interestOptions(accountList, scnr);
            }
            else if (menuInput == 3) {
                fixedDepositOptions(accountList, scnr);
            }
            else if (menuInput == 4) {
                printAccounts(accountList);
            }
            else {
                System.out.println("Invalid input. Please try again.\n");
            }

            System.out.println("\nPress 1 to select options for your Checking account");
            System.out.println("Press 2 to select options for your Interest account");
            System.out.println("Press 3 to select options for your Fixed Deposit account");
            System.out.println("Press 4 to print the information of all your accounts");
            System.out.println("Press 5 to exit\n");
            menuInput = scnr.nextInt();
        }
    }

    private static void printAccounts(ArrayList<BankAccount> accountList) {
        for (int i = 0; i < accountList.size(); ++i) {
            if (accountList.get(i) instanceof CheckingAccount) {
                System.out.println("Checking Account");
            }
            else if (accountList.get(i) instanceof FixedDepositAccount) {
                System.out.println("Fixed Deposit Account");
            }
            else if (accountList.get(i) instanceof InterestAccount) {
                System.out.println("Interest Account");
            }
            System.out.println(accountList.get(i).toString());
        }
    }

    private static void fixedDepositOptions(ArrayList<BankAccount> accountList, Scanner scnr) {
        int fixedDepositMenu;
        System.out.println("Press 1 to add a new Fixed Deposit account");
        System.out.println("Press 2 to deposit into your Fixed Deposit account");
        System.out.println("Press 3 to withdraw from your Fixed Deposit account");
        System.out.println("Press 4 to change whether or not requirements are met for your Fixed Deposit account");
        System.out.println("Press 5 to print information about your Fixed Deposit account");
        System.out.println("Press 6 to exit");
        fixedDepositMenu = scnr.nextInt();

        while (fixedDepositMenu != 6) {
            int index;

            if (fixedDepositMenu == 1) {
                accountList.add(addFixedDepositAccount(scnr));
                System.out.println("A new Fixed Deposit account has been added.\n");
            }
            else if (fixedDepositMenu == 2) {
                System.out.println("Please enter the account number of the Fixed Deposit account you'd like to deposit to: ");
                index = findAccount(accountList, scnr);

                accountList.set(index, deposit(accountList.get(index), scnr));
            }
            else if (fixedDepositMenu == 3) {
                System.out.println("Please enter the account number of the Fixed Deposit account you'd like to withdraw from: ");
                index = findAccount(accountList, scnr);

                accountList.set(index, withdraw(accountList.get(index), scnr));
            }
            else if (fixedDepositMenu == 4) {
                System.out.println("Please enter the account number of the Fixed Deposit account" +
                        " you'd like to change requirements of: ");
                index = findAccount(accountList, scnr);

                System.out.println("Press 1 to validate requirements");
                System.out.println("Press 2 to invalidate requirements");
                System.out.println("Press 3 to exit");
                fixedDepositMenu = scnr.nextInt();

                while (fixedDepositMenu != 3) {
                    if (fixedDepositMenu == 1) {
                        ((FixedDepositAccount)accountList.get(index)).setRequirementsMet(true);
                        System.out.println("Validated requirements");
                    }
                    else if (fixedDepositMenu == 2) {
                        ((FixedDepositAccount)accountList.get(index)).setRequirementsMet(false);
                        System.out.println("Invalidated requirements");
                    }
                    else {
                        System.out.println("Invalid input. Please try again.");
                    }

                    System.out.println("\nPress 1 to validate requirements");
                    System.out.println("Press 2 to invalidate requirements");
                    System.out.println("Press 3 to exit");
                    fixedDepositMenu = scnr.nextInt();
                }

            }
            else if (fixedDepositMenu == 5) {
                System.out.println("Please enter the account number of the Fixed Deposit account you'd like print: ");
                index = findAccount(accountList, scnr);

                System.out.println(accountList.get(index).toString());
            }
            else {
                System.out.println("Invalid input. Please try again.\n");
            }

            System.out.println("Press 1 to add a new Fixed Deposit account");
            System.out.println("Press 2 to deposit into your Fixed Deposit account");
            System.out.println("Press 3 to withdraw from your Fixed Deposit account");
            System.out.println("Press 4 to change whether or not requirements are met for your Fixed Deposit account");
            System.out.println("Press 5 to print information about your Fixed Deposit account");
            System.out.println("Press 6 to exit");
            fixedDepositMenu = scnr.nextInt();
        }
    }

    private static void interestOptions(ArrayList<BankAccount> accountList, Scanner scnr) {
        int interestMenu;
        System.out.println("Press 1 to add a new Interest account");
        System.out.println("Press 2 to deposit into your Interest account");
        System.out.println("Press 3 to withdraw from your Interest account");
        System.out.println("Press 4 to print information about your Interest account");
        System.out.println("Press 5 to exit");
        interestMenu = scnr.nextInt();

        while (interestMenu != 5) {
            int index;

            if (interestMenu == 1) {
                accountList.add(addInterestAccount(scnr));
                System.out.println("A new Interest account has been added.\n");
            }
            else if (interestMenu == 2) {
                System.out.println("Please enter the account number of the Interest account you'd like to deposit to: ");
                index = findAccount(accountList, scnr);

                accountList.set(index, deposit(accountList.get(index), scnr));
            }
            else if (interestMenu == 3) {
                System.out.println("Please enter the account number of the Interest account you'd like to withdraw from: ");
                index = findAccount(accountList, scnr);

                accountList.set(index, withdraw(accountList.get(index), scnr));
            }
            else if (interestMenu == 4) {
                System.out.println("Please enter the account number of the Interest account you'd like print: ");
                index = findAccount(accountList, scnr);

                System.out.println(accountList.get(index).toString());
            }
            else {
                System.out.println("Invalid input. Please try again.\n");
            }

            System.out.println("Press 1 to add a new Interest account");
            System.out.println("Press 2 to deposit into your Interest account");
            System.out.println("Press 3 to withdraw from your Interest account");
            System.out.println("Press 4 to print information about your Interest account");
            System.out.println("Press 5 to exit");
            interestMenu = scnr.nextInt();
        }
    }

    private static void checkingOptions(ArrayList<BankAccount> accountList, Scanner scnr) {
        int checkingMenu;
        System.out.println("Press 1 to add a new Checking account");
        System.out.println("Press 2 to deposit into your Checking account");
        System.out.println("Press 3 to withdraw from your Checking account");
        System.out.println("Press 4 to print information about your Checking account");
        System.out.println("Press 5 to exit");
        checkingMenu = scnr.nextInt();

        while (checkingMenu != 5) {
            int index;

            if (checkingMenu == 1) {
                accountList.add(addCheckingAccount(scnr));
                System.out.println("A new Checking account has been added.\n");
            }
            else if (checkingMenu == 2) {
                System.out.println("Please enter the Account Number of the Checking account you'd like to deposit to:");
                index = findAccount(accountList, scnr);

                accountList.set(index, depositChecking(accountList.get(index), scnr));

            }
            else if (checkingMenu == 3) {
                System.out.println("Please enter the account number of the Checking account you'd like to withdraw from: ");
                index = findAccount(accountList, scnr);

                accountList.set(index, withdraw(accountList.get(index), scnr));
            }
            else if (checkingMenu == 4) {
                System.out.println("Please enter the account number of the Checking account you'd like print: ");
                index = findAccount(accountList, scnr);

                System.out.println(accountList.get(index).toString());
            }
            else {
                System.out.println("Invalid input. Please try again.\n");
            }

            System.out.println("Press 1 to add a new Checking account");
            System.out.println("Press 2 to deposit into your Checking account");
            System.out.println("Press 3 to withdraw from your Checking account");
            System.out.println("Press 4 to print information about your Checking account");
            System.out.println("Press 5 to exit");
            checkingMenu = scnr.nextInt();
        }
    }

    private static int findAccount(ArrayList<BankAccount> accountList, Scanner scnr) {
        int accountNumber;
        int index = 0;
        boolean isFound = false;

        accountNumber = scnr.nextInt();

        while (index < accountList.size() && !isFound) {
            if (accountList.get(index).getAccountNum() == accountNumber) {
                isFound = true;
            }
            ++index;
        }

        if (isFound) {
            return (index - 1);
        }
        else {
            return -1;
        }
    }

    private static BankAccount withdraw(BankAccount account, Scanner scnr) {
        double depositAmount;

        System.out.println("Please enter withdrawn amount: ");
        depositAmount = scnr.nextDouble();

        account.withdraw(depositAmount);
        System.out.println("Your amount has been withdrawn.");

        return account;
    }
    private static BankAccount deposit(BankAccount account, Scanner scnr) {
        double depositAmount;

        System.out.println("Please enter deposit amount: ");
        depositAmount = scnr.nextDouble();

        account.deposit(depositAmount);
        System.out.println("Your amount has been deposited.");

        return account;
    }

    private static BankAccount depositChecking(BankAccount account, Scanner scnr) {
        int checkNumber;
        double prevBalance;
        double depositAmount;

        System.out.println("Please enter deposit amount: ");
        depositAmount = scnr.nextDouble();
        System.out.println("Please enter the Check Number for this deposit: ");
        checkNumber = scnr.nextInt();

        prevBalance = account.balance();

        ((CheckingAccount)account).deposit(depositAmount, checkNumber);

        if (prevBalance == account.balance()) {
            System.out.println("Deposit failed: Check number is less than the previous check number.");
        }
        else {
            System.out.println("Your amount has been deposited.");
        }

        return account;
    }

    private static CheckingAccount addCheckingAccount(Scanner scnr) {
        int accountNum;
        double balance;

        System.out.println("Please enter the account number: ");
        accountNum = scnr.nextInt();
        System.out.println("Please enter the account balance: ");
        balance = scnr.nextDouble();

        return new CheckingAccount(balance, accountNum);
    }
    private static InterestAccount addInterestAccount(Scanner scnr) {
        int accountNum;
        double balance;
        double interestRate;

        System.out.println("Please enter the account number: ");
        accountNum = scnr.nextInt();
        System.out.println("Please enter the account balance: ");
        balance = scnr.nextDouble();
        System.out.println("Please enter the interest rate:");
        interestRate = scnr.nextDouble();

        return new InterestAccount(balance, accountNum, interestRate);
    }
    private static FixedDepositAccount addFixedDepositAccount(Scanner scnr) {
        int accountNum;
        double balance;
        double interestRate;
        int requirementsMet;

        System.out.println("Please enter the account number: ");
        accountNum = scnr.nextInt();
        System.out.println("Please enter the account balance: ");
        balance = scnr.nextDouble();
        System.out.println("Please enter the interest rate:");
        interestRate = scnr.nextDouble();
        System.out.println("Are the requirements met for this account?");
        System.out.println("Press 1 for Yes");
        System.out.println("Press 2 for No");
        requirementsMet = scnr.nextInt();

        if (requirementsMet == 1) {
        return new FixedDepositAccount(balance, accountNum, interestRate, true);
    }
        else {
        return new FixedDepositAccount(balance, accountNum, interestRate, false);
    }
}
}

class BankAccount {
    protected double balance;
    protected int accountNum;

    public BankAccount() {
        balance = -1.0;
        accountNum = -1;
    }
    public BankAccount(double p_balance, int p_accountNum) {
        balance = p_balance;
        accountNum = p_accountNum;
    }

    public void setAccountNum(int p_accountNum) {
        accountNum = p_accountNum;
    }
    public int getAccountNum() {
        return accountNum;
    }

    public void deposit(double p_amount) {
        balance += p_amount;
    }
    public void withdraw(double p_amount) {
        balance -= p_amount;
    }
    public double balance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNum + "\nBalance: " + balance + "\n";
    }

    @Override
    public boolean equals(Object comparedAccount) {
        if (((BankAccount)comparedAccount).getAccountNum() == accountNum && ((BankAccount)comparedAccount).balance() == balance) {
            return true;
        }
        else {
            return false;
        }
    }
}

class CheckingAccount extends BankAccount {
    protected int lastCheckNum;

    public CheckingAccount() {
        super();
        lastCheckNum = 0;
    }
    public CheckingAccount(double p_balance, int p_accountNum) {
        super(p_balance, p_accountNum);
        lastCheckNum = 0;
    }

    public void deposit(double p_amount, int p_checkNum) { //Needs some sort of proof in case the deposit fails.
        if (p_checkNum > lastCheckNum) {
            balance += p_amount;
            lastCheckNum = p_checkNum;
        }
    }

    public void setLastCheckNum(int p_lastCheckNum) {
        lastCheckNum = p_lastCheckNum;
    }
    public int getLastCheckNum() {
        return lastCheckNum;
    }

    @Override
    public String toString() {
        return super.toString() + "Last Check Number: " + lastCheckNum + "\n";
    }

    @Override
    public boolean equals(Object comparedAccount) {
        if (super.equals(comparedAccount) && ((CheckingAccount)comparedAccount).getLastCheckNum() == lastCheckNum) {
            return true;
        }
        else {
            return false;
        }
    }
}

class InterestAccount extends BankAccount {
    protected double interestRate;

    public InterestAccount() {
        super();
        interestRate = 0;
    }
    public InterestAccount(double p_balance, int p_accountNum) {
        super(p_balance, p_accountNum);
        interestRate = 0;
    }
    public InterestAccount(double p_balance, int p_accountNum, double p_interestRate) {
        super(p_balance, p_accountNum);
        interestRate = p_interestRate;
    }

    public void setInterestRate(double p_interestRate) {
        interestRate = p_interestRate;
    }
    public double getInterestRate() {
        return interestRate;
    }

    public void addInterest() {
        balance += (balance * interestRate);
    }

    @Override
    public String toString() {
        return super.toString() + "Interest Rate: " + interestRate + "\n";
    }

    @Override
    public boolean equals(Object comparedAccount) {
        if (super.equals(comparedAccount) && ((InterestAccount)comparedAccount).getInterestRate() == interestRate) {
            return true;
        }
        else {
            return false;
        }
    }
}

class FixedDepositAccount extends InterestAccount {
    protected boolean requirementsMet;

    public FixedDepositAccount() {
        super();
        requirementsMet = false;
    }
    public FixedDepositAccount(double p_balance, int p_accountNum, double p_interestRate) {
        super(p_balance, p_accountNum, p_interestRate);
        requirementsMet = false;
    }
    public FixedDepositAccount(double p_balance, int p_accountNum, double p_interestRate, boolean p_requirementsMet) {
        super(p_balance, p_accountNum, p_interestRate);
        requirementsMet = p_requirementsMet;
    }

    public void setRequirementsMet(boolean p_requirementsMet) {
        requirementsMet = p_requirementsMet;
    }
    public boolean getRequirementsMet() {
        return requirementsMet;
    }

    @Override
    public void addInterest() {
        if (requirementsMet) {
            super.addInterest();
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Requirements Met: " + requirementsMet + "\n";
    }

    @Override
    public boolean equals(Object comparedAccount) {
        if (super.equals(comparedAccount) && ((FixedDepositAccount)comparedAccount).getRequirementsMet() == requirementsMet) {
            return true;
        }
        else {
            return false;
        }
    }
}