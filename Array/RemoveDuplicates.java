package Array;

import java.util.Scanner;

public class RemoveDuplicates { //only for sorted array

    static int removeDuplicates(int[] arr, int size) {
        if(size==0 || size==1)
            return size;
        int i=0;
        for(int j=1 ; j<size ; j++) {
            if(arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter array elements: ");
        for(int i=0 ; i<size ; i++) {
            arr[i] = sc.nextInt();
        }
        int newSize = removeDuplicates(arr, size);
        for(int i=0 ; i<newSize ; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
