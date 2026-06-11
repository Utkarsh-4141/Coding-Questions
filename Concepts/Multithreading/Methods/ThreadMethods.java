package Concepts.Multithreading.Methods;

public class ThreadMethods {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("T1"); //NEW
        MyThread t2 = new MyThread("T2"); //NEW
        t1.start(); //RUNNABLE
        try {
            t1.join(); //waits until execution completed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start(); //RUNNABLE
    }
}


// start()  = starts the thread
// wait()   = waits the thread and releases the lock
// notify() = wakes up the thread
// sleep()  = waits the thread but retains the lock
// join()   = waits until complete the execution
// yield()  = hints the scheduler, other thread can also get chance
// currentThread.getName()
// currentThread.getPriority()
// currentThread.setPriority()

// interrupt() = sets the thread interrupt status flag true
// Interrupting the current thread sets its interrupt status flag true.
// If the thread is blocked in sleep(), wait(), or join(), it throws InterruptedException and clears the flag.
// Always restore interrupt flag if you catch InterruptedException.
// If it is running normally, nothing happens unless the thread checks the interrupt status.
// Interrupt does not forcibly stop a thread; it is a cooperative mechanism.