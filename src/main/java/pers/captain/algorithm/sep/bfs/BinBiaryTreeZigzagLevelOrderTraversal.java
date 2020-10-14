package pers.captain.algorithm.sep.bfs;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import pers.captain.algorithm.structrue.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinBiaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        int layer = 1;
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> oneLayerList = new ArrayList<>();
            while (size > 0) {
                size--;
                TreeNode temp = queue.poll();
                if (temp != null) {
                    if (layer % 2 == 0) {
                        stack.push(temp.val);
                    } else {
                        oneLayerList.add(temp.val);
                    }
                    if (temp.left != null) queue.add(temp.left);
                    if (temp.right != null) queue.add(temp.right);
                }
            }
            if (layer % 2 == 0) {
                while (!stack.isEmpty()) {
                    oneLayerList.add(stack.pop());
                }
            }
            result.add(oneLayerList);

            layer++;
        }
        return result;

    }

    @Test
    public void zigzagLevelOrder() {
        TreeNode head = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        head.left = treeNode2;
        head.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        List<List<Integer>> result = zigzagLevelOrder(head);
        System.out.println(JSON.toJSONString(result));

    }

}
