package pers.captain.algorithm.nov;

import org.junit.Test;
import pers.captain.algorithm.CapL;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * Medium
 * <p>
 * Add to List
 * <p>
 * Share
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        helper(result, new ArrayList<>(), nums, isUsed);
        return result;
    }

    /**
     * @param result
     * @param curList 当前元素排序集合
     * @param nums
     * @param isUsed  标识哪些元素已经使用
     */
    private void helper(List<List<Integer>> result, List<Integer> curList, int[] nums, boolean[] isUsed) {
        if (curList.size() == nums.length) {
            result.add(new ArrayList<>(curList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!isUsed[i]) {
                    isUsed[i] = true;
                    curList.add(nums[i]);
                    helper(result, curList, nums, isUsed);
                    isUsed[i] = false;
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }


    public List<List<Integer>> permute_E(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        helper_E(result, nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void helper_E(List<List<Integer>> result, int[] nums, List<Integer> curList, boolean isUsed[]) {
        if (curList.size() == nums.length) {// 已经排列完成
            result.add(new ArrayList<>(curList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (isUsed[i]) continue;
                curList.add(nums[i]);
                isUsed[i] = true;
                helper_E(result, nums, curList, isUsed);
                isUsed[i] = false;
                curList.remove(curList.size() - 1);
            }
        }
    }

    @Test
    public void permute_E() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = permute_E(nums);
        CapL.print(result);
    }
}