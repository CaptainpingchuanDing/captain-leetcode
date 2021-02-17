package pers.captain.algorithm.offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目描述
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * 示例1
 * 输入
 * <p>
 * 10
 * 返回值
 * <p>
 * 2
 */
public class NO11NumberOf1 {
    /**
     * 准备知识， 把正数 按位 & | ^
     * 右移>>  左移 <<   无符号右移 >>>
     * <p>
     * n & (n - 1) 可以去除n的一个二进制中的一个 "1"
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 循环32次，把每一个二进制都算一遍（注意无符号右移）
     *
     * @param n
     * @return
     */
    public int NumberOf1_2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

    /**
     * 方法三： 转为二进制字符串,把二进制"0"替换为""，字符串的长度就是二进制"1"的个数
     *
     * @param n
     * @return
     */
    public int NumberOf1_3(int n) {
        return Integer.toBinaryString(n).replace("0", "").length();
    }

    @Test
    public void NumberOf1() {
        int count = NumberOf1(8);
        Assert.assertEquals(1, count);
    }

    @Test
    public void NumberOf1_2() {
        int count = NumberOf1_2(8);
        Assert.assertEquals(1, count);
    }
}

