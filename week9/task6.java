import java.util.*;

// Account class
class Account {
    int accountNumber;
    String name;
    double balance;

    Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
}

// Bank class
class Bank {
    Map<Integer, Account> accounts = new HashMap<>();

    // Add account
    void addAccount(Account acc) {
        accounts.put(acc.accountNumber, acc);
    }

    // Deposit
    void deposit(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }
        acc.balance += amount;
        System.out.println("Deposited " + (int)amount + " to " + acc.name);
    }

    // Withdraw
    void withdraw(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }
        if (acc.balance < amount) {
            System.out.println("Insufficient balance");
            return;
        }
        acc.balance -= amount;
        System.out.println("Withdrawn " + (int)amount + " from " + acc.name);
    }

    // Transfer
    void transfer(int fromAcc, int toAcc, double amount) {
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("Account not found");
            return;
        }

        if (sender.balance < amount) {
            System.out.println("Insufficient balance");
            return;
        }

        sender.balance -= amount;
        receiver.balance += amount;

        System.out.println("Transferred " + (int)amount + " from " + sender.name + " to " + receiver.name);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        // Read accounts
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int accNo = sc.nextInt();
            String name = sc.next();
            double balance = sc.nextDouble();

            bank.addAccount(new Account(accNo, name, balance));
        }

        // Process operations
        int ops = sc.nextInt();
        for (int i = 0; i < ops; i++) {
            String operation = sc.next();

            if (operation.equals("DEPOSIT")) {
                int accNo = sc.nextInt();
                double amount = sc.nextDouble();
                bank.deposit(accNo, amount);

            } else if (operation.equals("WITHDRAW")) {
                int accNo = sc.nextInt();
                double amount = sc.nextDouble();
                bank.withdraw(accNo, amount);

            } else if (operation.equals("TRANSFER")) {
                int fromAcc = sc.nextInt();
                int toAcc = sc.nextInt();
                double amount = sc.nextDouble();
                bank.transfer(fromAcc, toAcc, amount);
            }
        }

        sc.close();
    }
}
