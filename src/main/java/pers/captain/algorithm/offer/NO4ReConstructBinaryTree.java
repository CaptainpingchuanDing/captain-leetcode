package pers.captain.algorithm.offer;

import org.junit.Test;
import pers.captain.algorithm.CapL;
import pers.captain.algorithm.structrue.TreeNode;

import java.util.Arrays;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 示例1
 * 输入
 * 复制
 * [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 * 返回值
 * 复制
 * {1,2,5,3,4,6,7}
 */
public class NO4ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) return null;
        TreeNode node = helper(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return node;
    }

    private TreeNode helper(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preEnd < preStart || inEnd < inStart) return null;
        TreeNode node = new TreeNode(pre[preStart]);
        if (preEnd != preStart) {
            int mid = inStart;
            for (int i = inStart; i <= inEnd; i++) {
                if (pre[preStart] == in[i]) {
                    mid = i;
                    break;
                }
            }
            if (mid != inStart) {
                node.left = helper(pre, in, preStart + 1, preStart + mid - inStart, inStart, mid);
            }
            if (mid != inEnd) {
                node.right = helper(pre, in, preStart + mid - inStart + 1, preEnd, mid + 1, inEnd);
            }
        }
        return node;
    }


    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        //递归调用的终止条件
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        //由前序遍历得到该二叉树的根结点
        TreeNode root = new TreeNode(pre[0]);
        //在中序遍历中找根结点位置，进行左右子树的划分
        for (int i = 0; i < in.length; i++) {
            if (root.val == in[i]) {
                //将左子树看成一棵二叉树调用该方法，可以得到左子树根结点，即上面根结点的左子结点
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                //将右子树看成一棵二叉树调用该方法，可以得到右子树根结点，即上面根结点的右子结点
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                //找到根结点位置便跳出循环
                break;
            }
        }
        //返回根结点
        return root;
    }

    @Test
    public void reConstructBinaryTree2() {

        int[] array = new int[]{1, 2, 3, 4, 5};
        int[] array1 = Arrays.copyOfRange(array, 5, 5);
        CapL.printArray(array1);
    }


    public TreeNode reConstructBinaryTree2_E(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) return null;
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if(pre[0] == in[i]){
                node.left = reConstructBinaryTree2_E(Arrays.copyOfRange(pre,1,i+1)
                        ,Arrays.copyOfRange(in,0,i));
                node.right = reConstructBinaryTree2_E(Arrays.copyOfRange(pre,i+1,pre.length)
                        ,Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return node;
    }

}
