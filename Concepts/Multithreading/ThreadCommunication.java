package Concepts.Multithreading;

class SharedResource {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) {
        if(hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println(Thread.currentThread().getName() + " produced: " + data);
        notify();
    }

    public synchronized int consume() {
        if(!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println(Thread.currentThread().getName() + " consumed: " + data);
        notify();
        return data;
    }
}

class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i=1 ; i<=10 ; i++) {
            resource.produce(i);
        }
    }
}

class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i=1 ; i<=10 ; i++) {
            resource.consume();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread t1 = new Thread(new Producer(resource));
        Thread t2 = new Thread(new Consumer(resource));

        t1.start();
        t2.start();
    }
}
