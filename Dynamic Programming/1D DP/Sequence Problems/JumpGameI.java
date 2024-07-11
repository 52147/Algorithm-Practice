public class JumpGameI {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            // The expression i + nums[i] in your code represents the furthest index you can reach from the current index i.

        }
        return true;
    }

    public static void main(String[] args) {
        JumpGameI jumpGame = new JumpGameI();
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(jumpGame.canJump(nums1)); // Output: true
        System.out.println(jumpGame.canJump(nums2)); // Output: false
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