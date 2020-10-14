package pers.captain.algorithm.last;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 * todo 回朔法
 *  回溯法（back tracking）（探索与回溯法）是一种选优搜索法，又称为试探法，按选优条件向前搜索，以达到目标。
 *  但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。
 *
 */
public class No24LetterCombinationsOfAPhoneNumber_17 {
    static Map<String, List<String>> map = new HashMap<String, List<String>>();

    static {
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
    }

    List<String> output = new ArrayList<String>();

    /**
     * 没有抽象出来递归的方式如何搞
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<String>();
        List<List> characterList = new ArrayList<List>();

        for (int i = 0; i < digits.length(); i++) {
            characterList.add(map.get(digits.charAt(i)));
        }


        return result;
    }

    public List<String> letterCombinations1(String digits) {
        if (digits == null || "".equals(digits)) {
            return new ArrayList<String>();
        }
        combine("", digits);
        return output;
    }

    private void combine(String combination, String nextDigit) {
        if (nextDigit.length() == 0) {
            output.add(combination);
        } else {
            String digit = nextDigit.substring(0, 1);
            List<String> letterList = map.get(digit);

            for (int i = 0; i < letterList.size(); i++) {
                combine(combination + letterList.get(i), nextDigit.substring(1));
            }
        }
    }


    public static void main(String[] args) {
        No24LetterCombinationsOfAPhoneNumber_17 combinations = new No24LetterCombinationsOfAPhoneNumber_17();
        List<String> result1 = combinations.letterCombinations1("23");
        System.out.println(JSON.toJSONString(result1));

        System.out.println("2".substring(0, 1));
    }

}
