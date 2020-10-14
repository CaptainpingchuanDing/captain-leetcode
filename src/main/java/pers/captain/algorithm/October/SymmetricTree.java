package pers.captain.algorithm.October;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SymmetricTree {

    /**
     * 不正确
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> layerItemList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode node = queue.poll();
                layerItemList.add(node);
            }
            if (!isSymmetric(layerItemList, queue)) {
                return false;
            }
            layerItemList.clear();
        }
        return true;
    }

    private boolean isSymmetric(List<TreeNode> layerItemList, Queue<TreeNode> queue) {

        int len = layerItemList.size();
        if (len % 2 != 0) return false;
        for (int i = 0; i < len / 2; i++) {
            TreeNode node1 = layerItemList.get(i);
            TreeNode node2 = layerItemList.get(len - 1 - i);
            if ((node1.left != null && node2.right != null && node1.left.val == node2.right.val)
                    || (node1.right != null && node2.left != null && node1.right.val == node2.left.val)
                    || (node1.right == null && node2.left == null)
                    || (node1.left == null && node2.right == null)) {
                continue;
            } else {
                return false;
            }
        }
        for (TreeNode node : layerItemList) {
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return true;
    }

    /**
     * 递归的操作没有抽象出来，
     * left right 以及对应的左右孩子的比较
     *
     * @param root
     * @return
     */
    public boolean isSymmetric_Study(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) & recur(L.right, R.left);
    }

}
