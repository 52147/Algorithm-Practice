import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return result;

        Map<Character, Integer> pCount = new HashMap<>();
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sCount = new HashMap<>();
        int left = 0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);

            if (right - left + 1 > p.length()) {
                char leftChar = s.charAt(left);
                sCount.put(leftChar, sCount.get(leftChar) - 1);
                if (sCount.get(leftChar) == 0) {
                    sCount.remove(leftChar); // removes the key and its corresponding value from the map
                }
                left++;
            }

            // equals() to compare HashMap instances, it checks if both maps contain the same mappings (i.e., the same keys and values).
            if (sCount.equals(pCount)) {
                result.add(left);
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p)); // Output: [0, 6]
    }
}
