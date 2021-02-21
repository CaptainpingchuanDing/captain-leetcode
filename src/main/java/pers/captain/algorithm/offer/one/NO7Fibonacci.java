package pers.captain.algorithm.offer.one;

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n\leq 39n≤39
 * <p>
 * 示例1
 * 输入
 * <p>
 * 4
 * 返回值
 * <p>
 * 3
 */
public class NO7Fibonacci {

    /**
     * 方法一  递归
     *
     * @param n
     * @return
     */
    public int Fibonacci1(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }

    /**
     * 方法二   动态规划
     *
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        if (n <= 1) return n;
        int p1 = 1, p2 = 0, res = 0;
        for (int i = 2; i <= n; i++) {
            res = p1 + p2;
            p2 = p1;
            p1 = res;
        }
        return res;
    }
}
