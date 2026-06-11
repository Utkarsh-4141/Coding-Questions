package Concepts.Multithreading.Locks.ReadWriteLock;

public class ReadWriteLock {
    public static void main(String[] args) {
        ReadWriteCounter counter = new ReadWriteCounter();

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0 ; i<10 ; i++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented");
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for(int i=0 ; i<10 ; i++) {
                    System.out.println(Thread.currentThread().getName() + " read: " + counter.getCount());
                }
            }
        };

        Thread writerThread = new Thread(task1, "Writer Thread");
        Thread readerThread1 = new Thread(task2, "Reader Thread1");
        Thread readerThread2 = new Thread(task2, "Reader Thread2");

        writerThread.start();
        readerThread1.start();
        readerThread2.start();

        try {
            writerThread.join();
            readerThread1.join();
            readerThread2.join();
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}
