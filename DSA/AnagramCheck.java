public class AnagramCheck {
    static boolean checkAnagram(String first, String second) {
        if(first.length() != second.length())
            return false;
        int[] temp = new int[128];
        for(int i=0 ; i<first.length() ; i++) {
            // temp[first.charAt(i) - '0']++;
            // temp[second.charAt(i) - '0']--;
            // temp[first.charAt(i) - 'a']++;
            // temp[second.charAt(i) - 'a']--;
            // temp[first.charAt(i) - 'A']++;  // 1
            // temp[second.charAt(i) - 'A']--; // 0
            temp[first.charAt(i)]++;
            temp[second.charAt(i)]--;
        }
        for(int val : temp) {
            if(val != 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // if(checkAnagram("1659", "9156"))
        //if(checkAnagram("listen", "silent"))
        if(checkAnagram("CAT", "ACT"))
            System.out.println("Anagram");
        else
            System.out.println("Not Anagram");
    }
}
