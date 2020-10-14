package pers.captain.algorithm.July;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianofTwoSortedArrays_4 {

    /**
     * 1.如果一个数组为空，直接取一个数组的中位数（奇数个，num[n/2]; 偶数个 (num[n/2]+num[n/2-1])/2）
     *
     * 2.如果两个数组都有数字，如果两个数组可以链接为一个有序数组（num1[n-1]<num2[0]|| num2[m-1]<num1[0]）
     *
     * 3.两个数组有交叉 ，
     * nums1 = [1, 2, 3]
     * nums2 = [3, 4, 5]
     *
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;
    }

}
