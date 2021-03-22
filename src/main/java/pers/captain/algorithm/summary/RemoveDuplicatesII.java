package pers.captain.algorithm.summary;

import org.junit.Test;

/**
 * 80. 删除排序数组中的重复项 II
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <p>
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下：
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int slow = 1;// slow
        Integer duplicateNum = null;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast - 1] != nums[fast]) {
                if (duplicateNum != null) {
                    nums[slow++] = duplicateNum;
                    duplicateNum = null;
                }
                nums[slow++] = nums[fast];
            } else {
                duplicateNum = nums[fast];
            }
        }
        if (duplicateNum != null) nums[slow++] = duplicateNum;
        return slow;
    }

    @Test
    public void removeDuplicates() {
        int[] num = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        removeDuplicates(num);
    }

    public int removeDuplicates2(int[] nums) {

        int j = 1, count = 1;
        // Start from the second element of the array and process
        // elements one by one.
        for (int i = 1; i < nums.length; i++) {
            // If the current element is a duplicate, increment the count.
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {//
                // Reset the count since we encountered a different element
                // than the previous one.
                count = 1;
            }
            // For a count <= 2, we copy the element over thus
            // overwriting the element at index "j" in the array
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    @Test
    public void removeDuplicates2() {
        int[] num = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        removeDuplicates2(num);
    }
}
