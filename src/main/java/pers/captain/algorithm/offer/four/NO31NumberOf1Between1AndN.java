package pers.captain.algorithm.offer.four;

/**
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * 示例1
 * 输入
 * <p>
 * 13
 * 返回值
 * <p>
 * 6
 */
public class NO31NumberOf1Between1AndN {
    /**
     * 0-n 的第 i 位num[i] 出现1 的所有数设为 sum[i]
     * high  low  cur
     * <p>
     * 1.num[i] = 0 时，例如 2203
     * 0010-2119, 只看高低位   000-219   sum[i] = 219-000+1 = 220 = high * 10^i;
     * 2.num[i] = 1时，例如 2312
     * 0010-2312， 只看高低位 000-232， sum[i] = 232-000+1 = 233 = high*10^i + low + 1
     * 3.num[i] = 2-9 时， 例如 2332
     * 0010-2319， 只看高低位 000-239 ,sum[i] = 239-000+1 = 240 = (high+1) * 10^i;
     * <p>
     * 初始化
     * high = n/10;
     * low = 0;
     * i = 1;
     * digit = 1;
     * 迭代
     * digit = digit*10;
     * high = high/digit;
     * low = n%digit
     *
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) return 0;
        int digit = 1, high = n / 10, low = 0, cur = n % 10;
        int res = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;

            low = cur * digit + low;
            cur = high % 10;
            digit *= 10;
            high = high / 10;
        }
        return res;
    }
}
