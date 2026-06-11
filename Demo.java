import java.util.*;

class Demo {

    static String removeConsecutiveDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for(int i=1 ; i<str.length() ; i++) {
            if(str.charAt(i) != str.charAt(i-1))
                sb.append(str.charAt(i));
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        String s = "aaabbcddd";
        System.out.println(removeConsecutiveDuplicates(s));
    }
}