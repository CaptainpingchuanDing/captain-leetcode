package pers.captain.algorithm.June;

import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 *
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum_39 {

    /**
     *  [2, 3, 6, 7] target = 7
     *
     *  2(7) -> 2(5) -> 2(3) -> 2(1) ?
     *                       -> 3(1) ?
     *                       -> 6(1) ?
     *                       -> 7(1) ?
     *
     *               -> 3(3) -> 2(0) &
     *                       -> 3(0) &
     *                       -> 6(0) &
     *                       -> 7(0) &
     *
     *               -> 6(3) -> 2(-3) ?
     *                       -> 3(-3) ?
     *                       -> 6(-3) ?
     *                       -> 7(-3) ?
     *
     *               -> 7(3) -> 2(-4) ?
     *                       -> 3(-4) ?
     *                       -> 6(-4) ?
     *                       -> 7(-4) ?
     *
     *       -> 3(5) -> 2(2) &
     *               -> 3(2) ?
     *               -> 6(2) ?
     *               -> 7(2) ?
     *       -> 6(5)
     *
     *       -> 7(5)
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        return null;
    }

    /**
     *        2
     *    2  3  6  7
     *
     *
     *        3
     *     3 6  7
     *
     *         6
     *        6  7
     *
     *        7
     *        7
     *
     */
}
