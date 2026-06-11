package Concepts.Multithreading.Locks;

public class MyThread{
    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(100);
            }
            
        };
        Thread t1 = new Thread(task, "Utkarsh");
        Thread t2 = new Thread(task, "Sarthak");
        t1.start();
        t2.start();
    }
}
