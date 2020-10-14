package pers.captain.algorithm.last;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */
public class No12ZigZagConversion_6 {

    /**
     * 创建numRows个StringBuilder，循环遍历整个字符串，当到达numRows 进行翻转 numRows-2，然后正序进行
     * <p>
     * <p>
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * <p>
     * 0、6、12
     * 4、10、
     */
    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        int reverse = numRows - 2;
        List<StringBuilder> stringBuilderList = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            stringBuilderList.add(new StringBuilder());
        }
        int tag = 0;
        while (tag < s.length()) {
            int normalIndex = 0;
            for (; tag < s.length() && normalIndex < numRows; tag++) {
                stringBuilderList.get(normalIndex).append(s.charAt(tag));
                normalIndex++;
            }
            int reverseIndex = reverse;
            for (; tag < s.length() && 0 < reverseIndex && reverseIndex <= reverse; tag++) {
                stringBuilderList.get(reverseIndex).append(s.charAt(tag));
                reverseIndex--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilderList) {
            result.append(stringBuilder.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3).equals("LCIRETOESIIGEDHN"));
        System.out.println(convert("LEETCODEISHIRING", 4).equals("LDREOEIIECIHNTSG"));
        System.out.println(convert("LEET", 2).equals("LEET"));
    }
}
