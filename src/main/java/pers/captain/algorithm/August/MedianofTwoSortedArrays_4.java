package pers.captain.algorithm.August;

import org.junit.Test;

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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0f;
        if (nums1 == null || nums2 == null) return median;
        if (nums1.length == 0) return findMedian(nums2);
        if (nums2.length == 0) return findMedian(nums1);


        // num1 + num2   [1,2] [3,4]
        if (nums1[nums1.length - 1] <= nums2[0]) {
            return findMedian(nums1, nums2);
        }
        // num2 + num1   [3,4] [1,2]
        if (nums2[nums2.length - 1] <= nums1[0]) {
            return findMedian(nums2, nums1);
        }
        // num2 contain num1 [2,3] [1,4,5]

        // num1 contain num2 [1,4] [2,3]

        // num1 and num2 join together  [2,4] [3,5]


        return median;
    }

    private double findMedian(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        } else {
            return nums[nums.length / 2];
        }
    }

    private double findMedian(int[] leftArray, int[] rightArray) {
        double median;
        int number = leftArray.length + rightArray.length;
        if (number % 2 == 0) {
            if (number / 2 - 1 > leftArray.length - 1) {
                median = (rightArray[number - leftArray.length] + rightArray[number - leftArray.length + 1]) / 2.0;
            } else if (number / 2 - 1 == leftArray.length - 1) {
                median = (leftArray[leftArray.length - 1] + rightArray[0]) / 2.0;
            } else {
                median = (leftArray[number / 2 - 1] + leftArray[number / 2]) / 2.0;
            }
        } else {
            if (number / 2 <= leftArray.length - 1) {
                median = leftArray[number / 2];
            } else {
                median = rightArray[number / 2 - leftArray.length];
            }
        }
        return median;
    }

    @Test
    public void findMedianSortedArrays(){
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        double result = findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }
}
