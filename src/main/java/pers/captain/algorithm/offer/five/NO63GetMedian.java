package pers.captain.algorithm.offer.five;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

public class NO63GetMedian {

    private PriorityQueue<Integer> min = new PriorityQueue<>();
    private PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private int count;

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            max.offer(num);
            int temp = max.poll();
            min.offer(temp);
        } else {
            min.offer(num);
            int temp = min.poll();
            max.offer(temp);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return min.peek() / 1.0;
        }
    }

    @Test
    public void test(){
        Insert(3);
        Insert(4);
        double res = GetMedian();
        Assert.assertEquals(3.5,res,0.1);
    }
}
