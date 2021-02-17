package pers.captain.algorithm.tree;

import pers.captain.algorithm.structrue.TreeNode;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        boolean res;
        if (root.val == targetSum && (root.left == null && root.right == null)) {
            return true;
        }
        //if(root.left!=null)
        res = hasPathSum(root.left, targetSum - root.val);
        if (res) return true;
        //if(root.right!=null)
        res = hasPathSum(root.right, targetSum - root.val);
        if (res) return true;
        return res;
    }
}
