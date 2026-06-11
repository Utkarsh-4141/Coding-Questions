import java.util.*;

public class ThreeSum { // O(n^2) & O(1)
    static List<List<Integer>> findSum(int[] arr) {
        List<List<Integer>> numbers = new ArrayList<>();
        // sort array
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0 ; i<n-2 ; i++) {
            // skip duplicates
            if(i>0 && arr[i]==arr[i-1])
                continue;
            // two pointers
            int left=i+1, right=n-1;
            while(left<right) {
                int sum = arr[i] + arr[left] + arr[right];
                if(sum==0) {
                    numbers.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    while(left<right && arr[left]==arr[left+1])
                        left++;
                    while(left<right && arr[right]==arr[right-1])
                        right--;
                    left++;
                    right--;
                } else if(sum<0)
                    left++;
                else
                    right--;
            }
        }
        return numbers;
    }
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> numbers = findSum(arr);
        for(List<Integer> list : numbers) {
            System.out.println(list);
        }
    }
}
