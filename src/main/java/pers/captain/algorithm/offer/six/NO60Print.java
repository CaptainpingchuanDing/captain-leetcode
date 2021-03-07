package pers.captain.algorithm.offer.six;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 示例1
 * 输入
 * <p>
 * {8,6,10,5,7,9,11}
 * 返回值
 * <p>
 * [[8],[6,10],[5,7,9,11]]
 */
public class NO60Print {
    ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (size-- > 0) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
            res.add(list);
        }
        return res;
    }
}
