package pers.captain.algorithm.summary.sort;

import org.junit.Test;
import pers.captain.algorithm.CapL;

public class BubbleSort {

    public void sort(int[] nums) {
        // [3,1,2]
        if (nums == null || nums.length < 2) return;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length - i; j++) {// 每一次找出一个最大的，放在右边
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    @Test
    public void sort() {
        int[] nums = new int[]{2, 3, 8, 3};
        sort(nums);
        CapL.print(nums);

        nums = new int[]{8, 7};
        sort(nums);
        CapL.print(nums);

        nums = new int[]{2};
        sort(nums);
        CapL.print(nums);
    }

}
