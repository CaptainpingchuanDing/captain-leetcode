package pers.captain.algorithm.October.path;

import pers.captain.algorithm.structrue.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 示例：
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * 返回 3。和等于 8 的路径有:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class TreePathSum_III {
    /**
     * 递归的方式，当前节点开始，然后以左、右子节点为开始
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = calPathSum(root, sum);
        if (root.left != null)
            res += pathSum(root.left, sum);
        if (root.right != null)
            res += pathSum(root.right, sum);
        return res;
    }

    /**
     * 以当前节点为为开始节点，计算路径为sum
     *
     * @param root
     * @param sum
     * @return
     */
    private int calPathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int count = 0;
        if (sum - root.val == 0) {
            count++;
        }
        if (root.left != null)
            count += calPathSum(root.left, sum - root.val);
        if (root.right != null)
            count += calPathSum(root.right, sum - root.val);
        return count;
    }

    /**
     * 前缀和 + DFS，如果 之前的前缀和有curSum-sum ，那么当前节点与之前节点之间的路径和就是sum，
     * 既，那么当前节点的前缀和 - 之前节点前缀和 = sum  (curSum - (surSum-sum))  = sum，
     */
    public int pathSum2(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        return pathSum(root, prefixSumMap, 0, sum);
    }

    private int pathSum(TreeNode root, Map<Integer, Integer> prefixMap, int curSum, int sum) {
        int ret = 0;
        curSum += root.val;
        // 找前缀和为 curSum-sum，说明 该节点与找到的节点之间的路径和为sum
        ret = prefixMap.getOrDefault(curSum - sum, 0);
        // 更新前缀树
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);
        if (root.left != null) {
            ret += pathSum(root.left, prefixMap, curSum, sum);
        }
        if (root.right != null) {
            ret += pathSum(root.right, prefixMap, curSum, sum);
        }
        // 返回到上一层（）之前 把当前节点root影响的前缀和还原
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) - 1);
        return ret;
    }

    public int pathSum1(TreeNode root, int sum) {
        return pathSum1(root, sum, new int[1000], 0);
    }

    public int pathSum1(TreeNode root, int sum, int[] array/*保存路径*/, int p/*指向路径终点*/) {
        if (root == null) {
            return 0;
        }
        int tmp = root.val;
        int n = root.val == sum ? 1 : 0;
        for (int i = p - 1; i >= 0; i--) {
            tmp += array[i];
            if (tmp == sum) {
                n++;
            }
        }
        array[p] = root.val;
        int n1 = pathSum1(root.left, sum, array, p + 1);
        int n2 = pathSum1(root.right, sum, array, p + 1);
        return n + n1 + n2;
    }


}
