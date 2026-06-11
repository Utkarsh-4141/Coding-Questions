import java.util.Scanner;

public class SecondLargest {

    static int findSecondLargest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int num : arr) {
            if(num>first) {
                second = first;
                first = num;
            } else if(num>second && num!=first) {
                second = num;
            }
        }
        return second;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        for(int i=0 ; i<10 ; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Second Largest Element: " + findSecondLargest(arr));
        sc.close();
    }
}
