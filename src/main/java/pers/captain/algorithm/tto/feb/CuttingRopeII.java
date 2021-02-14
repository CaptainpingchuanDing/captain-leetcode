package pers.captain.algorithm.tto.feb;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CuttingRopeII {

    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3;
        int a = n / 3;
        int p = 1000000007;
        long result = 0;
        // 3^(a-1)
        if (b == 1) {
            result = remainder(3, a - 1, p);
            result = result * 4 % p;
        } else {
            result = remainder(3, a, p);
            if (b == 0) result = result % p;
            if (b == 2) result = result * 2 % p;
        }

        return (int) result;
    }

    private long remainder(int x, int a, int p) {
        long rem = 1;
        for (int i = 0; i < a; i++) {
            rem = (rem * x) % p;
        }
        return rem;

    }

    @Test
    public void cuttingRope() {
        int res = cuttingRope(120);
        Assert.assertEquals(res, 953271190);
    }
}
