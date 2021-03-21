package pers.captain.algorithm.summary;

import pers.captain.algorithm.CapL;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class TreeNode {
        private int key;
        private int val;
        private TreeNode pre;
        private TreeNode next;

        public TreeNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, TreeNode> map = new HashMap<>();
    private final TreeNode startDummy = new TreeNode(0, 0);
    private final TreeNode endDummy = new TreeNode(0, 0);

    public LRUCache(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity is must be positive");
        this.capacity = capacity;
        endDummy.pre = startDummy;
        startDummy.next = endDummy;
    }

    public int get(int key) {
        TreeNode result = map.get(key);
        if (result != null) {
            if (result.pre != startDummy) {
                removeNode(result);
                insertHead(result); // 删除之后，插入到虚头结点之后
            }
            return result.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        TreeNode result = map.get(key);
        if (result != null) {
            result.val = value;
            removeNode(result);
            insertHead(result); // 删除之后，插入到虚头结点之后
        } else {
            if (map.size() == capacity) {
                TreeNode toBeDeleteNode = endDummy.pre;
                map.remove(toBeDeleteNode.key);// 删除map中存储的数值
                removeNode(toBeDeleteNode);
            }
            TreeNode newHead = new TreeNode(key, value);
            insertHead(newHead);
            map.put(key, newHead);
        }
    }

    private void removeNode(TreeNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre; //result在中间，先把其删除
    }

    private void insertHead(TreeNode node) {
        node.next = startDummy.next;
        node.pre = startDummy;// node自身两个指针 next  pre
        startDummy.next.pre = node;//
        startDummy.next = node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 0);
        lruCache.put(2, 2);
        CapL.print(lruCache.get(1));
        lruCache.put(3, 3);
        CapL.print(lruCache.get(2));
        lruCache.put(4, 4);
        CapL.print(lruCache.get(1));
        CapL.print(lruCache.get(3));
        CapL.print(lruCache.get(4));


    }
}
