package pers.captain.algorithm.last;

public class No22LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String first = strs[0];
        int finalIndex = 0;
        boolean flag = true;
        for (int i = 0; i < first.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() - 1 < i || first.charAt(i) != strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                finalIndex++;
            } else {
                break;
            }
        }
        return first.substring(0, finalIndex);
    }


    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if ("".equals(prefix)) return "";
            }
        return prefix;
    }

    /**
     * 水平扫描
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    /**
     * 分治方法
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix4Fenzi(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix4Fenzi(String[] array, int left, int right) {
        if (left == right) return array[left];
        if (right - left == 1) {
            return commonString(array[left], array[right]);
        }
        int mid = (right - left) / 2 + left;
        String leftCom = longestCommonPrefix4Fenzi(array, left, mid);
        String rightCom = longestCommonPrefix4Fenzi(array, mid + 1, right);
        return commonString(leftCom, rightCom);
    }

    private String commonString(String left, String right) {
        if (left.length() == 0 || right.length() == 0) {
            return "";
        }
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }

        return left.substring(0, min);
    }


    public static void main(String[] args) {

        String temp = "ssdfgff";
        System.out.println(temp.substring(0, 1));
        No22LongestCommonPrefix_14 no22LongestCommonPrefix_14 = new No22LongestCommonPrefix_14();
        String[] strs = new String[4];
        strs[0] = "flight";
        strs[1] = "fight";
        strs[2] = "flag";
        strs[3] = "fetch";
        String result1 = no22LongestCommonPrefix_14.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        String result2 = no22LongestCommonPrefix_14.longestCommonPrefix2(new String[]{"flower", "flow", "flight"});
        String result3 = no22LongestCommonPrefix_14.longestCommonPrefix3(new String[]{"flower", "flow", "flight"});
        String result4 = no22LongestCommonPrefix_14.longestCommonPrefix4(new String[]{"flower", "flow", "flight"});
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);

        System.out.println(temp.indexOf("dfg"));
    }

}
