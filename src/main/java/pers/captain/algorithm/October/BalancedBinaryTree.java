package pers.captain.algorithm.October;

import pers.captain.algorithm.structrue.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftLen = getLength(root.left);
        int rightLen = getLength(root.right);
        int del = Math.abs(leftLen - rightLen);
        if (del <= 1) {
            return true;
        }

        return false;
    }

    private int getLength(TreeNode root) {
        if (root == null) return 0;
        int leftLength = getLength(root.left);
        int rightLength = getLength(root.right);

        return Math.max(leftLength, rightLength) + 1;
    }


    /**
     * 自底向上
     * 采用的是前序遍历
     * 当 balanceHelper 函数返回-1表示对应的树不是平衡的
     *
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        return balanceHelper(root) != -1;
    }

    private int balanceHelper(TreeNode root) {
        if (root == null) return 0;
        int left = balanceHelper(root.left);
        if (left == -1) return -1;
        int right = balanceHelper(root.right);
        if (right == -1) return -1;

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


    public boolean isBalancedTest(TreeNode root) {
        return isBalancedHelper(root) != -1;
    }

    private int isBalancedHelper(TreeNode root) {
        if (root == null) return 0;
        int left = isBalancedHelper(root.left);
        if (left == -1) return -1;
        int right = isBalancedHelper(root.right);
        if (right == -1) return -1;

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
