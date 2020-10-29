package pers.captain.algorithm;

import java.util.List;

public class CapL {

    public static void printArray(int[] array) {
        if (array == null) {
            System.out.println(" array is null");
        } else if (array.length == 0) {
            System.out.println(" array is empty");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (int num : array) {
                stringBuilder.append(num + ",");
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            stringBuilder.append("]");
            System.out.println(stringBuilder.toString());
        }
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static void print(List list) {
        System.out.print(list.toString());
    }

    public static void print(int num) {
        System.out.print(num);
    }

    public static void main(String[] args) {

    }
}
