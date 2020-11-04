package pers.captain.algorithm.nov;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 */
public class TreeNodeKthLargest {

    /**
     * 方法一： 中序遍历
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorder(inorder, root);
        if (k > inorder.size()) {
            return -1;
        } else {
            return inorder.get(inorder.size() - k);
        }
    }

    private void inorder(List<Integer> inorder, TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            inorder(inorder, root.left);
        }
        inorder.add(root.val);
        if (root.right != null) {
            inorder(inorder, root.right);
        }
    }

    /**
     * 方法二： 中序遍历的 倒序 , 第k个就可以返回了
     *
     * @param root
     * @param k
     * @return
     */
    int res, k;

    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        if (k == 0) return;
        dfs(root.right);
        if (--k == 0) res = root.val;
        dfs(root.left);
    }

}
