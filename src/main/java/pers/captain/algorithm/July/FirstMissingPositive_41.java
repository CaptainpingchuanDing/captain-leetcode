package pers.captain.algorithm.July;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * <p>
 * 提示：
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstMissingPositive_41 {

    /**
     * 数组的每个位置表示正整数有无，第一个不为负数的位置就是缺失的第一正整数
     * 例如 {3, 4, -1, 1}
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        // 1. 先标记，把非正整数转为最大正整数
        // {3, 4, -1, 1} -->  {3, 4, MAX, 1}
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        // 2.
        // {3, 4, MAX, 1}
        // i=0 {3, 4, -MAX, 1}
        // i=1 {3, 4, -MAX, -1}
        // i=2 {3, 4, -MAX, -1}
        // i=3 {-1, 4, -MAX, -1}
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length && nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1];
            }
        }
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                target = i + 1;
                break;
            }
        }
        // 处理 例子[1,2] -->[-1,-2] 此时 target=0没有找到为正的index，target=数字length+1
        return target == 0 ? nums.length + 1 : target;
    }


    @Test
    public void test() {
        int[] nums = new int[]{3, 4, -1, 1};

        int target = firstMissingPositive(nums);
        Assert.assertEquals(target, 2);
    }
}
