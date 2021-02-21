package pers.captain.algorithm.offer.two;

import pers.captain.algorithm.structrue.TreeNode;

public class NO17HasSubtree {

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) return false;
        if (isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2)) {
            return true;
        }
        return false;
    }

    private static boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;// 没有到达root1的根节点也是可以的
        if (root1 == null) return false;
        if (root1.val == root2.val) {
            return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
        }
        return false;
    }
}
