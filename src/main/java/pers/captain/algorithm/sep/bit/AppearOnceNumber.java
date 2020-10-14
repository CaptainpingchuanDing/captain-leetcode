package pers.captain.algorithm.sep.bit;

import org.junit.Assert;
import org.junit.Test;

/**
 * *数组中一个数只出现一次，其他都出现两次次，找出出现一次的那个数，时间复杂度 O(N) 空间复杂度 O(N)
 */
public class AppearOnceNumber {

    public int findOnceNumber(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("nums is null or empty");
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    @Test
    public void findOnceNumber() {
        int[] array = new int[]{2, 2, 3, 44, 44,  66, 66};
        int result = findOnceNumber(array);
        Assert.assertEquals(result, 3);

    }
}
