package Concepts.Comparable_Comparator;

import java.util.Arrays;

// sorting 2-D arrayf
public class ComparatorArray {

    static void printArray(int[][] arr) {
        for(int[] i : arr) {
            for(int val : i) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr = {
            {4, 47, 90},
            {19, 15, 4},
            {28, 1, 15},
            {4, 47, 17}
        };

        printArray(arr);
        
        Arrays.sort(arr, (arr1, arr2) -> {
            if(arr1[0] == arr2[0]) {
                for(int i=1 ; i<arr1.length ; i++) {
                    if(arr1[i] != arr2[i]) {
                        return arr1[i] - arr2[i];
                    }
                }
            }
            return arr1[0] - arr2[0];
        });
        System.out.println();
        printArray(arr);
    }
}
