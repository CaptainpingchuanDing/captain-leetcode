package pers.captain.algorithm.summary.tree.path;

import org.junit.Test;
import pers.captain.algorithm.CapL;
import pers.captain.algorithm.structrue.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * <p>
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 */
public class TreePathSum_II {

    /**
     * 回溯的方法 通过DFS 实现
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathList = new ArrayList<>();
        helper(pathList, new ArrayList<Integer>(), root, sum);
        return pathList;
    }

    private void helper(List<List<Integer>> pathList, List<Integer> curPathList, TreeNode root, int target) {
        if (root == null) return;
        curPathList.add(root.val);
        if (target == root.val && root.left == null && root.right == null) {// 判断当前节点是叶子节点且与target相同
            pathList.add(new ArrayList<>(curPathList));
        } else {
            helper(pathList, curPathList, root.left, target - root.val);
            helper(pathList, curPathList, root.right, target - root.val);
        }
        curPathList.remove(curPathList.size() - 1);// 回溯
    }

    @Test
    public void pathSum() {
        TreeNode head = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode44 = new TreeNode(2);

        TreeNode treeNode5 = new TreeNode(7);
        head.left = treeNode2;
        head.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode4.right = treeNode5;
        treeNode4.left = treeNode44;

        TreeNode treeNode6 = new TreeNode(13);
        TreeNode treeNode7 = new TreeNode(4);
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        TreeNode treeNode8 = new TreeNode(5);
        TreeNode treeNode9 = new TreeNode(1);
        treeNode7.left = treeNode8;
        treeNode7.right = treeNode9;

        List<List<Integer>> result = pathSum(head, 22);
        CapL.print(result);
    }
}
