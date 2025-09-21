package Banking;

public interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}
