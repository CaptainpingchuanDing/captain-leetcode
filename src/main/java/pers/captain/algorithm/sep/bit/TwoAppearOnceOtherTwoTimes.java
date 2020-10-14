package pers.captain.algorithm.sep.bit;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个数组中，只有两个数出现一次，其他都出现两次，找出这两个数
 */
public class TwoAppearOnceOtherTwoTimes {
    public List<Integer> findTwoAppearOnce(int[] array) {
        List<Integer> result = new ArrayList<>();
        // 所有元素异或一遍
        int temp = 0;
        for (int num : array) {
            temp = temp ^ num;
        }
        int bitCount = 0;
        while ((temp & (1 << bitCount)) == 0 && bitCount < 32) {
            bitCount++;
        }
        temp = temp & (1 << bitCount);

        int num1 = 0;
        int num2 = 0;
        for (int num : array) {
            if ((temp & num) == 0) {
                num1 = num1 ^ num;
            } else {
                num2 = num2 ^ num;
            }
        }
        result.add(num1);
        result.add(num2);
        return result;
    }

    @Test
    public void findTwoAppearOnce(){
        int[]array = new int[]{2,2,3,44,66,66};
        List<Integer> result = findTwoAppearOnce(array);
        System.out.println(result);
//        Assert.assertEquals(result,3);
    }
}
