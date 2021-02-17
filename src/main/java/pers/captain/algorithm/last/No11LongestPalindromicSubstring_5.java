package pers.captain.algorithm.last;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 知识点： 回文串（palindromic string）是指这个字符串无论从左读还是从右读，所读的顺序是一样的；
 * 简而言之，回文串是左右对称的。所谓最长回文子串问题，是指对于一个给定的母串
 */
public class No11LongestPalindromicSubstring_5 {

    /**
     * 每个子字符串都判定一下是不是回文子串
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int maxLength = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindromicSubstring(i, j, s)) {
                    int temp = j - i + 1;
                    if (temp > maxLength) {
                        maxLength = temp;
                        maxStart = i;
                        maxEnd = j;
                    }
                }
            }
        }
        if (maxEnd == s.length() - 1) {
            return s.substring(maxStart);
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    private static boolean isPalindromicSubstring(int start, int end, String s) {
        while (end - start >= 0) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    /*
    动态规划法
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        boolean[][] P = new boolean[s.length()][s.length()];
        String maxPal = "";
        for (int len = 1; len <= s.length(); len++) {
            for (int start = 0; start < s.length(); start++) {
                int end = start + len - 1;
                if (end >= s.length()) {
                    break;
                }
                if (len == 1 || len == 2) {
                    P[start][end] = s.charAt(start) == s.charAt(end);
                } else {
                    P[start][end] = (s.charAt(start) == s.charAt(end)) && P[start + 1][end - 1];
                }

                if (P[start][end]) {
                    maxPal = s.substring(start, end + 1);
                }

            }
        }

        return maxPal;
    }

    /**
     * 扩展中心法
     * <p>
     * 我们知道回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可。
     * <p>
     * 由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，或者从两个字符之间开始扩展，所以总共有 n+n-1 个中心。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome2("cbbd"));
        System.out.println(longestPalindrome3("cbbd"));
        System.out.println("babad".substring(0, 3));
        System.out.println("babad".substring(1));
    }

    public String longestPalindrome_E(String s) {
        if (s == null || s.length() == 0) return "";
        int maxL = 1;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 1; i < s.length(); i++) {
            if (maxL >= i + 1) continue;
            for (int j = 0; j < i; j++) {
                if (maxL >= (i - j + 1)) {
                   break;
                }
                if (isPalindrome_E(s, j, i)) {
                    if ((i - j + 1) > maxL) {
                        maxL = i - j + 1;
                        maxStart = j;
                        maxEnd = i;
                    }
                    break;
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }


    private boolean isPalindrome_E(String s, int start, int end) {
        while (end > start) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    @Test
    public void longestPalindrome_E() {
        String s = longestPalindrome_E("babad");
        Assert.assertEquals(s, "bab");
    }


}
