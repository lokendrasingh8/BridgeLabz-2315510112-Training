package Banking;

public abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    protected void setBalance(double balance) { this.balance = balance; }

    public void deposit(double amount) {
        if (amount > 0) setBalance(getBalance() + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }

    public abstract double calculateInterest();
}
