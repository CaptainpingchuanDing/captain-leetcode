package pers.captain.algorithm.October.buildTree;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree {

    private Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
    private int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int pre_root, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        TreeNode root = new TreeNode(pre[pre_root]);
        int i = indexMap.get(pre[pre_root]);
        root.left = recur(pre_root + 1, inLeft, i - 1);
        root.right = recur(pre_root + i - inLeft + 1, i + 1, inRight);
        return root;
    }
}
