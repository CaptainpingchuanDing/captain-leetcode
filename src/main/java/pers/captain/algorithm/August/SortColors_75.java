package pers.captain.algorithm.August;

import org.junit.Test;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortColors_75 {

    /**
     * 时间O(n) 空间 O(m)  (使用的空间是颜色的个数m)
     * 使用长度为3的数组 (如果不确定个数的时候，可以使用map记录元素出现的次数)
     *
     * @param nums
     */
    public static void sortColors1(int[] nums) {
        if (nums == null || nums.length == 0) return;

        // 记录每个颜色出现的次数
        int[] colorCounter = new int[3];
        // 遍历一遍记录
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 2 || nums[i] < 0) {
                throw new IllegalArgumentException("item of nums has gt 2 or lt 0");
            }
            colorCounter[nums[i]]++;
        }
        // 根据记录的次数进行赋值
        int numsIndex = 0;
        for (int i = 0; i < colorCounter.length; i++) {
            int count = colorCounter[i];
            if (count > 0) {
                while (count-- > 0) nums[numsIndex++] = i;
            }
        }
    }


    @Test
    public void sortColors1() {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors1(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }
    }


    /**
     * 时间O(n) 空间 O(m)
     *
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        //find left first none zero
        while (leftIndex < nums.length && nums[leftIndex] == 0) leftIndex++;

        // find right first none two
        while (rightIndex >= 0 && nums[rightIndex] == 2) rightIndex--;

        // 遍历一遍记录
        int index = leftIndex;
        while (index <= rightIndex) {
            if (nums[index] == 0) {
                swap(nums, index, leftIndex);
                index++;// 前面的数已经遍历过了，肯定不是2，只能是1
                leftIndex++;
            } else if (nums[index] == 2) {
                swap(nums, index, rightIndex);
                rightIndex--;// 交换之后 index位置的数不知道是什么，所以没有 index++
            } else {
                index++;
            }
        }
    }

    private static void swap(int[] nums, int s, int t) {
        int temp = nums[s];
        nums[s] = nums[t];
        nums[t] = temp;
    }

    @Test
    public void sortColors2() {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }
    }


}
