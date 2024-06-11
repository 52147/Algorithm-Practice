import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ConstructBinaryTree {
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, 0);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int inStart) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inorderMap.get(root.val);
        int leftTreeSize = inRoot - inStart;

        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftTreeSize, inStart);
        root.right = buildTreeHelper(preorder, preStart + leftTreeSize + 1, preEnd, inRoot + 1);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        ConstructBinaryTree solution = new ConstructBinaryTree();
        TreeNode root = solution.buildTree(preorder, inorder);
        // Output: Constructed Binary Tree
    }
}

