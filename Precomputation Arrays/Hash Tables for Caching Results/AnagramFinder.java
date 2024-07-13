import java.util.*;

public class AnagramFinder {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return result;

        // Create frequency arrays for p and the current window in s
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        // Fill the frequency array for p
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        int left = 0, right = 0;
        while (right < s.length()) {
            // Add the current character to the window
            sFreq[s.charAt(right) - 'a']++;
            
            // If the window size is equal to the length of p, compare frequencies
            if (right - left + 1 == p.length()) {
                if (Arrays.equals(sFreq, pFreq)) {
                    result.add(left);
                }
                // Remove the leftmost character from the window
                sFreq[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        AnagramFinder anagramFinder = new AnagramFinder();
        System.out.println(anagramFinder.findAnagrams("cbaebabacd", "abc")); // Output: [0, 6]
        System.out.println(anagramFinder.findAnagrams("abab", "ab"));         // Output: [0, 1, 2]
    }
}
