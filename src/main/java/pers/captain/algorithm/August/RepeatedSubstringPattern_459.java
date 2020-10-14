package pers.captain.algorithm.August;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: "aba"
 * <p>
 * 输出: False
 * 示例 3:
 * <p>
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RepeatedSubstringPattern_459 {


    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1) return false;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                String pattern = s.substring(0, i);
                if (isPattern(pattern, s.substring(i))) {
                    return true;
                }
            } else {
                set.add(s.charAt(i));
            }
        }
        return false;
    }

    private static boolean isPattern(String pattern, String subStr) {
        if (subStr == null || subStr.length() == 0 || subStr.length() % pattern.length() != 0)
            return false;
        if (pattern.equals(subStr)) return true;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != subStr.charAt(i)) {
                return false;
            }
        }
        return isPattern(pattern, subStr.substring(pattern.length()));
    }

    @Test
    public void repeatedSubstringPattern() {
        String s = "abcabcabcabc";
        boolean result = repeatedSubstringPattern(s);
        Assert.assertTrue(result);
    }
}

