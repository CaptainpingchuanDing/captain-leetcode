package pers.captain.algorithm.offer.three;

import org.junit.Test;
import pers.captain.algorithm.structrue.TreeNode;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 示例1
 * 输入
 * 复制
 * {10,5,12,4,7},22
 * 返回值
 * <p>
 * [[10,5,7],[10,12]]
 * 示例2
 * 输入
 * <p>
 * {10,5,12,4,7},15
 * 返回值
 * <p>
 * []
 */
public class NO24FindPath {

    /**
     * 回溯的思想，通过递归完成
     * 结束条件是，root==null 或者 root.val == target
     * 先看左子树，不行再看右子树
     *
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res, new ArrayList<>(), target);
        return res;
    }

    private void helper(TreeNode root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur, int target) {
        if (root == null) return;
        cur.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {// 注意判断是否到达根节点
            res.add(new ArrayList<>(cur));
        } else {
            if (root.left != null) {
                helper(root.left, res, cur, target - root.val);
            }
            if (root.right != null) {
                helper(root.right, res, cur, target - root.val);
            }
        }
        cur.remove(cur.size() - 1);// 使用完节点记得回溯回去
    }

    @Test
    public void FindPath() {
        TreeNode head = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        head.left = treeNode2;
        head.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        FindPath(head, 8);
    }

}
