package pers.captain.algorithm.base;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1. 确定搜索区间
 * 2. 过程中如何缩小区间
 * 3. 如何终止搜索
 */
public class BinarySearch {

    /**
     * 基本的二分查找，一个有序的且不重复的数组
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (right >= left) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void testSearch() {
        int[] num1 = new int[]{2, 3, 5, 7};
        int result1 = search(num1, 8);
        Assert.assertEquals(result1, -1);

        int[] num2 = new int[]{2, 3, 5, 7};
        int result2 = search(num2, 1);
        Assert.assertEquals(result2, -1);

        int[] num3 = new int[]{2, 3, 5, 7};
        int result3 = search(num3, 3);
        Assert.assertEquals(result3, 1);

    }

    public static int search1(int[] nums, int target) {
        if (nums == null) return -1;
        int left = 0;
        int right = nums.length; //搜索区间[left,right)
        while (right > left) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void testSearch1() {
        int[] num1 = new int[]{2, 3, 5, 7};
        int result1 = search1(num1, 8);
        Assert.assertEquals(result1, -1);

        int[] num2 = new int[]{2, 3, 5, 7};
        int result2 = search1(num2, 1);
        Assert.assertEquals(result2, -1);

        int[] num3 = new int[]{2, 3, 5, 7};
        int result3 = search1(num3, 3);
        Assert.assertEquals(result3, 1);

    }

    /**
     * 寻找排序数字中重复数字的左边界
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchLeftBound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意  当left == right 终止  查找返回[left,right)
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        System.out.println("left:" + left);
        // 例如 [2,3,3,4] target = 5
        if (left == nums.length) return -1;
        if (nums[left] == target) return left;
        return -1;
    }

    /**
     * 寻找排序数字中重复数字的右边界
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchRightBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length;
        int index = -1;
        while (right > left) {
            int mid = (right + left) / 2;
            if (target == nums[mid]) {
                index = mid;
                left = mid + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            }
        }
        if (left == nums.length) return -1;
        if (nums[left] == target) return left;

        return index;
    }

    @Test
    public void testLeft() {
        int[] num1 = new int[]{2, 3, 5, 7};
        int right1 = searchLeftBound(num1, 8);
        System.out.println("left1:" + right1);
        Assert.assertEquals(right1, -1);

        int[] num2 = new int[]{2, 3, 5, 7};
        int right2 = searchLeftBound(num2, 1);
        System.out.println("left2:" + right2);
        Assert.assertEquals(right2, -1);


        int[] num3 = new int[]{2, 3, 3, 3, 5, 7};
        int right3 = searchLeftBound(num3, 3);
        System.out.println("left3:" + right3);
        Assert.assertEquals(right3, 1);
    }

    @Test
    public void testRight() {
        int[] num1 = new int[]{2, 3, 5, 7};
        int right1 = searchRightBound(num1, 8);
        System.out.println("right1:" + right1);
        Assert.assertEquals(right1, -1);

        int[] num2 = new int[]{2, 3, 5, 7};
        int right2 = searchRightBound(num2, 1);
        System.out.println("right2:" + right2);
        Assert.assertEquals(right2, -1);


        int[] num3 = new int[]{2, 3, 3, 3, 5, 7};
        int right3 = searchRightBound(num3, 3);
        System.out.println("right3:" + right3);
        Assert.assertEquals(right3, 3);

    }
}
