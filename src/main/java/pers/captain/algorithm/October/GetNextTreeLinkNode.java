package pers.captain.algorithm.October;

import pers.captain.algorithm.structrue.TreeLinkNode;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNextTreeLinkNode {


    public TreeLinkNode getNext(TreeLinkNode pNode) {

        if (pNode == null) return null;
        if (pNode.right == null) return findUp(pNode);
        return midSequence(pNode.right);

    }

    private TreeLinkNode findUp(TreeLinkNode u) {

        if (u.next != null && u.next.left == u) {
            return u.next;
        }
        if (u.next != null) {
            return u.next.next;
        }
        return null;
    }

    private TreeLinkNode midSequence(TreeLinkNode p) {
        if (p == null) return null;
        if (p.left != null) return midSequence(p.left);
        return p;
//        else if(p.right!=null) return midSequence(p.right);

    }

    /**
     * 分三种情况
     * <p>
     * 情况一：有右子树，直接找出右子树的最左子树
     * 情况二：无右子树，如果是父节点的左子树，下一个中序遍历就是父节点
     * 情况三：无右子树，如果是父节点的右子树，需要向上找到是左子树的父节点，否则没有下一个中序遍历
     *
     * @param pNode
     * @return
     */
    public TreeLinkNode getNext1(TreeLinkNode pNode) {

        if (pNode == null) return null;
        // 情况一：有右子树，直接找出右子树的最左子树
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        if (pNode.next != null) {
            // 情况二：无右子树，如果是父节点的左子树，下一个中序遍历就是父节点
            if (pNode.next.left == pNode) {
                return pNode.next;
            } else { // 情况三：无右子树，如果是父节点的右子树，需要向上找到是左子树的父节点，否则没有下一个中序遍历
                pNode = pNode.next;
                while (pNode.next != null) {
                    if (pNode.next.left == pNode) {
                        return pNode.next;
                    }
                    pNode = pNode.next;
                }
            }
        }
        /**
         * 和下面的情况二 和情况三效果一样
         */

//        // 2.
//        if (pNode.next != null && pNode.next.left == pNode) {
//            return pNode.next;
//        }
//        // 3.
//        if (pNode.next != null) {
//            TreeLinkNode pNext = pNode.next;
//            while (pNext.next != null && pNext.next.right == pNext) {
//                pNext = pNext.next;
//            }
//            return pNext.next;
//        }
        return null;

    }

    public TreeLinkNode getNextE(TreeLinkNode pNode) {
        //1. 如果给的节点有右子树
        if (pNode != null && pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //2. p没有右子树且有父节点
        if (pNode != null && pNode.next != null) {
            if (pNode == pNode.next.left) {
                return pNode.next;
            }
            while (pNode.next != null && pNode.next.right == pNode) {
                pNode = pNode.next;
            }
            return pNode.next;
        }
        return null;
    }

}
