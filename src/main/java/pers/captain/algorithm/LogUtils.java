package pers.captain.algorithm;

public class LogUtils {

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

    public static void print(String str){
        System.out.print(str);
    }

    public static void main(String[] args) {

    }
}
