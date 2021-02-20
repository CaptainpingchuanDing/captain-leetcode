package pers.captain.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 示例1
 * 输入
 * <p>
 * [1,2,3,2,2,2,5,4,2]
 * 返回值
 * <p>
 * 2
 */
public class NO28MoreThanHalfNum {

    /**
     * 方法一： 利用一个map记录数字出现的次数
     * time:O(n)  space:O(n)
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if(array==null) return 0;
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i< array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
            } else{
                map.put(array[i],1);
            }
            if(map.get(array[i])*2> array.length) return array[i];
        }
        return 0;
    }
    // todo
}
