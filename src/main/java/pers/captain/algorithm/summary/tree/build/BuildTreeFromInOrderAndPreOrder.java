package pers.captain.algorithm.summary.tree.build;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class BuildTreeFromInOrderAndPreOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || inorder.length < 1 || preorder.length < 1) return null;
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();// 构建二叉树中序遍历数值和index的hash表，因为元素都不相同
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1, 0, preorder.length - 1, inorder, preorder, inorderIndexMap);

    }


    public TreeNode helper(int inStart, int inEnd, int preStart, int preEnd, int[] inorder, int[] preOrder, Map<Integer, Integer> indexMap) {
        if (inStart > inEnd || preStart > preEnd) return null;// 结束条件
        TreeNode node = new TreeNode(preOrder[preStart]);
        int mid = indexMap.get(preOrder[preStart]);
        //容易知道 左子树中序遍历的开始和结束下标 [inStart, mid-1]， 前序遍历的左边的元素个数和中序遍历左边的元素个数相同，容易得到前序遍历的start和end
        node.left = helper(inStart, mid - 1, preStart + 1, preStart + 1 + (mid - 1 - inStart), inorder, preOrder, indexMap);
        //容易知道 右子树中序遍历的开始和结束下标 mid+1, inEnd,
        node.right = helper(mid + 1, inEnd, preEnd - (inEnd - mid - 1), preEnd, inorder, preOrder, indexMap);
        return node;
    }
}
