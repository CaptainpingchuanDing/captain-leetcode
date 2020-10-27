package pers.captain.algorithm.October;

import org.junit.Test;
import pers.captain.algorithm.CapL;
import pers.captain.algorithm.structrue.TreeNode;

public class MinDepth {

    /**
     *  badcase  [2,null,3,null,4,null,5,null,6]   output 5
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        if (left == 0) return 1;
        int right = minDepth(root.right);

        return Math.min(left, right) + 1;
    }

    @Test
    public void minDepth() {
        TreeNode head = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        head.right = treeNode2;
        treeNode2.right = treeNode3;
        treeNode3.right = treeNode4;
        treeNode4.right = treeNode5;
        int depth = minDepthS(head);
        CapL.print(depth);
    }

    public int minDepthS(TreeNode root) {
        if (root == null) return 0;
        //这道题递归条件里分为三种情况
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if (root.left == null && root.right == null) return 1;
        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepthS(root.left);
        int m2 = minDepthS(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if (root.left == null || root.right == null) return m1 + m2 + 1;

        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1, m2) + 1;
    }

}


