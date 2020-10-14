package pers.captain.algorithm.sep.bit;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数组中一个数只出现一次，其他都出现三次，找出出现一次的那个数，时间复杂度 O(N) 空间复杂度 O(N)
 */
public class AppearOnceOtherThreeTimes {


    public int findOnce(int[] array) {
        if (array == null || array.length == 0) throw new IllegalArgumentException("array is null or empty");
        int result = 0;
        for (int b = 0; b < 32; b++) {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {

                sum += (array[i] >> b) & 1;
            }
            result += (sum % 3) << b;
        }
        return result;
    }

    @Test
    public void findOnce() {

        int[]array = new int[]{2,2,2,3,44,44,44,66,66,66};
        int result = findOnce(array);
        Assert.assertEquals(result,3);
    }
}
