package pers.captain.algorithm.tto.feb;

import org.junit.Assert;
import org.junit.Test;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NthUglyNumber {

    /**
     * 方法一 、暴力方法
     *  todo
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n <= 6) return n;
        int num = 7;
        for (int i = 7; i <= n; i++) {
            if (isUgly(num)) {
                num++;
                continue;
            }
            while (!isUgly(num)) {
                num++;
            }
        }
        return num;
    }

    private boolean isUgly(int n) {
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        if (n == 1) return true;
        return false;

    }

    @Test
    public void nthUglyNumber() {
        int result = nthUglyNumber(10);
        Assert.assertEquals(result, 12);
    }
}
