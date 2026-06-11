package Concepts.Multithreading.Synchronization;

public class Test {
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();
        try {
            t1.yield();
            t2.yield();
        } catch(Exception e) {
            System.out.println(e);
        }
        Thread.currentThread().sleep(5000);
        // without synchronized keyword gives incorrect output
        System.out.println("Count: " + counter.getCount());
    }
}
