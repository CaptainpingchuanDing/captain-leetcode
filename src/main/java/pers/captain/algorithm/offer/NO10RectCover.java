package pers.captain.algorithm.offer;

/**
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * <p>
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 */
public class NO10RectCover {

    /**
     * target = 1, 1;
     * = 2, 2;
     * = 3, 3;
     * f(n) = f(n-1) + f(n-2) 与斐波那切数列类似
     * <p>
     * 方法一 递归
     *
     * @param target
     * @return
     */
    public int rectCover(int target) {
        if (target <= 3) return target;
        return rectCover(target - 1) + rectCover(target - 2);
    }

    /**
     * 方法二 动态规划
     *
     * @param target
     * @return
     */
    public int rectCover2(int target) {
        if (target <= 3) return target;
        int p1 = 2, p2 = 3, res = 0;
        for (int i = 4; i <= target; i++) {
            res = p1 + p2;
            p1 = p2;
            p2 = res;
        }
        return res;
    }
}
