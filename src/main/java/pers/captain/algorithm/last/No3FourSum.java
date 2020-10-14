package pers.captain.algorithm.last;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 注意:答案中不能包含重复的四元组
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class No3FourSum {

    /*
    1. 先排序
    2. 选出其中一个number1，然后target1 =  target-number1 为剩下数组长度的目标值。
    3. 选出number2，target2 = target1-numbers2 ，为剩下数组长度的目标值。
    4. 选择number3 和number4 丛剩下的数组长度中。
     */
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int number1 = 0; number1 < nums.length - 3; number1++) {
            if (number1 > 0 && nums[number1 - 1] == nums[number1]) continue;

            int target1 = target - nums[number1];
            for (int number2 = number1 + 1; number2 < nums.length - 2; number2++) {
                if (number2 > number1 + 1 && nums[number2] == nums[number2 - 1]) {
                    continue;
                }
                int target2 = target1 - nums[number2];
                int left = number2 + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[left] + nums[right];
                    if (sum == target2) {
                        result.add(Arrays.asList(nums[number1], nums[number2], nums[left], nums[right]));
                        while (right > left && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target2) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    /**
     *  1.化繁为简，4个数之后 转化为 3个数之和， 然后转化为两个数之和。
     *
     *  2.指标  时间复杂度 o(n^3) 空间复杂度 o(n)
     *
     */


    /**
     * 大牛思路
     * <p>
     * 比自己多增加 当前最大值和当前最小值 的判断，少遍历一些无用的计算
     */
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int number1 = 0; number1 < nums.length - 3; number1++) {
            if (number1 > 0 && nums[number1 - 1] == nums[number1]) continue;

            //当前最小值，如果大于目标值，后面的数一定都会大于目标值，不需要遍历后面的元素
            int currentMin = nums[number1] + nums[number1 + 3] + nums[number1 + 2] + nums[number1 + 1];
            if (currentMin > target) {
                break;
            }

            int currentMax = nums[number1] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
            if (currentMax < target) {
                continue;
            }
            // 4数之后 转为3个数之和 目标值 target1
            int target1 = target - nums[number1];
            for (int number2 = number1 + 1; number2 < nums.length - 2; number2++) {
                if (number2 > number1 + 1 && nums[number2] == nums[number2 - 1]) {
                    continue;
                }

                int sum3CurrentMin = nums[number2] + nums[number2 + 1] + nums[number2 + 2];
                if (sum3CurrentMin > target1) {
                    number2 = nums.length;
                    continue;
                }

                int sum3CurrentMax = nums[number2] + nums[nums.length - 2] + nums[nums.length - 1];
                if (sum3CurrentMax < target1) {
                    continue;
                }
                // 3数之和 转为 2数之和 目标值为 target2；
                int target2 = target1 - nums[number2];


                int left = number2 + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[left] + nums[right];
                    if (sum == target2) {
                        result.add(Arrays.asList(nums[number1], nums[number2], nums[left], nums[right]));
                        while (right > left && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target2) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 大牛思路
     * <p>
     * 比自己多增加 当前最大值和当前最小值 的判断，少遍历一些无用的计算
     */
    public static List<List<Integer>> fourSum3(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int number1 = 0; number1 < nums.length - 3; number1++) {
            if (number1 > 0 && nums[number1 - 1] == nums[number1]) continue;

            //当前最小值，如果大于目标值，后面的数一定都会大于目标值，不需要遍历后面的元素
            int currentMin = nums[number1] + nums[number1 + 3] + nums[number1 + 2] + nums[number1 + 1];
            if (currentMin > target) {
                break;
            }

            int currentMax = nums[number1] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
            if (currentMax < target) {
                continue;
            }

            for (int number2 = number1 + 1; number2 < nums.length - 2; number2++) {
                if (number2 > number1 + 1 && nums[number2] == nums[number2 - 1]) {
                    continue;
                }

                currentMin = nums[number1] + nums[number2] + nums[number2 + 1] + nums[number2 + 2];
                if (currentMin > target) {
                    number2 = nums.length;
                    continue;
                }

                currentMax = nums[number1] + nums[number2] + nums[nums.length - 2] + nums[nums.length - 1];
                if (currentMax < target) {
                    continue;
                }

                int left = number2 + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[number1] + nums[number2] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[number1], nums[number2], nums[left], nums[right]));
                        while (right > left && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fourSum1(nums, 0));

    }

    @Test
    public void fourSum3(){
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fourSum3(nums, 0));
    }
}
