package Logical;

import java.util.Scanner;

public class Fibonacci {

    static void fib(int num) {
        int first=0, second=1;
        for(int i=0 ; i<num ; i++) {
            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        fib(num);
        sc.close();
    }
}
