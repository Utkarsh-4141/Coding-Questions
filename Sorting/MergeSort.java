package Sorting;

public class MergeSort { // O(n log n) & O(n)
    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid+1-left;
        int n2 = right-mid;

        int[] leftHalf = new int[n1];
        int[] rightHalf = new int[n2];

        for(int i=0 ; i<n1 ; i++)
            leftHalf[i] = arr[left + i];
        for(int j=0 ; j<n2 ; j++)
            rightHalf[j] = arr[mid+1+j];

        int i=0, j=0, k=left;
        while(i<n1 && j<n2) {
            if(leftHalf[i] <= rightHalf[j]) {
                arr[k] = leftHalf[i];
                i++;
            } else {
                arr[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while(i<n1) {
            arr[k] = leftHalf[i];
            i++;
            k++;
        }
        while(j<n2) {
            arr[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if(left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    static void printArray(int[] arr) {
        for(int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Before Sorting:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("After Sorting:");
        printArray(arr);
    }
}
