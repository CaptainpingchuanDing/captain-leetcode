package pers.captain.algorithm.offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * <p>
 * 保证base和exponent不同时为0
 * 示例1
 * 输入
 * <p>
 * 2,3
 * 返回值
 * <p>
 * 8.00000
 */
public class NO12Power {

    /**
     * 首先把exponent 的负数问题解决
     * base ^ exp
     * f(exp) = f(exp/2)^2 , if exp%2==0
     * f(exp) = f(exp/2)^2 * base, if exp%2==1
     * <p>
     * 方法一： 自顶向下
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (base == 0) return 0;
        if (exponent < 0) return 1 / Power(base, -exponent);
        int exp = exponent / 2;
        double num = Power(base, exp);
        if (exponent % 2 == 0) {
            return num * num;
        } else {
            return num * num * base;
        }
    }

    @Test
    public void Power() {
        double res = Power(2, 3);
        Assert.assertEquals(8, res);
    }
}
