package pers.captain.algorithm.offer.three;

import org.junit.Test;
import pers.captain.algorithm.CapL;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 示例1
 * 输入
 * 复制
 * [4,5,1,6,2,7,3,8],4
 * 返回值
 * 复制
 * [1,2,3,4]
 */
public class NO29GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // 堆排序
        ArrayList<Integer> list = new ArrayList();
        if (input == null || k <= 0 || input.length == 0) return list;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                maxHeap.offer(input[i]);
            } else {
                if (maxHeap.peek() > input[i]) {
                    maxHeap.poll();
                    maxHeap.offer(input[i]);
                }
            }
        }
        for (Integer num : maxHeap) {
            list.add(num);
        }
        return list;
    }

    @Test
    public void getLeastNumbers() {
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> list  = GetLeastNumbers_Solution(input,4);
        CapL.print(list);
    }
}
