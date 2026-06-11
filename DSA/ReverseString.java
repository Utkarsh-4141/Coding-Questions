import java.util.*;

public class ReverseString {

    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        int i=0, j=arr.length-1;
        while(i<j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.equals(reverse(str))) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
        sc.close();
    }
}
