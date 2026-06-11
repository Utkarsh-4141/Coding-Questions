package Array;

public class MissingRepeated {
    static void findNumbers(int[] arr) {
        int n = arr.length;
        //expected
        int eSum = n * (n+1)/2;  // x
        int eSqSum = n * (n+1) * (2*n+1)/6;  // x^2
        
        //actual
        int aSum = 0;
        int aSqSum = 0;
        for(int val : arr) {
            aSum += val; // y
            aSqSum += val*val; // y^2
        }

        int diff = eSum - aSum; // x - y
        int sqDiff = eSqSum - aSqSum; // x^2 - y^2
        int sum = sqDiff/diff; // x + y

        int missing = (sum+diff)/2; // ((x+y)+(x-y))/2 = 2x/2 = x
        int repeating = sum-missing; // (x+y)-x = y

        System.out.println("Missing: " + missing);
        System.out.println("Repeating: " + repeating);
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1}; // Example
        findNumbers(arr);
    }
}
