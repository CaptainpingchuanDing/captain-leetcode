package pers.captain.algorithm.sep;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 * <p>
 * 给定数字的范围是 [0, 108]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSwap {

    public int maximumSwap(int num) {
        int max = -1;
        int maxBit = 0;
        int min = -1;
        int minBit = 0;

        if (num <= 11) return num;
        String numStr = num + "";
        boolean flag = false;
        for (int i = numStr.length() - 2; i >= 0; i--) {
            if (flag) {
                if (numStr.charAt(i) <= numStr.charAt(i + 1)) {
                    if (numStr.charAt(i + 1) >= max) {
                        max = numStr.charAt(i + 1);
                        maxBit = numStr.length() - (i + 1);
                    }

                }
                if (numStr.charAt(i) <= min) {
                    min = numStr.charAt(i);
                    minBit = numStr.length() - i;
                }
            } else {
                if (numStr.charAt(i) < numStr.charAt(i + 1)) {
                    max = numStr.charAt(i + 1);
                    maxBit = numStr.length() - (i + 1);
                    min = numStr.charAt(i);
                    minBit = maxBit + 1;
                    flag = true;
                }
            }

        }
        if (max == -1) return num;
        num += (max - min) * Math.pow(10, minBit - 1);
        num -= (max - min) * Math.pow(10, maxBit - 1);
        return num;
    }


    @Test
    public void maximumSwap() {
        int result = maximumSwap(8897);
        int result1 = maximumSwap(897);
        int result2 = maximumSwap(1993);
        Assert.assertEquals(987, result1);
        Assert.assertEquals(9887, result);
        Assert.assertEquals(9913, result2);
    }

    public int maximumSwap1(int num) {
        int max = -1;
        int maxBit = 0;
        int min = -1;
        int minBit = 0;

        if (num <= 11) return num;
        String numStr = num + "";
        boolean flag = false;
        for (int i = numStr.length() - 2; i >= 0; i--) {
            if (numStr.charAt(i) < numStr.charAt(i + 1) && max< numStr.charAt(i + 1)) {
                max = numStr.charAt(i + 1);
                maxBit = numStr.length() - (i + 1);
                min = numStr.charAt(i);
                minBit = maxBit + 1;
                flag = true;
                int j = i;
                while (j + 2 < numStr.length() && numStr.charAt(j + 1) == numStr.charAt(j + 2)) {
                    maxBit--;
                    j++;
                }
            }
            if (flag && numStr.charAt(i) < max) {
                min = numStr.charAt(i);
                minBit = numStr.length() - i;
            }
        }

        if (max == -1) return num;
        num += (max - min) * Math.pow(10, minBit - 1);
        num -= (max - min) * Math.pow(10, maxBit - 1);
        return num;
    }

    @Test
    public void maximumSwa1() {
        int result = maximumSwap1(8897);
        int result1 = maximumSwap1(897);
        int result2 = maximumSwap1(1993);
        int result3 = maximumSwap1(98368);
        int result4 = maximumSwap1(22341345);
        Assert.assertEquals(987, result1);
        Assert.assertEquals(9887, result);
        Assert.assertEquals(9913, result2);
        Assert.assertEquals(98863, result3);
        Assert.assertEquals(52341342, result4);
    }


}
