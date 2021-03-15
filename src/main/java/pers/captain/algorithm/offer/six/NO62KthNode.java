package pers.captain.algorithm.offer.six;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 * 示例1
 * 输入
 * <p>
 * {5,3,7,2,4,6,8},3
 * 返回值
 * <p>
 * {4}
 * 说明
 * 按结点数值大小顺序第三小结点的值为4
 */
public class NO62KthNode {

    /**
     * 方法一： 递归的方式
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) return null;
        List<TreeNode> list = new ArrayList();
        dfs(pRoot, list, k);
        if (list.size() == k) return list.get(k - 1);
        else return null;

    }

    private boolean dfs(TreeNode node, List<TreeNode> list, int k) {
        if (node == null) return false;
        boolean flag = dfs(node.left, list, k);
        if (flag) return true;
        list.add(node);
        if (list.size() == k) return true;
        flag = dfs(node.right, list, k);
        return flag;
    }

    /**
     * 方法二： 循环遍历的方式
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode2(TreeNode pRoot, int k) {
        if (pRoot == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        int size = 0;
        while (pRoot != null || !stack.isEmpty()) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                size++;
                if (size == k) return node;
                if (node.right != null) {
                    pRoot = node.right;
                }
            }
        }
        return null;
    }
}
