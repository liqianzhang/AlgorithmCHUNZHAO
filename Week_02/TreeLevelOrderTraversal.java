import java.util.ArrayList;
import java.util.List;

/**

 */
public class TreeLevelOrderTraversal {
    List<List<Integer>> result = null;
    public List<List<Integer>> levelOrder(Node root) {
        result = new ArrayList<>();
        if (root != null) {
            order(root, 0);
        }
        return result;
    }
    public void order(Node root, int level){
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                order(child, level + 1);
            }
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
