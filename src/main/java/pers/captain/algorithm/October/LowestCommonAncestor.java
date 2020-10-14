package pers.captain.algorithm.October;

import pers.captain.algorithm.structrue.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor {


    /**
     * 方法一：通过循环的方式。
     * <p>
     * 要么p和q都在右子树，则 root = root.right
     * 要么p和q都在左子树，则 root = root.left
     * 其他（p或者q 与root相同，或者p和q分别在两边）返回root
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == null) return q;
        if (q == null) return p;

        while (root != null) {
            if (root.val < p.val && root.val < q.val) root = root.right;
            else if (root.val > p.val && root.val > q.val) root = root.left;
            else break;
        }

        return root;
    }

    /**
     * 方法二： 递归的方式 思路和循环一样
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == null) return q;
        if (q == null) return p;
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor1(root.right, p, q);
        else if (root.val > p.val && root.val > q.val) return lowestCommonAncestor1(root.left, p, q);
        else return root;
    }


    public TreeNode lowestCommonAncestorE(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (p == null) return q;
        if (q == null) return p;
        if (root.val > p.val & root.val > q.val) return lowestCommonAncestorE(root.left, p, q);
        else if (root.val < p.val & root.val < q.val) return lowestCommonAncestorE(root.right, p, q);
        else return root;

    }

    public TreeNode lowestCommonAncestorE2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (p == null) return q;
        if (q == null) return p;
        while (root != null) {
            if (root.val > p.val & root.val > q.val) root = root.left;
            else if (root.val < p.val & root.val < q.val) root = root.right;
            else break;
        }
        return root;
    }

}

