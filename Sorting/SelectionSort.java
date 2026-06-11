package Sorting;

public class SelectionSort { // O(n^2) & O(1)
    static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i=0 ; i<n-1 ; i++) {
            int minIndex = i;
            for(int j=i+1 ; j<n ; j++) {
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    static void printArray(int[] arr) {
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Before Sorting:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("After Sorting:");
        printArray(arr);
    }
}
