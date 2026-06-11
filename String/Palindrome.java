package String;

public class Palindrome { // two pointers O(n) & O(1)
    static boolean isPalindrome(String str) {
        int left=0, right=str.length()-1;
        while(left<right) {
            // Skip non-alphanumeric characters
            while(left<right && !Character.isLetterOrDigit(str.charAt(left)))
                left++;
            while(left<right && !Character.isLetterOrDigit(str.charAt(right)))
                right--;
            // Compare characters (ignore case)
            if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "race a car!"; //"A man, a plan, a canal: Panama";
        System.out.println("Palindrome: " + isPalindrome(s));
    }
}
