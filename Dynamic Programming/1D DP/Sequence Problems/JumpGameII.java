public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        
        int jumps = 0;
        int currentEnd = 0;
        int furthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = furthest;
            }
        }
        
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII jumpGame = new JumpGameII();
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(jumpGame.jump(nums1)); // Output: 2
        System.out.println(jumpGame.jump(nums2)); // Output: 2
    }
}
// class Solution {
//     public int jump(int[] nums) {
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, Integer.MAX_VALUE);
//         dp[0] = 0; // dp[0], which is set to 0 since no jumps are needed to stay at the starting position.
//         for(int i = 0; i < nums.length; i++){
//             for(int j = 0; j < i; j++){
//                 // The inner loop iterates over all positions j that precede i to check if it's possible to reach i from j.

//                 if(nums[j] + j >= i){
//                     dp[i] = Math.min(dp[j] + 1, dp[i]);
//                     // dp[j] + 1 represents the number of jumps needed to reach position i
//                     // does not mean that there is only one jump to choose from. 

//                 }
//             }
//         }
//         return dp[nums.length - 1];
        
//     }
// }