package Array;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) { // always give input from 1 ......
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int actualSum = 0;
        System.out.println("Enter array elements: ");
        for(int i=0 ; i<n-1 ; i++) {
            arr[i] = sc.nextInt();
            actualSum += arr[i];
        }
        int expectedSum = (n*(n+1))/2;
        System.out.println("Missing Number: " + (expectedSum-actualSum));
        sc.close();
    }
}
