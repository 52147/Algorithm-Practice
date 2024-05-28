import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        
        Map<Character, Integer> charCountMap = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            
            while (charCountMap.size() > k) {
                char leftChar = s.charAt(left);
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                if (charCountMap.get(leftChar) == 0) {
                    charCountMap.remove(leftChar);
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        
        return maxLength;
    }
}
