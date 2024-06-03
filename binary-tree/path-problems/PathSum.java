class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        // base case to handel case where node have only child
        if (root == null) {
            return false;
        }

        // check if the root value equal to the sum when we reach the end of the path
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        // decrease the sum with root value during traversal
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        PathSum solution = new PathSum();
        System.out.println(solution.hasPathSum(root, 22)); // Output: true
    }
}

// sum = 3
//   1
//  / \
// 2   3
// node 1: 3 - 1 = 2 
// node 2: node 2 is leaf node -> 2 = 2 -> return true 
// node 3: node 2 is leaf node -> 2 != 3 -> return false