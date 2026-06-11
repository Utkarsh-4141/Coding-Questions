import java.util.Scanner;

public class BinarySearch {

    static int search(int[] arr, int num) {
        int start=0, end=arr.length-1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(arr[mid]==num)
                return mid;
            else if(arr[mid]<num)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.println("Enter array elements: ");
        for(int i=0 ; i<10 ; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number to search: ");
        int num = sc.nextInt();

        System.out.println("Element found at index: " + search(arr, num));
        sc.close();
    }
}
