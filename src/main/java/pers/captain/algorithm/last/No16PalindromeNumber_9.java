package pers.captain.algorithm.last;

import sun.awt.windows.ThemeReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class No16PalindromeNumber_9 {

    /**
     * 把每一位取出来
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {// 负数
            return false;
        }
        List<Integer> bitList = new ArrayList<Integer>();
        while (x != 0) {
            bitList.add(x % 10);
            x = x / 10;
        }
        int left = 0;
        int right = bitList.size() - 1;

        while (right - left > 0) {
            if (bitList.get(left) != bitList.get(right)) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }

    /**
     * 转为字符串
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        if (x < 0) {// 负数
            return false;
        }
        String str = x + "";

        int left = 0;
        int right = str.length() - 1;

        while (right - left > 0) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }


    /**
     * 摘抄大神，利用翻转的方式。
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

    /**
     * 反正整数的低位，高位同时也降低，当低位大于高位时，表示已经反转完成。
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10) == 0 && x != 0) {
            return false;
        }
        int di = 0;
        while (x > di) {
            di = di * 10 + (x % 10);
            x = x / 10;
        }
        return x == di || (x == di / 10);
    }


    public static void main(String[] args)throws Exception {
//        System.out.println(isPalindrome(233332));
//        System.out.println(isPalindrome2(233332));
        while(true){
//            Thread.sleep(1);
            Set<String> set = new HashSet<String>();
            set.add("ee");
            isPalindrome3(232);
        }

    }
}
//    ps p 96647 -L -o pcpu,pmem,pid,tid,time,tname,cmd
//
//        jstack -l 96647 > /Users/dingpingchuan1/jstack.log