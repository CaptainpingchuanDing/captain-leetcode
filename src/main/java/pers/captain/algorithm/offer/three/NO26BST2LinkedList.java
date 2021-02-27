package pers.captain.algorithm.offer.three;

import org.junit.Test;
import pers.captain.algorithm.CapL;
import pers.captain.algorithm.structrue.TreeNode;

import java.util.Stack;

/**
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class NO26BST2LinkedList {
    // 循环的方式处理，中序遍历
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        // 循环的方式处理，中序遍历
        TreeNode root = pRootOfTree;// 根节点
        TreeNode pre = pRootOfTree;// 前驱结点
        boolean flag = true;
        Stack<TreeNode> stack = new Stack();
        while (pRootOfTree != null || !stack.isEmpty()) {
            while (pRootOfTree != null) {
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
            pRootOfTree = stack.pop();
            if (flag) {
                root = pRootOfTree;
                pre = pRootOfTree;
                flag = false;
            } else {
                pre.right = pRootOfTree;
                pRootOfTree.left = pre;
                pre = pRootOfTree;
            }
            pRootOfTree = pRootOfTree.right;
        }
        return root;
    }

    /**
     * 方法二: 递归 自治
     *  todo 没有完成
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        TreeNode node = Convert2(pRootOfTree.left);
        TreeNode root;
        if (node == null) {
            root = pRootOfTree;
        } else {
            root = node;
            root.right = pRootOfTree;
            pRootOfTree.left = root;
        }
        TreeNode next = Convert2(pRootOfTree.right);
        if (next != null) {
            root.right = next;
            next.left = root;
        }

        return root;
    }

    @Test
    public void Convert2() {
        TreeNode head = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        head.left = treeNode2;
        head.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        TreeNode res = Convert2(head);
        CapL.print(res.toString());
    }

}
