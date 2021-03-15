package pers.captain.algorithm.summary.tree.build;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeCoder {

    /**
     * 方法一： DFS 利用树的前序遍历  前 左 右
     *
     * @param root
     * @return
     */
    public String serialize1(TreeNode root) {
        if (root == null) return "null";
        return root.val + "," + serialize1(root.left) + "," + serialize1(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        String val = queue.poll();
        if ("null".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }

    /**
     * 方法二： BFS   利用树的层次遍历
     *
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder().append("[");
        Queue<TreeNode> queue = new LinkedList<>();// 先进先出
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                res.append("null").append(",");
            }
        }
        return res.append("]").toString();
    }

    public TreeNode deserialize2(String str) {
        if (str == null || str.length() <= 2) return null;
        String[] nodeStr = str.substring(1, str.length() - 2).split(",");
        TreeNode[] node = new TreeNode[nodeStr.length];
        for (int i = 0; i < nodeStr.length; i++) {
            if (!nodeStr[i].equals("null")) {
                node[i] = new TreeNode(Integer.parseInt(nodeStr[i]));
            }
        }
        for (int i = 0, j = 1; j < node.length; i++) {// j是
            if (node[i] != null) {
                node[i].left = node[j++];
                node[i].right = node[j++];
            }
        }
        return node[0];// 根节点
    }
}
