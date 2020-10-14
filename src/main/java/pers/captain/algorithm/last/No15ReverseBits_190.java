package pers.captain.algorithm.last;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class No15ReverseBits_190 {


    public static int reverseBits(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }

    public static int reverseBits1(int n) {
        int result = 0;

        for (int bitSize = 31; n != 0; bitSize--, n = n >> 1) {
            result = result + ((n & 1) << bitSize);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(10));
        System.out.println(reverseBits1(10));
    }
}
