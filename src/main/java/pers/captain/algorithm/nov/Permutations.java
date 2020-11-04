package pers.captain.algorithm.nov;

import com.sun.org.apache.regexp.internal.RE;

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
    private void helper(List<List<Integer>> result, List<Integer> curList
            , int[] nums, boolean[] isUsed) {
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
}
