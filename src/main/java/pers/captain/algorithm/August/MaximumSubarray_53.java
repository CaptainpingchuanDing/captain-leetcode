package pers.captain.algorithm.August;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSubarray_53 {


    /**
     * 1. 暴力方法，以 nums[i]开头的最大子串,  时间复杂度 O（n）2
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    if (max < nums[i]) max = nums[i];
                } else {
                    int temp = sum(nums, i, j);
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        return max;

    }

    private static int sum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;

    }

    @Test
    public void maxSubArray1() {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray1(array);
        Assert.assertEquals(result, 6);

        int[] array1 = new int[]{1, 2};
        result = maxSubArray1(array1);
        Assert.assertEquals(result, 3);
    }


    /**
     * 方法2 动态规划， 利用一个以为数组记录结果，f(i)表示已 i 位置结果的连续子数组的最大值
     * <p>
     * <p>
     * 反思：动态规划，持久化不一定是一个认为数组，一维数组也一样。
     *
     * @param nums
     * @return
     */
    public int maxSubArrayDongtai(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] record = new int[nums.length];
        record[0] = nums[0];
        int max = record[0];
        for (int i = 1; i < nums.length; i++) {
            record[i] = Math.max(record[i - 1] + nums[i], nums[i]);
            max = Math.max(record[i], max);
        }
        return max;

    }

    public int maxSubArrayDongtai2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int record = nums[0];
        int max = record;
        for (int i = 1; i < nums.length; i++) {
            record = Math.max(record + nums[i], nums[i]);
            max = Math.max(record, max);
        }
        return max;

    }

    /**
     * 方法3 分治的思想
     * 三个区间   [left, mid]  [mid+1, right]  [...mid,mid+1...](包含mid和mid+1两个元素的区间)
     *
     * @param nums
     * @return
     */
    public int maxSubArrayFenzi(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return maxSubArrayFzHelper(nums, 0, nums.length - 1);
    }

    private static int maxSubArrayFzHelper(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int max;
        int mid = left + (right - left) / 2;

        // 1.左右区间
        int leftMax = maxSubArrayFzHelper(nums, left, mid);
        int rightMax = maxSubArrayFzHelper(nums, mid + 1, right);

        //2.中间

        // a.计算左边包含 mid的最大值
        int tempLeftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid; i >= left; i--) {
            leftSum += nums[i];
            tempLeftMax = Math.max(tempLeftMax, leftSum);
        }
        // b.计算右边包含 mid+1的最大值
        int tempRightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            rightSum += nums[i];
            tempRightMax = Math.max(tempRightMax, rightSum);
        }

        int midMax = tempLeftMax + tempRightMax;
        // 求出三个最大值
        max = Math.max(leftMax, rightMax);
        max = Math.max(max, midMax);
        return max;

    }


    @Test
    public void maxSubArrayDongtai() {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArrayDongtai(array);
        Assert.assertEquals(result, 6);

        int[] array1 = new int[]{1, 2};
        result = maxSubArrayDongtai(array1);
        Assert.assertEquals(result, 3);
    }

    @Test
    public void maxSubArrayFenzi(){
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArrayFenzi(array);
        Assert.assertEquals(result, 6);

        int[] array1 = new int[]{1, 2};
        result = maxSubArrayFenzi(array1);
        Assert.assertEquals(result, 3);
    }
}
