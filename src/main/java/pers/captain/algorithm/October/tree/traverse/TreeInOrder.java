package pers.captain.algorithm.October.tree.traverse;

import org.junit.Test;
import pers.captain.algorithm.CapL;
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
        CapL.print(result.toString());

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
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }//到达最左边节点
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null) {
                    root = node.right;
                }
            }
        }
        return result;
    }
    @Test
    public void inOrder2() {
        /**
         *   1
         *  2  3
         * 4 5
         *
         * 4 2 5 1 3
         */
        TreeNode head = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        head.left = treeNode2;
        head.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        List<Integer> result = inOrder2(head);
        CapL.print(result.toString());

    }
}
