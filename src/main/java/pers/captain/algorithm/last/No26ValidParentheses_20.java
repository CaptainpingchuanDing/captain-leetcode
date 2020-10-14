package pers.captain.algorithm.last;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class No26ValidParentheses_20 {

//    private List<String> stringList = new ArrayList<String>();

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean result = true;
        int size = s.length();
        int tmp = 0;
        int changeFlag = 0;
        boolean findOneFlag = false;
        for (int i = 0; i < size; i++) {
            if ((s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')) {
                changeFlag = 1;
            } else {
                if (changeFlag == 1) {
                    changeFlag = 0;
                    result = result && isSubStrValid(s.substring(tmp, i));
                    tmp = i;
                    findOneFlag = true;
                }
            }
            if (i == size - 1 && tmp != i) {
                result = result && isSubStrValid(s.substring(tmp, i + 1));
                findOneFlag = true;
            }

        }
        return result && findOneFlag;

    }


    private boolean isSubStrValid(String subStr) {
        boolean flag;
        if (subStr == null || subStr.length() < 1) {
            return true;
        } else {
            while (subStr.charAt(0) == ' ') {
                subStr = subStr.substring(1);
            }
            while (subStr.length() > 0 && subStr.charAt(subStr.length() - 1) == ' ') {
                subStr = subStr.substring(0, subStr.length() - 1);
            }

            if (subStr.charAt(0) == '(' && subStr.charAt(subStr.length() - 1) == ')') {
                flag = true;
            } else if (subStr.charAt(0) == '{' && subStr.charAt(subStr.length() - 1) == '}') {
                flag = true;
            } else if (subStr.charAt(0) == '[' && subStr.charAt(subStr.length() - 1) == ']') {
                flag = true;
            } else {
                flag = false;
            }
        }

        if (flag) {
            return isSubStrValid(subStr.substring(1, subStr.length() - 1));
        } else {
            return false;
        }
    }


    /**
     * 利用栈来
     *
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        boolean result = false;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            char currentChar = s.charAt(i);
            if (map.containsKey(currentChar)) {
                stack.push(currentChar);
            } else {
                if (stack.isEmpty()) {
                    result = false;
                    break;
                } else {
                    char pChar = stack.pop();
                    if (map.get(pChar) != currentChar) {
                        result = false;
                        break;
                    } else {
                        result = true;
                    }
                }

            }
        }
        if(!stack.isEmpty()){
            result = false;
        }
        return result;

    }


    public static void main(String[] args) {
        No26ValidParentheses_20 no26ValidParentheses_20 = new No26ValidParentheses_20();
        boolean result = no26ValidParentheses_20.isValid1("()[]{}");
        boolean result1 = no26ValidParentheses_20.isValid1("([)]");
        boolean result2 = no26ValidParentheses_20.isValid1("{[]}");
        boolean result3 = no26ValidParentheses_20.isValid1("{");
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
