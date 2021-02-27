package pers.captain.algorithm.offer.three;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。
 * 示例1
 * 输入
 * <p>
 * [4,8,6,12,16,14,10]
 * 返回值
 * <p>
 * true
 */
public class NO23VerifySquenceOfBST {
    /**
     * 方法一: 分治思想  思路：找住二叉查找树的特点：左子树<根<=右子树
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        // 左 右前
        if (sequence == null || sequence.length < 1) return false;
        return isBST(sequence, 0, sequence.length - 1);
    }

    private boolean isBST(int[] sequence, int start, int end) {
        if (end - start < 2) return true;
        int left = start;
        for (; left < end; left++) {
            if (sequence[left] > sequence[end]) break;
        }
        for (int i = left; i < end; i++) {// 右边的要比"根节点"小，否者不是后续遍历
            if (sequence[i] < sequence[end]) return false;
        }
        return isBST(sequence, start, left - 1) & isBST(sequence, left, end - 1);
    }
}
