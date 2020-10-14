package pers.captain.algorithm.last;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0
 */
public class No7AddBinary_67 {

    public static String addBinary(String a, String b) {

        if (a == null || b == null) {
            return null;
        }
        int carry = 0;
        StringBuilder result = new StringBuilder();
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        for (int i = a.length() - 1; i >= 0 || carry > 0; i--) {
            int k = i - (a.length() - b.length());
            if (0 <= k && k < b.length()) {
                int sum = a.charAt(i) - '0' + b.charAt(k) - '0' + carry;
                result.append(sum % 2);
                carry = sum / 2;
            } else {
                if (0 <= i && i < a.length()) {
                    int sum = a.charAt(i) - '0' + carry;
                    result.append(sum % 2);
                    carry = sum / 2;
                } else {
                    result.append(carry);
                    break;
                }
            }
        }

        return result.reverse().toString();
    }

    public static String addBinary1(String a, String b) {

        if (a == null || b == null) {
            return null;
        }
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            if (i >= 0 && j >= 0) {
                int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
                result.append(sum % 2);
                carry = sum / 2;
            } else if (i >= 0) {
                int sum = a.charAt(i) - '0' + carry;
                result.append(sum % 2);
                carry = sum / 2;
            } else if (j >= 0) {
                int sum = b.charAt(j) - '0' + carry;
                result.append(sum % 2);
                carry = sum / 2;
            } else {
                result.append(carry);
                break;
            }
        }

        return result.reverse().toString();
    }

    public static String addBinary2(String a, String b) {

        if (a == null || b == null) {
            return null;
        }
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            int x = i < 0 ? 0 : a.charAt(i) - '0';
            int y = j < 0 ? 0 : b.charAt(j) - '0';
            int sum = x + y + carry;
            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(addBinary("1011", "111"));
        System.out.println(addBinary1("1011", "111"));
        System.out.println(addBinary2("1011", "111"));
    }
}
