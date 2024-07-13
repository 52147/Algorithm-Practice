class RangeSumQuery {
    private int[] tree;
    private int n;

    public RangeSumQuery(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[2 * n];
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums) {
        // Insert leaf nodes in tree
        for (int i = 0; i < n; i++) {
            tree[n + i] = nums[i];
        }
        // Build the tree by calculating parents
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int index, int val) {
        // Set value at position p
        index += n;
        tree[index] = val;
        // Move upward and update parents
        while (index > 0) {
            int left = index;
            int right = index;
            if (index % 2 == 0) {
                right = index + 1;
            } else {
                left = index - 1;
            }
            // Parent is updated after updating the value
            tree[index / 2] = tree[left] + tree[right];
            index /= 2;
        }
    }

    public int sumRange(int left, int right) {
        left += n;
        right += n;
        int sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left];
                left++;
            }
            if (right % 2 == 0) {
                sum += tree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        RangeSumQuery rsq = new RangeSumQuery(nums);
        System.out.println(rsq.sumRange(0, 2)); // Output: 9
        rsq.update(1, 2);
        System.out.println(rsq.sumRange(0, 2)); // Output: 8
    }
}
