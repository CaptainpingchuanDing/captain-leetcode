package pers.captain.algorithm.October.tree.traverse;

import org.junit.Test;
import pers.captain.algorithm.LogUtils;
import pers.captain.algorithm.structrue.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class TreeInOrder {

    /**
     * 方法一：递归
     *
     * @param root
     * @return
     */
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> treval) {
        if (root == null) return;
        inOrder(root.left, treval);
        treval.add(root.val);
        inOrder(root.right, treval);
    }

    @Test
    public void inOrder() {
        TreeNode head = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        head.left = treeNode2;
        head.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        List<Integer> result = inOrder(head);
        LogUtils.print(result.toString());

    }

    /**
     * 方法二：迭代
     *
     * @param root
     * @return
     */
    public List<Integer> inOrder2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return result;

        return result;
    }
}
