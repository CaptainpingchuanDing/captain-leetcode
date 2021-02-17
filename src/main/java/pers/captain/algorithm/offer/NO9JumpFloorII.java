package pers.captain.algorithm.offer;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 示例1
 * 输入
 * <p>
 * 3
 * 返回值
 * <p>
 * 4
 */
public class NO9JumpFloorII {
    /**
     * 这道题目和 JumpFloor 不一样，这个题目 青蛙可以一次跳 n级
     * target = 1 , 1
     * target = 2 , 2
     * target = 3 , 4
     * target = 4 , 8
     * f(n) = f(n-1) + f(n-2)+...+f(1)+ 1
     * f(n+1) = f(n) + f(n-1)+...+ f(1)+1
     * 两式相减得: f(n+1)-f(n) = f(n)
     * 整理得 f(n+1) = 2* f(n);
     */
    public int JumpFloorII(int target) {
        int sum = 1;
        for (int i = 2; i <= target; i++) {
            sum = sum << 1;
        }
        return sum;
    }

}
