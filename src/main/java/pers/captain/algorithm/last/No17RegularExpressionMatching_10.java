package pers.captain.algorithm.last;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
public class No17RegularExpressionMatching_10 {

    /**
     * s是p的一部分， p个元素开始遍历找到匹配s的字符，当遇到 * 的时候（另个或者多个前面的字符串），当遇到.的时候 表示任意字符
     * 两个指针遍历整个字符串
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        while (sIndex < s.length() && pIndex < p.length()) {
            if (s.charAt(sIndex) != p.charAt(pIndex)) {//两个元素不相等时，再看一下p的下一个元素是否是*，如果是* p+2 s+1 继续，否则返回false
                if (p.charAt(pIndex) == '*') {
                    if (pIndex - 1 >= 0 && p.charAt(pIndex - 1) == s.charAt(sIndex)) {
                        if (sIndex < s.length() - 1) {
                            return isMatch(s.substring(sIndex + 1, s.length()), p.substring(pIndex - 1, p.length()));
                        }
                    } else if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == s.charAt(sIndex)) {
//                        return isMatch();
                        pIndex++;
                    } else if (pIndex - 1 >= 0 && p.charAt(pIndex - 1) == '.') {
                        pIndex++;
                        sIndex++;
                    } else {
                        return false;
                    }
                } else if (p.charAt(pIndex) == '.') {
                    sIndex++;
                    pIndex++;
                } else {
                    if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
                        sIndex++;
                        pIndex += 2;
                    } else {
                        return false;
                    }
                }
            } else {
                sIndex++;
                pIndex++;
            }
        }
        return (sIndex == s.length()) && (pIndex == p.length());
    }

    /**
     * 递归调用，暴力解法
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch1(String s, String p) {
        if (s == null && p == null) return true;
        if (s.length() == 0 && p.length() == 0) return true;

        boolean firstMatch = false;

        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
            firstMatch = true;
        }

        boolean resMatch = false;
        if (s.length() >= 2 && p.length() >= 2) {
            if (p.charAt(1) == '*') {
                if (p.length() > 2) {
                    resMatch = isMatch1(s, p.substring(2, p.length())) || // * 略过
                            isMatch1(s.substring(1, s.length()), p);// * 重复
                } else {
                    resMatch = isMatch1(s, "") || isMatch1(s.substring(1, s.length()), p);// * 重复;
                }
            } else {
                resMatch = isMatch1(s.substring(1, s.length()), p.substring(1, p.length()));
            }
        }

        return firstMatch && resMatch;
    }


    private String pattern;
    private String text;
    private Boolean[][] dp;

    /**
     * 动态规划
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        if (s == null) s = new String();
        if (p == null) p = new String();
        //空的正则串不能匹配s
        if (s.length() != 0 && p.length() == 0) return false;
        //空正则串可以匹配空s
        if (s.length() == 0 && p.length() == 0) return true;

        //非空正则不一定可以匹配空s或非空s
        //此处由于要处理 * 使用递归解法
        this.text = s;
        this.pattern = p;
        this.dp = new Boolean[s.length() + 1][p.length() + 1];
        return recur(0, 0);
    }

    //i为text的索引,j为pattern的索引
    private boolean recur(int i, int j) {
        if (j < pattern.length() && i < text.length() && dp[i][j] != null) return dp[i][j];
        //正则串为空
        if (j == pattern.length()) return dp[i][j] = (i == text.length());
        //正则串非空 匹配串为空
        if (i == text.length()) {
            //只可能*取0重才可能为真
            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                dp[i][j] = recur(i, j + 2);//正则串去掉两个
            } else {
                dp[i][j] = false;
            }
        } else {//正则串非空 匹配串非空
            //当前字符是否匹配
            boolean match = pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.';
            if (j + 2 <= pattern.length() && pattern.charAt(j + 1) == '*') {
                dp[i][j] = (match & recur(i + 1, j)) ||//当前匹配了,看text的下个字符是否还可以用*匹配
                        (recur(i, j + 2));//当前不匹配,*取0此重复
            } else {
                dp[i][j] = match & recur(i + 1, j + 1);
            }
        }
        return dp[i][j];
    }

    public static boolean isMatch3(String s, String p) {
        if (s == null && p == null) return true;
        if (s.equals(p)) return true;// 都空空或者完全相同

        boolean first = (s.length() > 0 && p.length() > 0)
                && ((p.charAt(0) == s.charAt(0)) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            if (p.length() == 2) {
                if (s.length() == 1) {
                    return isMatch3(s, "") ||
                            (first && isMatch3("", p));
                } else {
                    return isMatch3(s, "") ||
                            (first && isMatch3(s.substring(1, s.length()), p));
                }
            } else {
                if (s.length() == 1) {
                    return isMatch3(s, p.substring(2, p.length())) ||
                            (first && isMatch3("", p));
                } else {
                    return isMatch3(s, p.substring(2, p.length())) ||
                            (first && isMatch3(s.substring(1, s.length()), p));
                }
            }

        } else {
            if (p.length() == 1) {
                if (s.length() == 1) {
                    return first;
                } else {
                    return false;
                }
            } else {
                if (s.length() == 1) {
                    return first && isMatch3("", p.substring(1, p.length()));
                } else {
                    return first && isMatch3(s.substring(1, s.length()), p.substring(1, p.length()));
                }
            }

        }
    }


    public static boolean isMatch4(String s, String p) {
        if (s == null && p == null) return true;
        if (s.equals(p)) return true;// 都空空或者完全相同

        boolean first = (s.length() > 0 && p.length() > 0)
                && ((p.charAt(0) == s.charAt(0)) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {

            return isMatch4(s, mySubString(p, 2)) ||
                    (first && isMatch4(mySubString(s, 1), p));


        } else {
            return first && isMatch4(mySubString(s, 1), mySubString(p, 1));
        }
    }

    private static String mySubString(String input, int start) {
        if (start >= input.length()) {
            return "";
        } else {
            return input.substring(start, input.length());
        }
    }

    public static void main(String[] args) {
        System.out.println(mySubString("234", 1));
//        System.out.println(new No17RegularExpressionMatching_10().isMatch2("mississippi", "mis*is*p*."));
//        System.out.println(isMatch3("mississippi", "mis*is*p*."));
        System.out.println(isMatch3("ab", ".*"));
        System.out.println(isMatch4("ab", ".*"));
//        System.out.println(isMatch1("mississippi", "mis*is*p*."));
//        System.out.println(isMatch1("ab", ".*"));
        System.out.println(new No17RegularExpressionMatching_10().isMatch2("aab", "c*a*b"));
//        System.out.println(isMatch1("aa", "a*"));
    }
}
