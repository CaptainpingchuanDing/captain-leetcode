package pers.captain.algorithm.summary.tree.build;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class BuildTreeFromInOrderAndPostOrder {


    /**
     * 分治的思想
     * @param inorder
     * @param postOrder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postOrder) {
        if (inorder == null || postOrder == null || inorder.length < 1 || postOrder.length < 1) return null;
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();// 构建二叉树中序遍历数值和index的hash表
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1, 0, postOrder.length - 1, inorder, postOrder, inorderIndexMap);
    }

    public TreeNode helper(int inStart, int inEnd, int postStart, int postEnd, int[] inorder, int[] postOrder, Map<Integer, Integer> indexMap) {
        if (inStart > inEnd || postStart > postEnd) return null;// 结束条件
        TreeNode node = new TreeNode(postOrder[postEnd]);
        int mid = indexMap.get(postOrder[postEnd]);
        //容易知道 左子树中序遍历的开始和结束下标 [inStart, mid-1]，
        // 后续遍历的左边的元素个数和中序遍历左边的元素个数相同，所以后续遍历的左边的结束下标是mid-1 - inStart+postStart
        node.left = helper(inStart, mid - 1, postStart, mid - 1 - inStart + postStart, inorder, postOrder, indexMap);
        //容易知道 右子树中序遍历的开始和结束下标 mid+1, inEnd,
        node.right = helper(mid + 1, inEnd, mid - 1 - inStart + postStart + 1, postEnd - 1, inorder, postOrder, indexMap);
        return node;
    }
}
