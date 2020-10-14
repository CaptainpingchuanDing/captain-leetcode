package pers.captain.algorithm.June;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation_31 {

    public static void nextPermutation(int[] nums) {

        int rightI = nums.length - 1;
        while (0 < rightI) {
            if (nums[rightI] < nums[rightI - 1]) {//前一个数大于
                if (rightI == 1) {// 整个数组是倒序的
                    reverseArray(nums);
                    break;
                }
            } else {
                int temp = rightI;
                while (temp < nums.length - 1 && nums[rightI - 1] < nums[temp]) {
                    if (temp == nums.length - 1) {
                        swap(nums, temp - 1, temp);
                        break;
                    } else if (nums[rightI - 1] >= nums[temp + 1]) {
                        swap(nums, rightI - 1, temp);
                        break;
                    } else {
                        temp++;
                    }
                }
                swap(nums, rightI - 1, temp);
            }
            rightI--;
        }
    }

    public static void nextPermutation1(int[] nums) {

        int rightI = nums.length - 1;
        while (0 < rightI) {
            if (nums[rightI] < nums[rightI - 1]) {//前一个数大于
                if (rightI == 1) {// 整个数组是倒序的
                    reverseArray(nums);
                    break;
                }
            } else {
                int temp = rightI;
                while (temp < nums.length - 1 && nums[rightI - 1] < nums[temp]) {
                    if (temp == nums.length - 1) {
                        swap(nums, temp - 1, temp);
                        break;
                    } else if (nums[rightI - 1] >= nums[temp + 1]) {
                        swap(nums, rightI - 1, temp);
                        break;
                    } else {
                        temp++;
                    }
                }
                swap(nums, rightI - 1, temp);
            }
            rightI--;
        }
    }

    /**
     * @param nums
     */
    public void nextPermutationGuanFang(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        if (start >= nums.length - 1) {
            return;
        }
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;

        }
    }


    private static void reverseArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;

        }
    }

    private static void swap(int[] nums, int left, int right) {
        if (nums == null || left > nums.length - 1 || right > nums.length - 1) {
            return;
        }
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public void nextPermutationTest(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        int j = nums.length - 1;
        if (i >= 0) {
            while (j > 0 && j > i) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                } else {
                    j--;
                }
            }
        }
        reverse(nums, i + 1);
    }


    /**
     * 步骤一、首先丛数组的右边向左边找到一个数， 第一个小于右边的数。  [1, 2, 5, 7, 6, 4, 3] ,则是index=2 ;[1, 2, 3, 4, 5, 6, 7] ，则是 index = 5
     * [5, 4, 3, 2, 1] 则 index = -1 也就是这个不存在。
     * <p>
     * 步骤二、 然后找一个该index 最靠近右边的比nums[index]大的位置 indexLarge，把这两个位置的数组元素进行交换
     * 例如 [1, 2, 5, 7, 6, 4, 3] indexLarge = 4 ,交换之后 [1, 2, 6, 7, 5, 4, 3]
     * 例如 [1, 2, 3, 4, 5, 6, 7] indexLarge = 6 ,交换之后 [1, 2, 3, 4, 5, 7, 6]
     * <p>
     * 步骤三、 把index+1之后的元素进行reverse一下。
     * [1, 2, 5, 7, 6, 4, 3]  reverse之后为 [1, 2, 5, 3, 4, 6, 7]
     */
    public static void nextPermutation2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;

        int index = nums.length - 2;
        //1. 找到第一个小于右边的数
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        // 处理 [4, 3, 2, 1]这种最大的排列
        if (index < 0) {
            reverse2(nums, 0, nums.length - 1);
            return;
        }
        //2. 找到与index最近切大于nums[index]
        int indexLarge = index + 1;
        while (indexLarge < nums.length && nums[index] < nums[indexLarge]) {
            indexLarge++;
        }
        // 结束循环之后，indexLarge需要减一
        // index 和indexLarge 更换
        swap2(nums, index, indexLarge - 1);
        // 3. reverse index之后的元素
        reverse2(nums, index + 1, nums.length - 1);

    }

    private static void reverse2(int[] nums, int left, int right) {
        while (right - left > 0) {
            swap2(nums, left++, right--);
        }
    }

    private static void swap2(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    @Test
    public void testNextPermutation2() {
        int[] nums = new int[]{1, 2, 5, 7, 6, 4, 3};
        nextPermutation2(nums);
        int[] result = new int[]{1, 2, 6, 3, 4, 5, 7};
        for (int i = 0; i < nums.length - 1; i++) {
            Assert.assertEquals(result[i], nums[i]);
        }

        nums = new int[]{5, 4, 3, 2, 1};
        nextPermutation2(nums);
        result = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < nums.length - 1; i++) {
            Assert.assertEquals(result[i], nums[i]);
        }

        nums = new int[]{1, 2, 3, 4, 5};
        nextPermutation2(nums);
        result = new int[]{1, 2, 3, 5, 4};
        for (int i = 0; i < nums.length - 1; i++) {
            Assert.assertEquals(result[i], nums[i]);
        }
    }

    public static void main(String[] args) {
        NextPermutation_31 nextPermutation_31 = new NextPermutation_31();

        int[] nums = new int[]{1, 4, 3, 2};
//        int[] nums = new int[]{4, 3, 2};
//        int[] nums = new int[]{1, 5, 1};
//        int[] nums = new int[]{1, 2, 3};
//        nextPermutation(nums);
//        System.out.println(JSON.toJSONString(nums));
        nextPermutation_31.nextPermutationTest(nums);
        System.out.println(JSON.toJSONString(nums));
    }


}
