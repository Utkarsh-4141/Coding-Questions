package Logical;
import java.util.Scanner;

public class Fibonacci_recursion {
    
    static int fib(int num) {
        if(num==0)
            return 0;
        if(num==1)
            return 1;
        return fib(num-1) + fib(num-2);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=0 ; i<num ; i++) {
            System.out.println(fib(i));
        }
        sc.close();
    }
}
