import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
// use inorder(left-root-right) to get the right and left subtree length
// use preorder(root-left-right) to get the root node
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
// why not just use inorder to construct the tree?
// Using only the inorder traversal to construct a binary tree is not possible because the inorder traversal does not provide enough information about the structure of the tree. Inorder traversal alone only tells you the relative order of nodes but does not indicate which node is the root or how the nodes are connected (left or right children).

// For example, consider the inorder traversal: `[9, 3, 15, 20, 7]`. This sequence could represent multiple different binary trees. Here are a few possibilities:

// ```
//     3
//    / \
//   9   20
//      /  \
//     15   7
// ```

// ```
//     20
//    /  \
//   3    7
//  / \
// 9  15
// ```

// To uniquely determine the structure of the binary tree, you need additional information, typically provided by another traversal such as preorder or postorder.

// ### Why Use Both Preorder and Inorder

// - **Preorder Traversal**: The first element in preorder traversal is always the root of the tree or subtree. This allows you to identify the root node immediately.
// - **Inorder Traversal**: Provides information about the left and right subtrees relative to the root node.

// By combining these two traversals, you can construct the tree uniquely. The preorder traversal helps identify the root, and the inorder traversal helps partition the tree into left and right subtrees.

// ### Example Code Explanation

// Let's revisit the code for constructing a binary tree from preorder and inorder traversals. The following steps describe how the tree is constructed:

// 1. **Preorder Traversal**:
//    - Root -> Left Subtree -> Right Subtree
//    - The first element is always the root.

// 2. **Inorder Traversal**:
//    - Left Subtree -> Root -> Right Subtree
//    - Helps partition the tree into left and right subtrees.

// ### Step-by-Step Construction

// 1. **Identify the root**:
//    - The first element in the preorder array is the root of the tree.

// 2. **Partition the Inorder Array**:
//    - Find the index of the root in the inorder array.
//    - Elements to the left of this index belong to the left subtree.
//    - Elements to the right of this index belong to the right subtree.

// 3. **Recursively Construct Subtrees**:
//    - Use the calculated indices to recursively build the left and right subtrees.

// ### Complete Code with Explanation

// ```java
// import java.util.HashMap;
// import java.util.Map;

// public class BinaryTreeFromPreorderInorder {
//     private Map<Integer, Integer> inorderMap;

//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         // Create a map to store value -> index pairs for quick lookup in the inorder array.
//         inorderMap = new HashMap<>();
//         for (int i = 0; i < inorder.length; i++) {
//             inorderMap.put(inorder[i], i);
//         }
//         // Start building the tree using the helper function
//         return buildTreeHelper(preorder, 0, preorder.length - 1, 0);
//     }

//     private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int inStart) {
//         // Base case: if there are no elements to process, return null
//         if (preStart > preEnd) {
//             return null;
//         }

//         // The first element in the current preorder segment is the root
//         TreeNode root = new TreeNode(preorder[preStart]);
//         // Find the index of the root in the inorder array
//         int inRoot = inorderMap.get(root.val);
//         // Calculate the size of the left subtree
//         int leftTreeSize = inRoot - inStart;

//         // Recursively build the left subtree
//         // Left subtree in preorder: from preStart + 1 to preStart + leftTreeSize
//         // Left subtree in inorder: from inStart to inRoot - 1
//         root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftTreeSize, inStart);

//         // Recursively build the right subtree
//         // Right subtree in preorder: from preStart + leftTreeSize + 1 to preEnd
//         // Right subtree in inorder: from inRoot + 1 to preEnd
//         root.right = buildTreeHelper(preorder, preStart + leftTreeSize + 1, preEnd, inRoot + 1);

//         return root;
//     }

//     public static void main(String[] args) {
//         BinaryTreeFromPreorderInorder solution = new BinaryTreeFromPreorderInorder();

//         int[] preorder = {3, 9, 20, 15, 7};
//         int[] inorder = {9, 3, 15, 20, 7};

//         TreeNode root = solution.buildTree(preorder, inorder);
//         // Add your own logic to print or verify the tree structure
//     }

//     public static class TreeNode {
//         int val;
//         TreeNode left;
//         TreeNode right;
//         TreeNode(int x) { val = x; }
//     }
// }
// ```

// ### Summary
// - **Inorder Traversal** alone is insufficient to reconstruct a binary tree.
// - **Preorder Traversal** provides the necessary information to identify root nodes.
// - Combining both traversals allows you to construct the tree uniquely and efficiently.