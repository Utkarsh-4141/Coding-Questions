package String;

public class RemoveConsecutiveChars { // O(n) & O(n)
    static String removeConsecutiveDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        if(str==null || str.length()==0)
            return "";
        for(int i=1 ; i<str.length() ; i++) {
            if(str.charAt(i) != str.charAt(i-1))
                sb.append(str.charAt(i)); // append only if not same as previous
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "aaabbcddd";
        System.out.println(removeConsecutiveDuplicates(s));
    }
}
