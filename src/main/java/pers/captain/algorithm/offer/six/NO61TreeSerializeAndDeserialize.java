package pers.captain.algorithm.offer.six;

import pers.captain.algorithm.structrue.TreeNode;
import pers.captain.algorithm.summary.tree.T;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NO61TreeSerializeAndDeserialize {
    String Serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#!");
            } else {
                sb.append(node.val + "!");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) return null;
        String[] node = str.split("!");
        TreeNode[] treeNodeArr = new TreeNode[node.length];
        for (int i = 0; i < node.length; i++) {
            if (!node[i].equals("#"))
                treeNodeArr[i] = new TreeNode(Integer.parseInt(node[i]));
        }
        for (int i = 0, j = 1; j < node.length; i++) {
            if (treeNodeArr[i] != null) {
                treeNodeArr[i].left = treeNodeArr[j++];
                treeNodeArr[i].right = treeNodeArr[j++];
            }
        }

        return treeNodeArr[0];
    }

    /**
     * 方法二： 前序遍历解决办法
     * 1
     * / \
     * 2  3
     * /    \
     * 4     5
     * <p>
     * 1,2,4,#,#,#,3,#,5,#,#,
     * 1,2,4,#,#,#,3,#,5,#,#,
     *
     * @param root
     * @return
     */
    String Serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        getSerializeString(root, sb);
        if (sb.length() != 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    void getSerializeString(TreeNode root, StringBuilder sb) {
        if (root == null)
            sb.append("#,");
        else {
            sb.append(root.val + ",");
            getSerializeString(root.left, sb);
            getSerializeString(root.right, sb);
        }
    }

    TreeNode Deserialize2(String str) {
        if (str == null || str.length() == 0 || str.length() == 1)
            return null;
        String[] nodes = str.split(",");
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i].equals("#"))
                treeNodes[i] = new TreeNode(Integer.parseInt(nodes[i]));
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNodes[0]);
        int i = 1;
        while (treeNodes[i] != null) {
            stack.peek().left = treeNodes[i];
            stack.push(treeNodes[i++]);
        }
        while (!stack.isEmpty()) {
            stack.pop().right = treeNodes[++i];
            if (treeNodes[i] != null) {
                stack.push(treeNodes[i++]);
                while (treeNodes[i] != null) {
                    stack.peek().left = treeNodes[i];
                    stack.push(treeNodes[i++]);
                }
            }
        }
        return treeNodes[0];
    }

    /**
     * BFS
     * 1
     * / \
     * 2   3
     * /\
     * 4
     * 1,2,3,4,#,#,#,#,#,
     *
     * @param root
     * @return
     */
    public String serialize_E(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("#,");
            }
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode deserialize_E(String str) {
        if (str == null || str.length() < 2) return null;
        String[] nodeStr = str.split(",");
        TreeNode[] node = new TreeNode[nodeStr.length];
        for (int i = 0; i < nodeStr.length; i++) {
            if (!nodeStr[i].equals("#")) {
                node[i] = new TreeNode(Integer.parseInt(nodeStr[i]));
            }
        }

        for (int i = 0, j = 1; j < node.length; i++) {
            if (node[i] != null) {
                node[i].left = node[j++];
                node[i].right = node[j++];
            }
        }
        return node[0];
    }
}
