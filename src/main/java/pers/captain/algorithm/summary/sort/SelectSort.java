package pers.captain.algorithm.summary.sort;

import org.junit.Test;
import pers.captain.algorithm.CapL;

public class SelectSort {

    public void sort(int nums[]) {
        if (nums == null || nums.length < 2) return;
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) min = j;
            }
            if (min != i) {
                swap(nums, i, min);
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
