package pers.captain.algorithm.last;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class No10MedianOfTwoSortedArrays_4 {

    /**
     * 如果两个数组的长度为 length 是偶数，则找出 length/2-1 和 数length/2 两个数之和除以2
     * 如果是基数，则中位数就是 length/2；
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 1. 如果两个数直接对接的 直接找出
        int length = nums1.length + nums2.length;
        int halfLength = length / 2;
        boolean flag = false;// 偶数
        double result = 0;
        if (length % 2 == 0) {
            flag = true;
        }

        if (nums1[nums1.length - 1] < nums2[0]) {
            if (flag) {// 偶数
                if (nums1.length == halfLength && nums2.length == halfLength) {//取中间的数

                } else if (nums1.length > halfLength) { //取左边nums1的数
                    result = (nums1[halfLength] + nums1[halfLength - 1]) / 2.0;
                } else { //取右边nums2的数
                    result = (nums2[halfLength - nums1.length] + nums2[halfLength - nums1.length - 1]) / 2.0;
                }
            } else {
                if (nums1.length >= halfLength + 1) {
                    result = nums1[halfLength];
                } else {
                    result = nums1[halfLength - nums1.length];
                }
            }// 奇数
        }
        // 2. 如果有交叉，

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{2, 3};
        int[] nums2 = new int[]{4, 5, 6, 7};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
