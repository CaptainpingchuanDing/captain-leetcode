package pers.captain.algorithm.offer.five;

import java.util.HashSet;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中第一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是第一个重复的数字2。没有重复的数字返回-1。
 * 示例1
 * 输入
 * <p>
 * [2,3,1,0,2,5,3]
 * 返回值
 * <p>
 * 2
 */
public class No50DuplicateNumInArray {
    /**
     * 方法一： 使用map记录数字出现的次数
     *
     * @param numbers
     * @return
     */
    public int duplicate1(int[] numbers) {
        // write code here
        return 0;
    }
    public int duplicate (int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(numbers[i])) {
                return numbers[i];
            }
        }
        return -1;
    }

    /**
     * 利用 numbers数组本身，
     *
     * @param numbers
     * @return
     */
    public int duplicate2(int[] numbers) {
        // write code here
        if (numbers == null || numbers.length == 0) return -1;
        int count = 0;
        int duplicateNum = -1;
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[Math.abs(numbers[i])];
            if (num > 0) {
                numbers[Math.abs(numbers[i])] = -num;
            } else if (num == 0) {
                numbers[Math.abs(numbers[i])] = Integer.MIN_VALUE;
            } else {
                duplicateNum = Math.abs(numbers[i]);
                break;
            }
        }
        if (duplicateNum == -1) return -1;
        for (int i = 0; i < numbers.length; i++) {
            if (Math.abs(numbers[i]) == duplicateNum) {
                count++;
            }
        }
        return count;

    }
}
