package pers.captain.algorithm.last;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class No23_3SumClosest_16 {

    /**
     * 1. 先排序
     * 2. 固定一个num1， 然后用两个指针寻个找另外两个数字，记录三个数字之和接近target的和，每次更新。
     * // todo 题目理解错误
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int finalSum = nums[0] + nums[1] + nums[2];
        if (nums.length == 3 || finalSum == target) {
            return finalSum;
        }

        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int temp = nums[i] + nums[left] + nums[right];

                if (Math.abs(temp - target) < Math.abs(finalSum - target)) {
                    finalSum = temp;
                }
                if (temp > target) {
                    right--;
                } else if (temp < target) {
                    left++;

                } else {
                    return target;
                }
            }
        }
        return finalSum;
    }


    public int threeSumClosest1(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        int finalSum = 0;
        Arrays.sort(nums);
        int closetSum = Integer.MAX_VALUE;
        for (int i = 2; i < nums.length; i++) {
            int num1 = Math.abs(nums[i] - target);
            int num2 = Math.abs(nums[i - 1] - target);
            int num3 = Math.abs(nums[i - 2] - target);
            int sum = num1 + num2 + num3;
            if (closetSum == Integer.MAX_VALUE) {
                closetSum = sum;
            } else if (closetSum > sum) {
                closetSum = sum;
                if (i == nums.length - 1) {
                    return nums[i] + nums[i - 1] + nums[i - 2];
                }
            } else {
                finalSum = nums[i - 1] + nums[i - 2] + nums[i - 3];
                break;
            }
        }
        return finalSum;
    }


    public int threeSumClosest2(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int finalSum = nums[0] + nums[1] + nums[2];
        if (nums.length == 3 || finalSum == target) {
            return finalSum;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int temp = nums[i] + nums[i + 1] + nums[i + 2];

            if (finalSum <= temp) {

            } else if (finalSum > temp) {

            }
        }

        return finalSum;
    }

    public static void main(String[] args) {
        No23_3SumClosest_16 sumClosest_16 = new No23_3SumClosest_16();
        int result1 = sumClosest_16.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
//        int result2 = sumClosest_16.threeSumClosest1(new int[]{-1, 2, 1, -4}, 1);
        int result3 = sumClosest_16.threeSumClosest1(new int[]{0, 2, 1, -3}, 1);
        System.out.println(result1);
//        System.out.println(result2);
        System.out.println(result3);
    }


    @Test
    public void threeSumClosestTest() {
        int[] nums = new int[]{-1, 2, 1, -4};
        int result = threeSumClosestTest(nums, 1);
        System.out.println(result);
    }

    public int threeSumClosestTest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);

        boolean firstFlag = true;
        int finalSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                if (firstFlag) {
                    finalSum = sum;
                } else if (Math.abs(sum - target) < Math.abs(finalSum - target)) {
                    finalSum = sum;
                }
            }
        }

        return finalSum;
    }
}
