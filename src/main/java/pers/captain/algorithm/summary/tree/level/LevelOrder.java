package pers.captain.algorithm.summary.tree.level;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> oneLayerList = new ArrayList<>();// 每一层所有元素
            while (size > 0) {
                size--;
                TreeNode temp = queue.poll();
                if (temp != null) {
                    oneLayerList.add(temp.val);
                    if (temp.left != null) queue.add(temp.left);//queue是队列先进先出
                    if (temp.right != null) queue.add(temp.right);
                }
            }
            result.add(oneLayerList);
        }
        return result;
    }
}
