package pers.captain.algorithm.offer.four;

/**
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class NO40FindNumsAppearOnce {

    /**
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) return;
        // 1. 先把数组中所有数相互异或
        int num = array[0];
        for (int i = 1; i < array.length; i++) {
            num = num ^ array[i];
        }
        int mask = 1; // 2. 从异或结果右边找到第一位为1的位置（二进制）
        while ((mask & num) == 0) {
            mask = mask << 1;
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & mask) == 0) {  // 3. 通过与mask 与操作分成两组
                num1[0] = num1[0] ^ array[i]; // 4. 每组进行异或，结果就是出现一次的数
            } else {
                num2[0] = num2[0] ^ array[i]; // 4. 每组进行异或，结果就是出现一次的数
            }
        }
    }
}
