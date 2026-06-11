package Array;
import java.util.*;

public class PossibleCombinations { // Backtracking + implicit stack
    static void generateCombinations(int[] arr, int r) {
        List<Integer> current = new ArrayList<>(); // combination
        backtrack(arr, r, 0, current);
    }

    static void backtrack(int[] arr, int r, int start, List<Integer> current) {
        // base condition
        if(current.size() == r) {
            System.out.println(current);
            return;
        }
        // loop
        for(int i=start ; i<arr.length ; i++) { // i=start => avoids duplicate by forward selection only
            current.add(arr[i]); // add
            backtrack(arr, r, i+1, current); // explore recursive calls
            current.remove(current.size()-1); // backtrack
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int r = 3;
        generateCombinations(arr, r); // arr.length^Cr = n! / ((n-r)! * r!)
    }
}
