package pers.captain.algorithm.may;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import pers.captain.algorithm.CapL;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * <p>
 * 例子1：
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class No32RemoveDuplicatesfromSortedArray_26 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int removeCount = 0;
        for (int i = 0; i < nums.length - removeCount; i++) {
            while (i < nums.length - 1 - removeCount && nums[i] == nums[i + 1]) {
                removeCount++;
                leftRotateArray(nums, i);
            }
        }
        return nums.length - removeCount;
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
     * 利用两个指针，一个fast负责遍历所有的元素，一个slow负责指明需要向后移动的元素
     * 例如 [1, 2, 2, 3, 4]
     * fast  slow   flag
     * 1     1      f
     * 2     1      f
     * 3     2      t
     * 4     2
     *
     * @param nums
     * @return
     */
    public static int removeDuplicatesFast(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int slow = 1;// slow 左边的都是不重复的元素
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast - 1] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }


    @Test
    public void testRemoveDuplicatesFast() {
        int[] nums = new int[]{1, 2, 2, 2, 3, 3, 4};

        int count = removeDuplicatesFast(nums);
        System.out.println(count);

        int[] nums1 = new int[]{1};
        int count1 = removeDuplicatesFast(nums1);
        System.out.println(count1);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        int count = removeDuplicates(nums);

        System.out.println(count);
        System.out.println(JSON.toJSONString(nums));

    }


    // practice
    public int PRemoveDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int slow = 1;// slow 左边的都是不重复的元素
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast - 1] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }


    public int PRemoveDuplicatesTest(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 1;
        // find the first duplicate element
        while (left < nums.length && nums[left - 1] != nums[left]) {
            left++;
        }
        int right = left + 1;
        while (right < nums.length) {
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    @Test
    public void PRemoveDuplicatesTest() {
        int[] nums = new int[]{1, 2, 2, 2, 3, 3, 4};

        int count = PRemoveDuplicatesTest(nums);
        System.out.println(count);
        CapL.printArray(nums);
    }

}
