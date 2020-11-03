package pers.captain.algorithm.October.tree.traverse;

import org.junit.Assert;
import org.junit.Test;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * <p>
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    @Test
    public void verifyPostorder() {
        int[] postorder = new int[]{1, 3, 2, 6, 5};
        boolean ret = verifyPostorder(postorder);
        Assert.assertTrue(ret);
    }

    /**
     * DFS 的方式
     */
    public boolean verifyPostorder_E(int[] postorder) {
        return recur_E(postorder, 0, postorder.length - 1);
    }

    /**
     * 根据后续遍历的性质，最右边的是根节点，既postorder[right]为根节点
     */
    private boolean recur_E(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int p = left;
        // 找到第一个不小于 根节点（postorder[right]）的位置 mid
        while (postorder[p] < postorder[right]) p++;
        int mid = p;
        // 确认之后的元素都大于根节点（postorder[right]）
        while (postorder[p] > postorder[right]) p++;
        if (p != right) return false;
        // 判断左子树是否是后续遍历
        boolean leftTreeRe = recur_E(postorder, left, mid - 1);
        if (!leftTreeRe) return false;
        // 判断右子树是否是后续遍历
        return recur_E(postorder, mid, right - 1);
    }

    @Test
    public void verifyPostorder_E() {
        int[] postorder = new int[]{1, 3, 2, 6, 5};
        boolean ret = verifyPostorder_E(postorder);
        Assert.assertTrue(ret);
    }

}
