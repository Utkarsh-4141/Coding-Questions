package String;

import java.util.Scanner;

public class ReverseString {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = "";

        for(int i=str.length()-1 ; i>=0 ; i--) {
            res += str.charAt(i);
        }

        System.out.println("Reversed string: " + res);
        sc.close();
    }
}
