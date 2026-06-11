package Concepts.Multithreading.Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance = 1000;
    private Lock lock = new ReentrantLock();

    // t1 sleeps for long time then t2 waits for specified time and then return back no indefinite wait
    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is attempting to withdraw " + amount);
        try {
            // tryLock() tries to acquire the lock or return false if not available
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " processing withdrawal.....");
                        Thread.sleep(10000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " withdrawal completed. Remaining balance: " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance!");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later.");
            }
        } catch (InterruptedException e) {
            // thread state is restored again for cleanup/maintenance code
            Thread.currentThread().interrupt();
        }
    }

    public double getBalance() {
        return balance;
    }
}


// // t1 sleeps for long time so, t2 waits indefinitely in case of intrinsic lock
//     public synchronized void withdraw(int amount) {
//         System.out.println(Thread.currentThread().getName() + " is attempting to withdraw " + amount);
//         if(balance >= amount) {
//             System.out.println(Thread.currentThread().getName() + " processing withdrawal.....");
//             try {
//                 Thread.sleep(10000);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//             balance -= amount;
//             System.out.println(Thread.currentThread().getName() + " withdrawal completed. Remaining balance: " + balance);
//         } else {
//             System.out.println(Thread.currentThread().getName() + " insufficient balance!");
//         }
//     }