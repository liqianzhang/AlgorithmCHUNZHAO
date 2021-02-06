import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历

 */
public class TreePostorderTraversal {
    List<Integer> list;
    public List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        order(root);
        return list;
    }

    private void order(Node root) {
        if (root == null) {
            return;
        }
        for(Node child:root.children) {
            order(child);
        }
        list.add(root.val);
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
