package pers.captain.algorithm.sep.bit;

import org.junit.Assert;
import org.junit.Test;

public class CountOneBit {

    public int countBitOne(int n) {
        int result = 0;

        while (n != 0) {
            result++;
            n = n & (n - 1);
        }
        return result;
    }

    @Test
    public void countBitOne() {
        int res = countBitOne(8);
        Assert.assertEquals(res, 1);
    }

    public int countBitOne1(int n) {
        int result = 0;

        int i = 0;
        while (i < 32) {
            if ((n & (1 << i)) != 0) {
                result++;
            }
            i++;
        }
        return result;
    }
    @Test
    public void countBitOne1() {
        int res = countBitOne1(8);
        Assert.assertEquals(res, 1);
    }

}
