package pers.captain.algorithm.last;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 注意：假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class No13ReverseInteger_7 {

    public static int reverse(int x) {

        int result = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (x != 0) {
            multiply(list);
            int temp = x % 10;
            list.add(temp);

            x = x / 10;
        }
        for (int temp : list) {
            result += temp;
        }
        if (result == Integer.MIN_VALUE) {
            return 0;
        }
        return result;
    }

    private static void multiply(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) * 10);
        }
    }

    public static int reverse1(int x) {

        long temp = 0;

        while (x != 0) {
            int pop = x % 10;
            temp = temp * 10 + pop;

            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) temp;

    }


    /**
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10
                    || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)
                    || rev < Integer.MIN_VALUE / 10
                    || (rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10)) {
                rev = 0;
                break;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int reverse3(int x) {

        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)
                    || result < Integer.MIN_VALUE / 10
                    || (result == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;

    }


    public static void main(String[] args) {
        System.out.println(reverse1(1534236469));


        System.out.println(reverse2(-1463847412));
        System.out.println(reverse3(-1463847412));
    }
}
