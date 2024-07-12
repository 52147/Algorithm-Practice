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
