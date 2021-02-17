package pers.captain.algorithm.offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 示例1
 * 输入
 * 复制
 * [3,4,5,1,2]
 * 返回值
 * <p>
 * 1
 */
public class NO6MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * 找旋转数组的拐点
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray2(int[] array) {
        //todo
//        if (array == null || array.length == 0) return 0;
//        int left = 0;
//        int right = array.length - 1;
//        //[3,4,5,1,2]
//        while (left + 1 < right) {
//            int mid = left + (right - left) / 2;
//            if (array[mid - 1] > array[mid] && array[mid] < array[mid + 1]) {
//                return array[mid];
//            } else if (array[left] < array[mid] && array[mid - 1] < array[mid]) {
//                left = mid;
//            } else {
//                right = mid;
//            }
//        }
//        return Math.min(array[left], array[right]);
        if (array == null || array.length == 0) return 0;
        int left = 0;
        int right = array.length - 1;
        int mid = right / 2;
        // [3,4,5,1,2]
        while (right != mid && left != mid) {
            if (array[left] > array[mid]) {
                right = mid;
            } else {
                left = mid;
            }
            mid = (left + right) / 2;
        }
        return array[right];
    }

    @Test
    public void test() {
        int[] array = new int[]{3,4,4,1,1,2};
        int res = minNumberInRotateArray2(array);
        Assert.assertEquals(res, 1);
    }
}
