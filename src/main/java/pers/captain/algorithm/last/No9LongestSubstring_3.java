package pers.captain.algorithm.last;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class No9LongestSubstring_3 {

    /**
     * 1. 循环遍历每一个字符，记录每一个字符开始的无重复字符串的长度。
     * 2. 选出最大的。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {

        // 1. 循环整个字符串
        // 2. 用一个指针扫描, 用一个map去记录当前字符串不重复的字符。当向前遍历一个字符串时，不在增加则进行下一个外层循环
        int max = 0;
        Set<Character> subStringList = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            int tempMax = 0;
            for (int j = i; j < s.length(); j++) {
                int subStringSize = subStringList.size();
                if (subStringSize == 0) {
                    subStringList.add(s.charAt(j));
                    tempMax++;
                } else {
                    if (subStringList.contains(s.charAt(j))) {
                        tempMax = subStringSize; //寻找更大
                        j = s.length();// 结束内存循环
                        subStringList.clear();
                    } else {
                        subStringList.add(s.charAt(j));
                        subStringSize++;
                        if (j == s.length() - 1) {
                            tempMax = subStringSize;
                            j = s.length();
                            i = s.length();
                        }
                    }
                }
            }
            if (max < tempMax) {
                max = tempMax;
            }

        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {

        int max = 0;
        Set<Character> subStringList = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            int rightD = 0;
            while (i + rightD < s.length()) {
                if (subStringList.contains(s.charAt(i + rightD))) {
                    if (s.charAt(i + rightD) == s.charAt(i + rightD - 1)) {
                        i = i + rightD - 1;
                    }
                    break;
                } else {
                    subStringList.add(s.charAt(i + rightD));
                }
                rightD++;
            }
            if (max < subStringList.size()) {
                max = subStringList.size();
            }
            subStringList.clear();
        }
        return max;
    }


    /**
     * 通过一个128长度的boolean数组来记录出现的字符，使用两个指针。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {

        if (s == null || s.length() == 0) return 0;
        int max = 0;
        int left = 0;
        int right = 0;
        boolean[] used = new boolean[128];
        while (right < s.length()) {
            if (used[s.charAt(right)]) {
                max = Math.max(max, right - left);
                while (left < right && s.charAt(left) != s.charAt(right)) {
                    used[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            } else {
                used[s.charAt(right)] = true;
                right++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }

    @Test
    public void lengthOfLongestSubstring3() {
        int result = lengthOfLongestSubstring3("absdba");
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring1("au"));
        System.out.println(lengthOfLongestSubstring2("au"));
        System.out.println(lengthOfLongestSubstring2("vvvv"));
        System.out.println(lengthOfLongestSubstring2("wereeww"));
        System.out.println(lengthOfLongestSubstring3("wereeww"));
    }

    public static int lengthOfLongestSubstringTest(String s) {

        int max = 0;
        if (s == null || s.length() == 0) return max;
        boolean[] used = new boolean[128];
        int right = 0;
        int left = 0;
        while (right < s.length()) {
            if (used[s.charAt(right)]) {
                max = Math.max(max, right - left);
                while (left < right && s.charAt(left) != s.charAt(right)) {
                    used[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            } else {
                used[s.charAt(right)] = true;
                right++;
            }
        }
        max = Math.max(max, right - left);

        return max;
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        int result = lengthOfLongestSubTest2("abcabcbb");
        Assert.assertTrue(result == 3);
    }

    public static int lengthOfLongestSubTest2(String s) {

        if (s == null || s.length() == 0) return 0;
        int max = 0;
        int right = 0;
        int left = 0;
        boolean[] used = new boolean[128];
        while (right < s.length()) {

            if (used[s.charAt(right)]) {
                max = Math.max(max, right - left);
                while (left < right && s.charAt(right) != s.charAt(left)) {
                    used[left] = false;
                    left++;
                }
                left++;
                right++;
            } else {
                while (right < s.length() && !used[s.charAt(right)]) {
                    used[s.charAt(right)] = true;
                    right++;
                }
            }
        }
        return Math.max(max, right - left);
    }


}
