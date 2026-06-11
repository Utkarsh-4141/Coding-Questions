package String;
import java.util.*;

public class GroupAnagrams {
    static List<List<String>> groupAnagrams(String[] strArr) { // O(n * k log k) & O(n * k)
        Map<String, List<String>> map = new HashMap<>();
        for(String word : strArr) {
            // Step 1: sort characters
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            // Step 2: group in map
            String key = new String(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }

    static List<List<String>> group(String[] strs) { // O(n * k)
        Map<String, List<String>> map = new HashMap<>();
        for(String word : strs) {
            int[] freq = new int[26];
            for(char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }

            // Build key
            StringBuilder key = new StringBuilder();
            for(int count : freq) {
                key.append(count).append('#');
            }
            
            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(word);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] strs =  {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs)); // sorting
        System.out.println(group(strs)); // frequency array (more optimized)
    }
}

// map:
// "aet" → [eat, tea, ate]
// "ant" → [tan, nat]
// "abt" → [bat]
