import java.util.ArrayList;
import java.util.List;

/**
 */
public class BinaryTreeInorderTraversal {
    List<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        order(root);
        return list;
    }

    private void order(TreeNode root) {
        if (root.left != null) {
            order(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            order(root.right);
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
