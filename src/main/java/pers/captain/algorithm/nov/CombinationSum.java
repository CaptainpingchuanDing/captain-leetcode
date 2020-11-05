package pers.captain.algorithm.nov;

import org.junit.Test;
import pers.captain.algorithm.CapL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> curList, int[] candidates, int target, int curIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(curList));
        } else {
            for (int i = curIndex; i < candidates.length; i++) {
                if (target < candidates[i]) continue;
                curList.add(candidates[i]);
                helper(result, curList, candidates, target - candidates[i], i);
                curList.remove(curList.size() - 1);
            }
        }
    }

    @Test
    public void combinationSum(){
        int[] candidates = new int[]{2,3,5};
        List<List<Integer>> result = combinationSum(candidates,8);
        CapL.print(result);
    }
}
