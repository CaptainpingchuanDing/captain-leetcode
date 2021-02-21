package pers.captain.algorithm.offer.two;

import org.junit.Test;
import pers.captain.algorithm.CapL;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分
 * ，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class NO13ReOrderArray {

    /**
     * 方法一： in place
     * time O(n^2) space O(1)
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 1) return;
        // [2, 3, 4, 5, 6]
        int p = 0;// p 表示最左边的偶数
        while (p < array.length - 1 && array[p] % 2 == 1) {
            p++;
        }
        if (p == array.length - 1) return;
        for (int i = p; i < array.length; i++) {
            if (array[i] % 2 == 1) {// array[i] 为奇数
                helper(array, p, i);
                p++;
            }
        }
    }

    private void helper(int[] array, int start, int end) {
        if (end == start) return;
        for (int i = end - 1; i >= start; i--) {
            int tem = array[i];
            array[i] = array[i + 1];
            array[i + 1] = tem;
        }
    }

    /**
     * 方法二： 借助辅助空间
     * time O(n) space O(n)
     * @param array
     */
    public void reOrderArray2(int[] array) {
        //2 3 6 1 4
        if (array == null || array.length == 0)
            return;
        int[] jishu = new int[array.length];
        int jishuIndex = 0;
        int[] oushu = new int[array.length];
        int oushuIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                jishu[jishuIndex] = array[i];
                jishuIndex++;
            } else {
                oushu[oushuIndex] = array[i];
                oushuIndex++;
            }
        }
        for (int j = 0; j < jishuIndex; j++) {
            array[j] = jishu[j];
        }
        for (int k = jishuIndex; k < array.length; k++) {
            array[k] = oushu[k - jishuIndex];
        }
    }

    @Test
    public void reOrderArray() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        reOrderArray(array);
        CapL.print(array);
    }
}
