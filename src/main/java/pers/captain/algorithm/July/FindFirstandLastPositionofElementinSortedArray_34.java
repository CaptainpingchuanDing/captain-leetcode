package pers.captain.algorithm.July;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindFirstandLastPositionofElementinSortedArray_34 {


    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int leftIndex = -1;
        int rightIndex = -1;

        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                leftIndex = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (nums[right] == target) leftIndex = right;
        if (nums[left] == target) leftIndex = left;

        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                rightIndex = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (nums[left] == target) rightIndex = left;
        if (nums[right] == target) rightIndex = right;

        return new int[]{leftIndex, rightIndex};
    }

    @Test
    public void test() {
        int[] nums = new int[]{5,7,7,8,8,10};
      int[] result = searchRange(nums,8);
        Assert.assertEquals(result[0],3);
        Assert.assertEquals(result[1],4);
    }
}
