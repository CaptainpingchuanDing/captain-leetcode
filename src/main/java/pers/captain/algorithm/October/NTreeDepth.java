package pers.captain.algorithm.October;

import java.util.List;

public class NTreeDepth {
    public int maxDepth(Node root) {
        if (root == null || root.children == null) return 0;
        int maxDepth = 0;
        for (Node node : root.children) {
            int depth = maxDepth(node);
            if (maxDepth < depth) maxDepth = depth;
        }
        return maxDepth + 1;
    }

}


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}