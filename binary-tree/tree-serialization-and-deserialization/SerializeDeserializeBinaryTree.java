import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        // Remove the last comma
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();
            if (!nodes[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
    // line 54:
    // if (i < nodes.length && !nodes[i].equals("null")) 
    //     i < nodes.length: Ensures that the index i is within the bounds of the nodes array, preventing an ArrayIndexOutOfBoundsException.
    //     !nodes[i].equals("null"): Checks if the current element in the nodes array is not "null". If it's not "null", it means we need to create a new TreeNode for this value.

    public static void main(String[] args) {
        SerializeDeserializeBinaryTree solution = new SerializeDeserializeBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serializedTree = solution.serialize(root);
        System.out.println("Serialized tree: " + serializedTree);

        TreeNode deserializedTree = solution.deserialize(serializedTree);
        System.out.println("Deserialized tree: " + solution.serialize(deserializedTree)); // Should be the same as serializedTree
    }
}
