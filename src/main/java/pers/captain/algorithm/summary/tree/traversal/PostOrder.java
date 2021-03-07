package pers.captain.algorithm.summary.tree.traversal;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.*;

public class PostOrder {

    /**
     * 方法一： 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(TreeNode root, List<Integer> result) {
        if (root != null) {
            postOrder(root.left, result);
            postOrder(root.right, result);
            result.add(root.val);
        }
    }

    /**
     * 方法二： 迭代
     * 利用二叉树的前序遍历的思想，前序遍历是  中->左->右，
     * 只需要在递归的时候先把左节点压入栈，结果就是中->右->左
     * 最后，只需要翻转一下  就变成了左->右->中 也就是后续遍历
     */
    public List<Integer> postOrder2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        Collections.reverse(result);
        return result;
    }
}
