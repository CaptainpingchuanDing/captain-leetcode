package pers.captain.algorithm.tree;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(root, targetSum, new ArrayList(), result);
        return result;
    }
    //回溯法 (递归实现)
    private void helper(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> result) {
        if (root == null) return;
        list.add(root.val);
        if (root.val == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList(list));
        } else {
            if (root.left != null) {
                helper(root.left, targetSum - root.val, list, result);
            }
            if (root.right != null) {
                helper(root.right, targetSum - root.val, list, result);
            }
        }
        list.remove(list.size() - 1);
    }
}
