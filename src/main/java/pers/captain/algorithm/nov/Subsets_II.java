package pers.captain.algorithm.nov;

import org.junit.Test;
import pers.captain.algorithm.CapL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * Medium
 * <p>
 * 1975
 * <p>
 * 90
 * <p>
 * Add to List
 * <p>
 * Share
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 */
public class Subsets_II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(list, new ArrayList<>(), 0, nums, false);
        return list;
    }

    private void helper(List<List<Integer>> list, List<Integer> curList, int curIndex, int[] nums, boolean isUsed) {
        if (curIndex >= nums.length) {
            list.add(new ArrayList(curList));
        } else {
            boolean flag = isUsed && curIndex != 0 && nums[curIndex] == nums[curIndex - 1];
            if (!flag) {
                helper(list, curList, curIndex + 1, nums, false);
            }
            curList.add(nums[curIndex]);
            helper(list, curList, curIndex + 1, nums, true);
            curList.remove(curList.size() - 1);
        }
    }

    @Test
    public void subsetsWithDup() {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> list = subsetsWithDup(nums);
        CapL.print(list);
    }
}
