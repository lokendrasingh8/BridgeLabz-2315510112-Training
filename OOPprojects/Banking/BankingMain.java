package Banking;
import java.util.*;

public class BankingMain {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SA001", "Ravi", 200000));
        accounts.add(new CurrentAccount("CA001", "Maya", 50000));

        for (BankAccount a : accounts) {
            System.out.println(a.getHolderName() + " - Balance: " + a.getBalance() + ", Interest: " + a.calculateInterest());
            if (a instanceof Loanable) {
                Loanable l = (Loanable)a;
                System.out.println("Loan eligibility: " + l.calculateLoanEligibility());
            }
            System.out.println("---");
        }
    }
}
