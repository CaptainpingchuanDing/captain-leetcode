package pers.captain.algorithm.summary.sort;

import org.junit.Test;
import pers.captain.algorithm.CapL;

public class MergeSort {
    private int[] aux;

    public void sort(int nums[]) {
        if (nums == null || nums.length < 2) return;
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int high) {
        if (lo >= high) return;
        int mid = lo + (high - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, high);
        merge(nums, lo, mid, high);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;// j的值和第二个sort分的值相同
        for (int k = lo; k <= hi; k++) {
            if (i > mid) aux[k] = nums[j++];//  左半部分没有数值了
            else if (j > hi) aux[k] = nums[i++];// 右半部分没有数值了
            else if (nums[i] < nums[j]) {
                aux[k] = nums[i++];
            } else {
                aux[k] = nums[j++];
            }
        }
        for (int k = lo; k <= hi; k++) {
            nums[k] = aux[k];
        }
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
