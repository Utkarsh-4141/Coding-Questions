package Concepts.Multithreading;

public class DeadLockExample {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();
        Task1 task1 = new Task1(pen, paper);
        Task2 task2 = new Task2(pen, paper);
        
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
    }
}

class Task1 implements Runnable {
    private Pen pen;
    private Paper paper;
    public Task1(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }
    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper); //Thread1 locks Pen and requires Paper
    }
}

class Task2 implements Runnable {
    private Pen pen;
    private Paper paper;
    public Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }
    @Override
    public void run() {
        //deadlock is resolved by this
        synchronized(pen) { //executes only when Pen is available
            paper.writeWithPaperAndPen(pen); //Thread2 locks Paper and requires Pen
        }
    }
}

class Pen {
    public synchronized void writeWithPenAndPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName() + " is using Pen and trying to use Paper");
        paper.finishWriting();
    }
    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using Pen");
    }
}

class Paper {
    public synchronized void writeWithPaperAndPen(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " is using Paper and trying to use Pen");
        pen.finishWriting();
    }
    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using Paper");
    }
}
