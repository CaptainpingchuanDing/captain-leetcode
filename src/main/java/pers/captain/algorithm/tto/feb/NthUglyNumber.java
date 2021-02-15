package pers.captain.algorithm.tto.feb;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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
     * todo
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n <= 6) return n;
        int num = 7;
        int nth = 6;
        while (nth < n) {
            while (isUgly(num)) {
                if (nth + 1 < n) {
                    num++;
                } else {
                    nth++;
                    break;
                }
                nth++;
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
        int result = nthUglyNumber(7);
        Assert.assertEquals(result, 8);
    }

    /**
     * 方法二 、辅助记忆
     * todo
     *
     * @param n
     * @return
     */
    public int nthUglyNumber2(int n) {
        if (n <= 6) return n;
        int num = 7;
        int nth = 6;
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        while (nth < n) {
            while (isUgly2(num, set)) {
                if (nth + 1 < n) {
                    num++;
                } else {
                    nth++;
                    break;
                }
                nth++;
            }
            while (!isUgly2(num, set)) {
                num++;
            }
        }
        return num;
    }

    private boolean isUgly2(int n, Set<Integer> set) {
        if (set.contains(n)) {
            return true;
        }
        while (n % 2 == 0) {
            n = n / 2;
            if (set.contains(n)) {
                return true;
            }
        }
        while (n % 3 == 0) {
            n = n / 3;
            if (set.contains(n)) {
                return true;
            }
        }
        while (n % 5 == 0) {
            n = n / 5;
            if (set.contains(n)) {
                return true;
            }
        }
        if (n == 1) {
            set.add(n);
            return true;
        }
        return false;

    }

    @Test
    public void nthUglyNumber2() {
        int result = nthUglyNumber2(7);
        Assert.assertEquals(result, 8);
    }

    public int nthUglyNumber_better(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    public int nthUglyNumber_better_E(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }


    /**
     * // 一个十分巧妙的动态规划问题
     *     // 1.我们将前面求得的丑数记录下来，后面的丑数就是前面的丑数*2，*3，*5
     *     // 2.但是问题来了，我怎么确定已知前面k-1个丑数，我怎么确定第k个丑数呢
     *     // 3.采取用三个指针的方法，p2,p3,p5
     *     // 4.index2指向的数字下一次永远*2，p3指向的数字下一次永远*3，p5指向的数字永远*5
     *     // 5.我们从2*p2 3*p3 5*p5选取最小的一个数字，作为第k个丑数
     *     // 6.如果第K个丑数==2*p2，也就是说前面0-p2个丑数*2不可能产生比第K个丑数更大的丑数了，所以p2++
     *     // 7.p3,p5同理
     *     // 8.返回第n个丑数
     *
     * @param n
     * @return
     */
    public int nthUglyNumber_better_E_2(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i]==n2) a++;
            if(dp[i]==n3) b++;
            if(dp[i]==n5) c++;
        }
        return dp[n - 1];
    }
}
