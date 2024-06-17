import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // Frequency map for the characters in t
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        // Frequency map for the characters in the current window in s
        HashMap<Character, Integer> mapS = new HashMap<>();

        int left = 0, right = 0;
        int required = mapT.size();  // Number of unique characters in t
        int formed = 0;  // Number of unique characters in the current window with the required frequency

        int[] ans = {-1, 0, 0};  // Length of the window, left pointer, right pointer

        while (right < s.length()) {
            // Add the character from the right pointer to the window
            char c = s.charAt(right);
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);

            // If the frequency of the current character matches the desired frequency in t
            if (mapT.containsKey(c) && mapS.get(c).equals(mapT.get(c))) {
                formed++;
            }

            // Try to contract the window until it ceases to be 'desirable'
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Save the smallest window
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // Remove the character at the left pointer from the window
                mapS.put(c, mapS.get(c) - 1);
                if (mapT.containsKey(c) && mapS.get(c) < mapT.get(c)) {
                    formed--;
                }

                // Move the left pointer
                left++;
            }

            // Move the right pointer
            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + solution.minWindow(s, t));
    }
}
