package pers.captain.algorithm.August;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 * <p>
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 * <p>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 * <p>
 * 同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。
 * <p>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 * <p>
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/scramble-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ScrambleString_87 {

    /**
     * 分治的思想
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;

        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        // 判断两个字符串的元素是否一样
        Arrays.sort(array1);
        Arrays.sort(array2);
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            // s1左节点和s2左节点match  s1右节点和s2右节点match
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i, s1.length()), s2.substring(i, s1.length()))) {
                return true;
            }
            // s1左节点和s2右节点match  s1左节点和s2右节点match
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i, s2.length()))
                    && isScramble(s1.substring(i, s1.length()), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void isScramble() {
        String s1 = "abcde";
        String s2 = "caebd";
        Assert.assertFalse(isScramble(s1, s2));


        s1 = "great";
        s2 = "rgeat";
        Assert.assertTrue(isScramble(s1, s2));


    }

    @Test
    public void isScrambleBad() {
        String s1 = "abb";
        String s2 = "bba";
        Assert.assertTrue(isScramble(s1, s2));


    }
}
