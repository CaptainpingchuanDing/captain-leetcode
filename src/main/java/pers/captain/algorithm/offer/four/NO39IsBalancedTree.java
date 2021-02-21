package pers.captain.algorithm.offer.four;

import pers.captain.algorithm.structrue.TreeNode;

/**
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * 示例1
 * 输入
 * <p>
 * {1,2,3,4,5,6,7}
 * 返回值
 * <p>
 * true
 */
public class NO39IsBalancedTree {


    /**
     * 方法一： 一个节点是平衡的，左子树和右子树都是平衡的才返回true
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return false;
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) > 1) return false;
        return IsBalanced_Solution(root.left) & IsBalanced_Solution(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.min(left, right) + 1;
    }

    /**
     * 方法二： 从底向上遍历，减少重复的遍历
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution2(TreeNode root) {
        return depth2(root) != -1;
    }

    private int depth2(TreeNode root) {
        if (root == null) return 0;
        int left = depth2(root.left);
        if (left == -1) return -1;
        int right = depth2(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
