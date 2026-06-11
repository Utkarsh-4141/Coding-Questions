package Array;

import java.util.*;

public class RemoveDuplicate { // for unsorted array
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter array elements: ");
        for(int i=0 ; i<size ; i++) {
            arr[i] = sc.nextInt();
        }
        
        Set<Integer> set = new LinkedHashSet<>(); // stores unique + maintains insertion order
        for(int val : arr) {
            set.add(val);
        }
        for(int val : set) {
            System.out.print(val + " ");
        }
        sc.close();
    }
}
