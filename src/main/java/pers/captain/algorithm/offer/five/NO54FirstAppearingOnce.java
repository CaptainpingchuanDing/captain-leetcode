package pers.captain.algorithm.offer.five;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 返回值描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class NO54FirstAppearingOnce {

    int[] charTimes = new int[256];
    List<Character> list = new ArrayList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        charTimes[ch]++;
        list.add(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i = 0; i < list.size(); i++) {
            char item = list.get(i);
            if (charTimes[item] == 1) {
                return item;
            }
        }
        return '#';
    }

    @Test
    public void test() {
        Insert('g');
        char res = FirstAppearingOnce();
        Assert.assertEquals(res, 'g');
        Insert('g');
        res = FirstAppearingOnce();
        Assert.assertEquals(res, '#');
    }
}
