package pers.captain.algorithm.last;

/**
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class No8SumOfTwoIntegers {

    /**
     * 1. 两个都是正数，整数 4个字节，32bit位。
     * 2. 两个数同时向右移动一位，异或为个位，add且不为 1结果为零 十位为1否则为0
     */
    public static int getSum(int a, int b) {

        if (b == 0) {
            return a;
        }
        b = getSum(a ^ b, (a & b) << 1);
        return b;
    }


    public static void main(String[] args) {
       System.out.println( getSum(-2,3));
    }
}
