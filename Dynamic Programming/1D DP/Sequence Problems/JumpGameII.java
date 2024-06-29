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
