package pers.captain.algorithm.August;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 *  
 * <p>
 * 提示：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumWindowSubstring_76 {

    /**
     * use space to reduce time cost
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        //1. record char times
        int[] tCharCount = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tCharCount[t.charAt(i)]++;
        }
        String minSubStr = "";
        // record match char of string t times
        int count = 0;
        // record string s char times where search range
        int[] sCharCount = new int[256];

        int tempFirstIndex = findNextFirst(tCharCount, s, 0);
        if (tempFirstIndex == -1) return "";
        for (int i = tempFirstIndex; i < s.length(); i++) {
            if (tCharCount[s.charAt(i)] > 0) {
                sCharCount[s.charAt(i)]++;
                if (sCharCount[s.charAt(i)] <= tCharCount[s.charAt(i)]) {
                    count++;
                }
                // 找到一组
                while (count == t.length()) {
                    if (minSubStr.length() == 0 || minSubStr.length() > (i - tempFirstIndex + 1)) {
                        minSubStr = s.substring(tempFirstIndex, i + 1);
                    }
                    sCharCount[s.charAt(tempFirstIndex)]--;
                    if (sCharCount[s.charAt(tempFirstIndex)] < tCharCount[s.charAt(tempFirstIndex)]) {
                        count--;
                    }
                    tempFirstIndex = findNextFirst(tCharCount, s, tempFirstIndex + 1);
                    if (tempFirstIndex == -1) {
                        break;
                    }
                }
            }
        }

        return minSubStr;
    }

    @Test
    public void minWindow() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println(result);
    }

    private static int findNextFirst(int[] tCharCount, String s, int start) {
        int result = -1;

        while (start < s.length()) {
            if (tCharCount[s.charAt(start)] > 0) {
                result = start;
                break;
            }
            start++;
        }
        return result;
    }

    public static String minWindow1(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        //1. record char times
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            add(tMap, t.charAt(i), 1);
        }
        String minSubStr = "";
        // record match char of string t times
        int count = 0;
        // record string s char times where search range
        Map<Character, Integer> sMap = new HashMap<>();
        int tempFirstIndex = findNextFirst(tMap, s, 0);
        if (tempFirstIndex == -1) return "";
        for (int i = tempFirstIndex; i < s.length(); i++) {
            int tCharC = get(tMap, s.charAt(i));
            if (tCharC > 0) {
                add(sMap, s.charAt(i), 1);
                if (sMap.get(s.charAt(i)) <= tCharC) count++;
                // 找到一组

                if (count == t.length()) {
                    if (minSubStr.length() == 0 || minSubStr.length() > (i - tempFirstIndex + 1)) {
                        minSubStr = s.substring(tempFirstIndex, i + 1);
                    }
                    add(sMap, s.charAt(tempFirstIndex), -1);
                    count--;
                    tempFirstIndex = findNextFirst(tMap, s, tempFirstIndex + 1);
                    if (tempFirstIndex == -1) break;
                }
            }
        }
        return minSubStr;
    }

    @Test
    public void minWindow1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow1(s, t);
        System.out.println(result);
    }

    private static int findNextFirst(Map<Character, Integer> tMap, String s, int start) {
        int result = -1;

        while (start < s.length()) {
            if (tMap.containsKey(s.charAt(start))) {
                result = start;
                break;
            }
            start++;
        }
        return result;
    }

    private static int get(Map<Character, Integer> map, Character c) {
        if (map.containsKey(c)) {
            return map.get(c);
        } else {
            return 0;
        }
    }

    private static void add(Map<Character, Integer> map, Character c, int num) {
        map.put(c, get(map, c) + num);
    }

    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public static String minWindow2(String s, String t) {
        if(s==null|| t==null) return "";

        return  null;
    }
}
