import java.util.*;

public class TwoSum {
    static int[] findTwoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<arr.length ; i++) {
            int complement = target - arr[i];
            if(map.containsKey(complement))
                return new int[]{map.get(complement), i};
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
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
        System.out.println("Enter target: ");
        int target = sc.nextInt();
        int[] res = findTwoSum(arr, target);
        if(res[0] == -1) {
            System.out.println("No solution found!");
        } else {
            System.out.println("Indices: " + res[0] + " and " + res[1]);
        }
        sc.close();
    }
}
