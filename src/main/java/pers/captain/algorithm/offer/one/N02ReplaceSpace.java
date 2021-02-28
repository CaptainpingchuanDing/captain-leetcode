package pers.captain.algorithm.offer.one;

import org.junit.Test;
import pers.captain.algorithm.CapL;

/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class N02ReplaceSpace {

    /**
     * 方法一: 使用stringBuilder
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 方法二 使用string 的方法
     * @param str
     * @return
     */
    public String replaceSpace2(String str) {
        if (str == null || str.length() == 0) return "";
        return str.replaceAll(" ", "%20");
    }

    @Test
    public void replaceSpace() {
        StringBuffer stringBuilder = new StringBuffer("We Are Happy");
       String res =  replaceSpace(stringBuilder);
        CapL.print(res);
    }
}
