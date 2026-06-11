package Array;

public class SearchRotatedSortedArray {
    static int search(int[] arr, int num) {
        int left=0, right=arr.length-1;
        while(left<=right) {
            int mid = (left + right)/2;
            if(arr[mid] == num)
                return mid;
            if(arr[left]<=arr[mid]) { // for left half
                if(arr[left]<=num && num<arr[mid])
                    right = mid-1;
                else
                    left = mid+1;
            } else { // for right half
                if(arr[mid]<num && num<=arr[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println("Index: " + search(arr, 3));
    }
}
