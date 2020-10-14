package pers.captain.algorithm.sep.bit;

public class ReverseBits {

    public int reverse(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            result = result << 1;// result 乘以 2
            result = result | bit;
            n = n >>> 1; // 去除 n 的最后一位
        }
        return result;
    }
}
