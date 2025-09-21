package Banking;

public class CurrentAccount extends BankAccount {
    public CurrentAccount(String acc, String name, double bal) { super(acc, name, bal); }

    @Override
    public double calculateInterest() {
        return 0; // typically no interest
    }
}
