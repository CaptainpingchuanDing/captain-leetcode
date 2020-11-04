package pers.captain.algorithm.nov;

import org.junit.Test;
import pers.captain.algorithm.CapL;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        helper(list, new ArrayList<>(), 0, nums);
        return list;
    }

    /**
     * @param list     结果集合
     * @param curList  当前组合
     * @param curIndex 当前元素在nums的位置
     * @param nums     可用数字
     */
    private void helper(List<List<Integer>> list, List<Integer> curList, int curIndex, int[] nums) {
        // 结束条件 curIndex >= nums.length
        if (curIndex >= nums.length) {
            list.add(new ArrayList<>(curList));
        } else {

            //不选择当前元素nums[curIndex];
            helper(list, curList, curIndex + 1, nums);
            //选择当前元素nums[curIndex];
            curList.add(nums[curIndex]);
            helper(list, curList, curIndex + 1, nums);
            curList.remove(curList.size()-1);

        }
    }

    @Test
    public void subsets() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> list = subsets(nums);
        CapL.print(list);
    }

}
