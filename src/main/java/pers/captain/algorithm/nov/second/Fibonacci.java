package pers.captain.algorithm.nov.second;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 */
public class Fibonacci {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int m = 0, k = 1, sum = 0;
        for (int i = 1; i < n; i++) {
            sum = (m + k) % 1000000007;
            m = k;
            k = sum;
        }
        return sum;
    }

    public int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fib1(n - 1) + fib1(n - 2);
    }
}
