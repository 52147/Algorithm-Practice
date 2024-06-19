
public class LongestSubstringWithoutRepeatingCharacter2 {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[128];
        int l = 0;
        int r = 0;
        int ans = 0;
        while(r < s.length()){
            count[s.charAt(r)]++;
            while(count[s.charAt(r)] > 1){
                count[s.charAt(l)]--;
                l++;
            }
            ans = Math.max(r - l + 1, ans);
            r++;
        }
        return ans;
        
    }
}