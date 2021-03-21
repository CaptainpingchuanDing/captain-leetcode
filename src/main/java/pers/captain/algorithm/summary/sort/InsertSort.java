package pers.captain.algorithm.summary.sort;

import org.junit.Test;
import pers.captain.algorithm.CapL;

public class InsertSort {

    public void sort(int nums[]) {
        if (nums == null || nums.length < 2) return;
        for (int i = 1; i < nums.length; i++) {
            int k = i;
            while (k >= 1 && nums[k] < nums[k - 1]) {
                int temp = nums[k];
                nums[k] = nums[k - 1];
                nums[k - 1] = temp;
                k--;
            }
        }
    }

    public void sort1(int nums[]) {
        if (nums == null || nums.length < 2) return;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
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

        nums = new int[]{2, 3};
        sort(nums);
        CapL.print(nums);
    }

    @Test
    public void sort1() {
        int[] nums = new int[]{2, 3, 8, 3};
        sort1(nums);
        CapL.print(nums);

        nums = new int[]{8, 7};
        sort1(nums);
        CapL.print(nums);

        nums = new int[]{2, 3};
        sort1(nums);
        CapL.print(nums);
    }


}
