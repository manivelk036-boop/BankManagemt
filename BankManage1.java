import java.util.HashMap;
import java.util.Scanner;

public class BankManage1 {

    // Account Number -> Balance
    static HashMap<Integer, Double> accounts = new HashMap<>();

    static void createAccount(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
        } else {
            accounts.put(accountNumber, 1000.0);
            System.out.println("Account Created Successfully!");
            System.out.println("Initial Balance: 1000.0");
        }
    }

    static void deposit(int accountNumber, double amount) {

        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account Not Found!");
            return;
        }

        if (amount > 0) {
            double balance = accounts.get(accountNumber);
            balance += amount;

            accounts.put(accountNumber, balance);

            System.out.println("Deposit Successful!");
            System.out.println("Current Balance: ₹" + balance);
        } else {
            System.out.println("Invalid Deposit Amount!");
        }
    }

    static void withdraw(int accountNumber, double amount) {

        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account Not Found!");
            return;
        }

        double balance = accounts.get(accountNumber);

        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount!");
        } 
        else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } 
        else {
            balance -= amount;

            accounts.put(accountNumber, balance);

            System.out.println("Withdrawal Successful!");
            System.out.println("Current Balance: ₹" + balance);
        }
    }

    static void checkBalance(int accountNumber) {

        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account Not Found!");
        } else {
            double balance = accounts.get(accountNumber);
            System.out.println("Current Balance: ₹" + balance);
        }
    }

    static void displayAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No Accounts Found!");
            return;
        }

        System.out.println("\n===== ALL ACCOUNTS =====");

        for (Integer accountNumber : accounts.keySet()) {
            System.out.println(
                "Account Number: " + accountNumber +
                " | Balance: ₹" + accounts.get(accountNumber)
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int newAccount = sc.nextInt();

                    createAccount(newAccount);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int depositAccount = sc.nextInt();

                    System.out.print("Enter Deposit Amount: ₹");
                    double depositAmount = sc.nextDouble();

                    deposit(depositAccount, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int withdrawAccount = sc.nextInt();

                    System.out.print("Enter Withdrawal Amount: ₹");
                    double withdrawAmount = sc.nextDouble();

                    withdraw(withdrawAccount, withdrawAmount);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int checkAccount = sc.nextInt();

                    checkBalance(checkAccount);
                    break;

                case 5:
                    displayAccounts();
                    break;

                case 6:
                    System.out.println(
                        "Thank You for Using Bank Management System!"
                    );

                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}