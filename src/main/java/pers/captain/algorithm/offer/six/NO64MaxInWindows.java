package pers.captain.algorithm.offer.six;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class NO64MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        if (size == 0 || num.length == 0 || size > num.length) return list;
        for (int i = 0; i < size; i++) {// 找出
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
                deque.pollLast();
            }
            deque.add(i);
        }
        list.add(num[deque.peekFirst()]);
        for (int i = 1; i < num.length - size + 1; i++) {
            while (!deque.isEmpty() && i > deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i + size - 1]) {
                deque.pollLast();
            }
            deque.addLast(i + size - 1);
            list.add(num[deque.peekFirst()]);
        }
        return list;
    }

    @Test
    public void maxInWindows() {
        int[] num = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        maxInWindows(num, 3);
    }
}
