package pers.captain.algorithm.summary.tree.depth;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。(即左右孩子都没有 node.left==null && node.right==null)
 */
public class TreeMinDepth {

    /**
     * 递归 DFS   注意和最大最大深度区别
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int x = minDepth(root.left);
        int y = minDepth(root.right);
        if (root.left == null && root.right == null) return 1;
        if (root.left != null && root.right != null) return Math.min(x, y) + 1;
        return x + y + 1;// 左节点或者右节点为空（为空时深度为0，所以x或者y其中一个为零）
    }

    /**
     * 方法二 BFS
     * 和数的层次遍历的迭代方式类似，多了一个到达叶子节点的判断
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            minDepth++;//深度加一
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                //和最大深度的BFS区别之处
                if (node.left == null && node.right == null) return minDepth;//达到一个叶子节点,退出
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
        }
        return minDepth;
    }
}
