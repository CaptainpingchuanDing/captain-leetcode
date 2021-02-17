package pers.captain.algorithm.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 示例1
 * 输入
 * <p>
 * 1
 * 返回值
 * <p>
 * 1
 * 示例2
 * 输入
 * <p>
 * 4
 * 返回值
 * <p>
 * 5
 */
public class NO8JumpFloor {
    /**
     *  target = 0   res = 0
     *  target = 1   res = 1
     *  target = 2   res = 2
     *  target = 3   res = 3
     *
     *  f(i) = f(i-1) + f(i-2)
     */

    /**
     * 方法一 递归
     *
     * time 2^n   space 栈的空间
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target <= 2) return target;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    /**
     * 方法二 动态规划
     * time O(n) space O(1)
     * @param target
     * @return
     */
    public int JumpFloor2(int target) {
        if (target <= 2) return target;
        int p1 = 1, p2 = 2, res = 0;
        for (int i = 3; i <= target; i++) {
            res = p1 + p2;
            p1 = p2;
            p2 = res;
        }
        return res;
    }
}
