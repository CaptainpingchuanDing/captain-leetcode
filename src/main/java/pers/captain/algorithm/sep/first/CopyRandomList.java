package pers.captain.algorithm.sep.first;

import pers.captain.algorithm.structrue.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CopyRandomList {
    /**
     * 方法一：通过迭代的方法  时间复杂度O(n)
     * 把访问过的老的节点记录在字典（map）中，新的和老的一一对应
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {

        if (head == null) return null;
        Map<Node, Node> visitedNodeMap = new HashMap<>();

        Node oldNode = head;

        Node newNode = new Node(oldNode.val, null, null);
        visitedNodeMap.put(oldNode, newNode);
        Node newHead = newNode;
        while (oldNode.next != null) {
            newNode.next = getClonedNode(oldNode.next, visitedNodeMap);
            newNode.random = getClonedNode(oldNode.random, visitedNodeMap);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return newHead;
    }

    private Node getClonedNode(Node node, Map<Node, Node> visitedNodeMap) {
        if (node == null)
            return null;
        if (!visitedNodeMap.containsKey(node)) {
            visitedNodeMap.put(node, new Node(node.val, null, null));
        }

        return visitedNodeMap.get(node);
    }


}
