package String;

// Start with the first string as prefix and shrink it until it matches all strings.
public class LongestCommonPrefix { // Horizontal Scanning O(n*m)
    static String longestCommonPrefix(String[] strArr) {
        if(strArr==null || strArr.length==0)
            return "";
        String prefix = strArr[0];
        for(int i=1 ; i<strArr.length ; i++) {
            while(strArr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1); // Reduces prefix gradually
                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
