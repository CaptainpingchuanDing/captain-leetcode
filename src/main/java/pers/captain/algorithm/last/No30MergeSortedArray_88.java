package pers.captain.algorithm.last;

public class No30MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || m < 0 || n < 0) return;
        int[] mergeResult = new int[nums1.length];
        int num1Index = 0;
        int num2Index = 0;
        int mergerResultIndex = 0;
        while (num1Index < m || num2Index < n) {
            int tempMin;
            if (num1Index < m && num2Index < n) {
                if (nums1[num1Index] < nums2[num2Index]) {
                    tempMin = nums1[num1Index];
                    num1Index++;
                } else {
                    tempMin = nums2[num2Index];
                    num2Index++;
                }
            } else if (num1Index < m) {
                tempMin = nums1[num1Index];
                num1Index++;
            } else {
                tempMin = nums2[num2Index];
                num2Index++;
            }
            mergeResult[mergerResultIndex++] = tempMin;
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = mergeResult[i];
        }
    }


    public static void main(String[] args) {
        No30MergeSortedArray_88 mergeSortedArray_88 = new No30MergeSortedArray_88();
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{4};
        mergeSortedArray_88.merge(nums1,0,nums2,1);
        System.out.println(nums1);
    }
}
