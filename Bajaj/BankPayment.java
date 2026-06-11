package Bajaj;

import java.util.*;

class Account {
    String accountId;
    double balance;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
}

class Transaction {
    String transactionId;
    String fromAccount;
    String toAccount;
    double amount;
    String status;

    public Transaction(String transactionid, String fromAccount, String toAccount, double amount) {
        this.transactionId = transactionid;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.status = "PENDING";
    }
}

public class BankPayment {
    static Map<String, Account> accounts = new HashMap<>();
    static Set<String> processedTransactions = new HashSet<>();

    static String processPayment(Transaction txn) {
        Account sender = accounts.get(txn.fromAccount);
        Account receiver = accounts.get(txn.toAccount);

        if(txn.amount<=0){
            txn.status = "FAILED";
            return "Invalid Amount!";
        }
            
        if(sender==null || receiver==null) {
            txn.status = "FAILED";
            return "Account not Found!";
        }

        if(sender.balance < txn.amount) {
            txn.status = "FAILED";
            return "Insufficient Balance!";
        }

        if(processedTransactions.contains(txn.transactionId)) {
            txn.status = "FAILED";
            return "Duplicate Transaction Detected!";
        }

        sender.balance -= txn.amount;
        receiver.balance += txn.amount;
        txn.status = "SUCCESS";
        processedTransactions.add(txn.transactionId);
        return "Transaction Successful!";
    }

    public static void main(String[] args) {
        accounts.put("A1", new Account("A1", 10000));
        accounts.put("A2", new Account("A2", 5000));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Transaction Id: ");
        String transactionId = sc.nextLine();

        System.out.println("Enter Sender Account Name: ");
        String fromAccount = sc.nextLine();

        System.out.println("Enter Receiver Account Name: ");
        String toAccount = sc.nextLine();

        System.out.println("Enter Amount: ");
        double amount = sc.nextDouble();

        Transaction txn = new Transaction(transactionId, fromAccount, toAccount, amount);
        String res = processPayment(txn);
        System.out.println(res);
        System.out.println("Transaction Status: " + txn.status);

        System.out.println("Sender Balance: " + accounts.getOrDefault(fromAccount, new Account("0", 0)).balance);
        System.out.println("Receiver Balance: " + accounts.getOrDefault(toAccount, new Account("0", 0)).balance);
        sc.close();
    }
}
