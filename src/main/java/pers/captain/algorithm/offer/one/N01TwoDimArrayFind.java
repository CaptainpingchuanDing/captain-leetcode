package pers.captain.algorithm.offer.one;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例1
 * 输入
 * 复制
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值
 * 复制
 * true
 */
public class N01TwoDimArrayFind {
    /**
     * solution1
     * time O(m*lgn)   space O(1)
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        // 行 和 列都要判断长度
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] <= target && array[i][array[0].length - 1] >= target &&
                    binarySearch(array[i], target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    @Test
    public void find() {
        int[] array1 = new int[]{1, 2, 8, 9};
        int[] array2 = new int[]{2, 4, 9, 12};
        int[] array3 = new int[]{4, 7, 10, 13};
        int[] array4 = new int[]{6, 8, 11, 15};
        int[][] array = new int[4][4];
        array[0] = array1;
        array[1] = array2;
        array[2] = array3;
        array[3] = array4;
        boolean res = Find(7, array);
        Assert.assertTrue(res);
    }

    /**
     * solution2
     * time O(m+n)   space O(1)
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find2(int target, int[][] array) {
        // 行 和 列都要判断长度
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        int row = array.length - 1;
        int col = 0;
        //从左下角开始
        while (col < array[0].length && row >= 0) {
            if(target == array[row][col]){
                return true;
            }else if(target > array[row][col]){
                col++;
            }else{
                row--;
            }
        }
        return false;
    }

    @Test
    public void find2() {
        int[] array1 = new int[]{1, 2, 8, 9};
        int[] array2 = new int[]{2, 4, 9, 12};
        int[] array3 = new int[]{4, 7, 10, 13};
        int[] array4 = new int[]{6, 8, 11, 15};
        int[][] array = new int[4][4];
        array[0] = array1;
        array[1] = array2;
        array[2] = array3;
        array[3] = array4;
        boolean res = Find2(7, array);
        Assert.assertTrue(res);
    }
}
