package pers.captain.algorithm.October.tree.traverse;

import org.junit.Test;
import pers.captain.algorithm.CapL;
import pers.captain.algorithm.structrue.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 */
public class TreePreOrder {

    /*
    方法一： 递归方式
     */
    public List<Integer> preOrder1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }


    @Test
    public void preOrder1() {
        TreeNode head = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        head.left = treeNode2;
        head.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        List<Integer> result = preOrder1(head);
        CapL.print(result.toString());
    }

    /*
    方法二： 迭代的方式
     */
    public List<Integer> preOrder2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        if (root == null) return result;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    @Test
    public void preOrder2() {
        TreeNode head = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        head.left = treeNode2;
        head.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        List<Integer> result = preOrder2(head);
        CapL.print(result.toString());
    }
}
