package pers.captain.algorithm.October.serial;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;
import pers.captain.algorithm.CapL;
import pers.captain.algorithm.structrue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root != null) queue.add(root);
        boolean flag = true;
        while (flag && !queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode node = queue.poll();
                Integer num = node == null ? null : node.val;
                list.add(num);
                if (flag && node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    flag = false;// 表示该层有null的元素，不需要向下一层迭代
                }
            }
        }
        return list.toString();
    }

    @Test
    public void serialize() {
        TreeNode head = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        head.left = treeNode2;
        head.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        CapL.print(serialize(head));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}
