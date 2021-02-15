package pers.captain.algorithm.tto.feb;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 返回描述：
 * 如果数组中有重复的数字，函数返回true，否则返回false。
 * 如果数组中有重复的数字，把重复的数字放到参数duplication[0]中。（ps:duplication已经初始化，可以直接赋值使用。）
 */
public class duplicationNum {

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length <= 1 || length <= 1) return false;
        Set<Integer> set = new HashSet();
        for (int i = 0; i < length; i++) {
            if (set.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                set.add(numbers[i]);
            }
        }
        return false;
    }

    public boolean duplicate2(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length <= 1 || length <= 1) return false;
        for (int i = 0; i < length; i++) {
            if (numbers[Math.abs(numbers[i])] < 0) {
                duplication[0] = Math.abs(numbers[i]);
                return true;
            } else {
                numbers[Math.abs(numbers[i])] = -numbers[Math.abs(numbers[i])];
            }
        }
        return false;
    }

    public boolean duplicate3(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length <= 1 || length <= 1) return false;
        // numbers[numbers[i]]== numbers[i];
        for (int i = 0; i < length; i++) {
            if (numbers[numbers[i]] == numbers[i]) {
                duplication[0] = Math.abs(numbers[i]);
                return true;
            } else {
                int temp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
            }
        }
        return false;
    }
}
