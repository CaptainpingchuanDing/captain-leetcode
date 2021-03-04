package pers.captain.algorithm.offer.five;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目描述
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 示例1
 * 输入
 * 复制
 * {8,6,6,5,7,7,5}
 * 返回值
 * 复制
 * true
 * 示例2
 * 输入
 * <p>
 * {8,6,9,5,7,7,5}
 * 返回值
 * <p>
 * false
 */
public class NO58IsSymmetrical {
    /**
     * 方法一： 递归的方式
     *
     * @param pRoot
     * @return
     */
    boolean isSymmetrical1(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isSim(pRoot.left, pRoot.right);
    }

    boolean isSim(TreeNode p, TreeNode w) {
        // L1 R1 L2 R2  L1 R1 L2 R2
        if (p == null && w == null) return true;
        if (p == null || w == null) return false;
        return p.val == w.val && isSim(p.left, w.right) && isSim(p.right, w.left);
    }

    /**
     * 方法二： DFS的方式
     * 利用栈，每一对进入，每一对一起出
     * left right   (left.left  right.right )  (left.right right.left)
     *
     * @param root
     * @return
     */
    boolean isSymmetrical2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }

    boolean isSymmetricalBFS(TreeNode pRoot) {
        if (pRoot == null) return true;
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(pRoot.left);
        s.offer(pRoot.right);
        while (!s.isEmpty()) {
            TreeNode left = s.poll();//成对取出
            TreeNode right = s.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            //成对插入
            s.offer(left.left);
            s.offer(right.right);
            s.offer(left.right);
            s.offer(right.left);
        }
        return true;
    }
}
