package String;

public class NextPermutation { // Greedy + Reverse O(n) & O(1)
    static String nextPermutation(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        // Step 1: find pivot
        int i = n - 2;
        while(i>=0 && arr[i]>=arr[i+1])
            i--;
        // Step 2: find next greater element
        if(i>=0) {
            int j = n - 1;
            while(arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        // Step 3: reverse suffix
        reverse(arr, i+1, n-1);
        return new String(arr);
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(char[] arr, int left, int right) {
        while(left < right)
            swap(arr, left++, right--);
    }
    public static void main(String[] args) {
        String str = "abdc";
        System.out.println("Output: " + nextPermutation(str));
    }
}


// 1. Find first decreasing character from right (pivot)
// 2. swap with next greater character from right
// 3. Reverse the suffix