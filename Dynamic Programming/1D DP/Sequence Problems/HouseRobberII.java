public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robLinear(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                        robLinear(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int robLinear(int[] nums) {
        int prev = 0, curr = 0;
        for (int num : nums) {
            int temp = curr;
            curr = Math.max(curr, prev + num);
            prev = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        HouseRobberII hr2 = new HouseRobberII();
        int[] nums = {2, 3, 2};
        System.out.println(hr2.rob(nums)); // Output: 3
    }
}
