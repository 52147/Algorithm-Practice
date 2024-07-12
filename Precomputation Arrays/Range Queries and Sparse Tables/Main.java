class NumArray {
    private int[] prefixSums;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSums = new int[n + 1]; // Create prefix sum array of size n+1

        // Compute prefix sums
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSums[right + 1] - prefixSums[left];
    }
}

// Example usage:
public class Main {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2)); // Output: 1
        System.out.println(numArray.sumRange(2, 5)); // Output: -1
        System.out.println(numArray.sumRange(0, 5)); // Output: -3
    }
}
