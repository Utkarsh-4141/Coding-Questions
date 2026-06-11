package Sorting;

public class BubbleSort { // O(n^2) & O(1)
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i=0 ; i<n-1 ; i++) {
            boolean swapped = false;
            for(int j=0 ; j<n-1-i ; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }
    }

    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {5, 1, 4, 2, 8};

        System.out.println("Before Sorting:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("After Sorting:");
        printArray(arr);
    }
}
