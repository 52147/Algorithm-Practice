import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Create a map to store the cumulative sum modulo k and the corresponding index
        Map<Integer, Integer> modMap = new HashMap<>();
        // Initialize the map with modulo 0 at index -1 to handle edge cases
        modMap.put(0, -1);
        int cumulativeSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            int mod = k == 0 ? cumulativeSum : cumulativeSum % k;
            
            if (modMap.containsKey(mod)) {
                if (i - modMap.get(mod) > 1) {
                    return true;
                }
            } else {
                modMap.put(mod, i);
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum solution = new ContinuousSubarraySum();
        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println(solution.checkSubarraySum(nums1, k1)); // Output: true

        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        System.out.println(solution.checkSubarraySum(nums2, k2)); // Output: true

        int[] nums3 = {23, 2, 6, 4, 7};
        int k3 = 0;
        System.out.println(solution.checkSubarraySum(nums3, k3)); // Output: false
    }
}
