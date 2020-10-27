package pers.captain.algorithm.October;

import pers.captain.algorithm.structrue.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TreeNodeChildStructrue {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;// 空树不是子树
        if (A == null) return false;
        boolean flag = false;
        if (A.val == B.val) {
            flag = isSubTree(A.left, B.left);
            if (flag) {
                flag = isSubTree(A.right, B.right);
            }
        }
        if (!flag) {
            flag = isSubStructure(A.left, B);
            if (!flag) {
                flag = isSubStructure(A.right, B);
            }
        }
        return flag;
    }

    private boolean isSubTree(TreeNode a, TreeNode b) {
        if (b == null && a == null) return true;
        if (a == null) return false;
        if (b == null) return true;
        if (a.val == b.val) {
            boolean flag = isSubTree(a.left, b.left);
            if (!flag) return false;
            flag = isSubTree(a.right, b.right);
            if (!flag) return false;
        } else {
            return false;
        }
        return true;
    }
}
