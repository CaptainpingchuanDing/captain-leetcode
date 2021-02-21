package pers.captain.algorithm.offer.four;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目描述
 * 统计一个数字在升序数组中出现的次数。
 * 示例1
 * 输入
 * <p>
 * [1,2,3,3,3,3,4,5],3
 * 返回值
 * <p>
 * 4
 */
public class NO37GetNumberOfK {

    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) return 0;
        int left = findFirst(array, k);
        if (left == -1) return 0;
        int right = findEnd(array, k);
        return right - left + 1;
    }

    private int findFirst(int[] array, int k) {
        int start = 0, end = array.length - 1;
        while (end > start + 1) {
            int mid = start + (end - start) / 2;
            if (array[mid] == k) {
                end = mid;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (array[start] == k) return start;
        if (array[end] == k) return end;
        return -1;
    }

    private int findEnd(int[] array, int k) {
        int start = 0, end = array.length - 1;
        while (end > start + 1) {
            int mid = start + (end - start) / 2;
            if (array[mid] == k) {
                start = mid;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (array[start] == k) return end;
        if (array[end] == k) return start;
        return -1;
    }

    @Test
    public void GetNumberOfK() {
        int[] array = new int[]{1,2,3,3,3,3};
//        int size = GetNumberOfK(array, 3);
//        Assert.assertEquals(size, 4);

        int size = GetNumberOfK(array, 3);
        Assert.assertEquals(size, 4);
    }
}
