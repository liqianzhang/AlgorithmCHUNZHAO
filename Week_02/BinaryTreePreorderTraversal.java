import java.util.ArrayList;
import java.util.List;

/**

 */
public class BinaryTreePreorderTraversal {
    List<Integer> list;
    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        order(root);
        return list;
    }
    public void order(TreeNode root) {
        if (root ==null) {
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            order(root.left);
        }
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
