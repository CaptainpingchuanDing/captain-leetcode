package pers.captain.algorithm;

import org.junit.Test;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeroes {

    /**
     * 双指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;
        // find first zero for left
        int left = 0;
        while (left < nums.length) {
            if (nums[left] > 0) {
                left++;
            } else {
                break;
            }
        }
        int right = findNextNoneZero(nums, left);
        while (right < nums.length && right > left) {
            if (nums[left] == 0) {
                nums[left] = nums[right];
                nums[right] = 0;
                right = findNextNoneZero(nums, right);
            }
            left++;
        }

    }

    private int findNextNoneZero(int[] nums, int right) {

        while (right < nums.length && nums[right] == 0) {
            right++;
        }
        return right;
    }

    @Test
    public void moveZeroes() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        LogUtils.printArray(nums);

    }
}
