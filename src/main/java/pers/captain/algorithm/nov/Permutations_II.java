package pers.captain.algorithm.nov;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // 标识元素是否已经使用过
        boolean[] isUsed = new boolean[nums.length];
        helper(result, new ArrayList<>(), nums, isUsed);
        return result;
    }


    /**
     * 当前层有相同的元素，只加入一次。
     *
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
            // 记录当前层已经使用过的元素
            Set<Integer> curDepthUsedSet = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!isUsed[i] && !curDepthUsedSet.contains(nums[i])) {
                    isUsed[i] = true;
                    curList.add(nums[i]);
                    curDepthUsedSet.add(nums[i]);
                    helper(result, curList, nums, isUsed);
                    isUsed[i] = false;
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }

    private void helper_S(List<List<Integer>> result, List<Integer> curList, int[] nums, boolean[] isUsed) {
        if (curList.size() == nums.length) {
            result.add(new ArrayList<>(curList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (isUsed[i]) continue;
                // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
                // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1]) continue;
                isUsed[i] = true;
                curList.add(nums[i]);
                helper(result, curList, nums, isUsed);
                isUsed[i] = false;
                curList.remove(curList.size() - 1);
            }
        }
    }
}
