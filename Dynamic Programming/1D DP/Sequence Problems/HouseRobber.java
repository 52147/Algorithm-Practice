public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prev = 0, curr = 0;
        for (int num : nums) {
            int temp = curr;
            curr = Math.max(curr, prev + num);
            prev = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int[] nums = {1, 2, 3, 1};
        System.out.println(hr.rob(nums)); // Output: 4
    }
}
