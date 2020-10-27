package pers.captain.algorithm.October.tree.traverse;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PostOrder {
    /**
     * 方法一： 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
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
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return result;
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
