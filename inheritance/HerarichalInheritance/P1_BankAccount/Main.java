
// Hierarchical Inheritance - Problem 1: Bank Account Types
class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Savings Account with interest rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Checking Account with withdrawal limit: " + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int duration;

    FixedDepositAccount(String accountNumber, double balance, int duration) {
        super(accountNumber, balance);
        this.duration = duration;
    }

    void displayAccountType() {
        System.out.println("Fixed Deposit Account with duration: " + duration + " months");
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA001", 10000, 5.5);
        sa.displayAccountType();
    }
}
