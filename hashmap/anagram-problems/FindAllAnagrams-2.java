package hashmap.anagram-problems;
import java.util.*;

public class FindAllAnagrams-2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Fill the frequency count for p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = p.length();
        int sLength = s.length();

        for (int i = 0; i < sLength; i++) {
            // Add the current character to the window
            sCount[s.charAt(i) - 'a']++;
            
            // Remove the character left outside the window
            if (i >= windowSize) {
                sCount[s.charAt(i - windowSize) - 'a']--;
            }
            
            // Compare the frequency counts
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }
}
