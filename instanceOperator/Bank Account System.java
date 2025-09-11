class BankAccount {
    static String bankName = "SBI";  
    static int totalAccounts = 0;    

    final int accountNumber;  
    String accountHolderName;

    // Constructor using 'this'
    BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName + ", Holder: " + accountHolderName + ", Account#: " + accountNumber);
        }
    }
}
