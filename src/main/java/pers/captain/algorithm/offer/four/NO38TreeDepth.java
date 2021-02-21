package pers.captain.algorithm.offer.four;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 示例1
 * 输入
 * <p>
 * {1,2,3,4,5,#,6,#,#,7}
 * 返回值
 * <p>
 * 4
 */
public class NO38TreeDepth {
    /**
     * 方法一：递归
     *
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    /**
     * 方法二：循环
     *
     * @param root
     * @return
     */
    public int TreeDepth2(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return depth;
    }
}
