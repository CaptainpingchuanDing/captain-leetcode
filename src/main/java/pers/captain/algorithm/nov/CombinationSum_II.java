package pers.captain.algorithm.nov;

import org.junit.Test;
import pers.captain.algorithm.CapL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    /**
     */
    private void helper(List<List<Integer>> result, List<Integer> curList, int[] candidates, int target, int curIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(curList));
        } else {
            for (int i = curIndex; i < candidates.length; i++) {
                if (target < candidates[i]) break; // 进行剪枝，candidates[i] > target 在继续向后，或者深一层候选数都会大于target
                if (i > curIndex && candidates[i - 1] == candidates[i]) continue;// 为了防止重复
                curList.add(candidates[i]);
                helper(result, curList, candidates, target - candidates[i], i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }

    @Test
    public void combinationSum2() {
        int[] candidate = new int[]{2, 5, 2, 1, 2};
        List<List<Integer>> result = combinationSum2(candidate, 5);
        CapL.print(result);
    }

}
