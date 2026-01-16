import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/* =========================
   ABSTRACT ACCOUNT CLASS
   ========================= */
abstract class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    protected int accountNumber;
    protected String holderName;
    protected double balance;

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
}

/* =========================
   SAVINGS ACCOUNT CLASS
   ========================= */
class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposit successful.");
        } else {
            System.out.println("❌ Invalid amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawal successful.");
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }
}

/* =========================
   MAIN APPLICATION
   ========================= */
public class BankSystem {

    private static final String FILE_NAME = "accounts.dat";
    private static HashMap<Integer, Account> accounts;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        accounts = loadAccounts();

        while (true) {
            System.out.println("\n🏦 BANK MENU");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> {
                    saveAccounts();
                    System.out.println("👋 Thank you for using the bank system!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }

    /* =========================
       METHODS
       ========================= */

    private static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (accounts.containsKey(accNo)) {
            System.out.println("❌ Account already exists.");
            return;
        }

        sc.nextLine();
        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        accounts.put(accNo, new SavingsAccount(accNo, name, balance));
        System.out.println("✅ Account created successfully.");
    }

    private static void deposit() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("❌ Account not found.");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        acc.deposit(amt);
    }

    private static void withdraw() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("❌ Account not found.");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        acc.withdraw(amt);
    }

    private static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = accounts.get(accNo);
        if (acc != null) {
            System.out.println("💰 Balance: ₹" + acc.getBalance());
        } else {
            System.out.println("❌ Account not found.");
        }
    }

    /* =========================
       FILE HANDLING
       ========================= */

    private static void saveAccounts() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("❌ Error saving data.");
        }
    }

    @SuppressWarnings("unchecked")
    private static HashMap<Integer, Account> loadAccounts() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (HashMap<Integer, Account>) ois.readObject();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }
}
