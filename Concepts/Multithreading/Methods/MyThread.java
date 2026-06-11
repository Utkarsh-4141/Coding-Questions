package Concepts.Multithreading.Methods;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for(int i=0 ; i<10 ; i++) {
                System.out.println("Count: " + i + " Thread " + Thread.currentThread().getName() + " running....");
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}
