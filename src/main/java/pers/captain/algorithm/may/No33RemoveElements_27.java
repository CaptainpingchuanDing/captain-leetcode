package pers.captain.algorithm.may;

import org.junit.Test;
import pers.captain.algorithm.LogUtils;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class No33RemoveElements_27 {


    public static int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int deleteNum = 0;
        for (int i = 0; i < nums.length - deleteNum; i++) {
            if (nums[i] == val) {
                leftRotateArray(nums, i);
                deleteNum++;
                i--;
            }
        }

        return nums.length - deleteNum;
    }

    private static void leftRotateArray(int[] nums, int start) {
        if (nums == null || nums.length <= start) {
            return;
        }
        for (int i = start; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }


    /**
     * 双指针办法（考虑到题目没有要求数字的顺序不变）
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int end = nums.length - 1;
        for (int i = 0; i <= end; i++) {
            if (nums[i] == val) {
                nums[i] = nums[end];
                end--;
                i--;
            }
        }

        return end + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
//        int[] nums = new int[]{3, 2, 2, 3};
        int result = No33RemoveElements_27.removeElement2(nums, 2);
        System.out.println(result);
    }

    public static int removeElementTest(int[] nums, int val) {

        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        // find the first node val
        while (right >= 0 && nums[right] == val) {
            right--;
        }
        while (right > left) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                nums[right] = val;
                while (right >= 0 && nums[right] == val) {
                    right--;
                }
            }
            left++;
        }

        return left + 1;
    }

    @Test
    public void removeElementTest() {

        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
//        int[] nums = new int[]{3, 2, 2, 3};
        int result = removeElementTest(nums, 2);
        System.out.println(result);
        LogUtils.printArray(nums);
    }
}
