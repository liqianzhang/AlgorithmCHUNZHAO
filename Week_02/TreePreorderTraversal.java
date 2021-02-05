import java.util.ArrayList;
import java.util.List;

/**
 */
public class TreePreorderTraversal {
    List<Integer> list;
    public List<Integer> preorder(Node root) {
        list = new ArrayList<>();
        order(root);
        return list;
    }

    private void order(Node root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for(Node child:root.children) {
            order(child);
        }
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