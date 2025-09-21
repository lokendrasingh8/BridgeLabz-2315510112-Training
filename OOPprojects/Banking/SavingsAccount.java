package Banking;

public class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String acc, String name, double bal) { super(acc, name, bal); }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% annual example
    }

    @Override
    public boolean applyForLoan(double amount) {
        return calculateLoanEligibility() >= amount;
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 0.5; // 50% of balance
    }
}
