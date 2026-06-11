package Concepts.Multithreading;

public class ThreadLifecycle extends Thread {

    @Override
    public void run() {
        System.out.println("Running");
        System.out.println(Thread.currentThread().getName()); //Thread-0
        System.out.println(Thread.currentThread().getState()); //RUNNABLE(RUNNING)
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycle t1 = new ThreadLifecycle();
        System.out.println(t1.getState()); //NEW
        t1.start();
        System.out.println(t1.getState()); //RUNNABLE
        Thread.sleep(1000);
        System.out.println(t1.getState()); //TIME_WAITING
        t1.join(); //completes t1 execution
        System.out.println(t1.getState()); //TERMINATED
        System.out.println(Thread.currentThread().getName()); //main
        System.out.println(Thread.currentThread().getState()); //RUNNABLE(RUNNING)
    }
}
