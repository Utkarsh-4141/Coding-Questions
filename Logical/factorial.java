package Logical;

import java.util.Scanner;

public class factorial {

    static int findFact(int num) {
        int fact = 1;
        for(int i=1 ; i<=num ; i++) {
            fact *= i;
        }
        return fact;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(findFact(num));
        sc.close();
    }
}
