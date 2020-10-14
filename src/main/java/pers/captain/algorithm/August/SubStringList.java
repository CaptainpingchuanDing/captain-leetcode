package pers.captain.algorithm.August;

import java.util.ArrayList;
import java.util.List;

public class SubStringList {
    public static List<ArrayList<Integer>> subList(int[] array) {

        List<ArrayList<Integer>> result = new ArrayList<>();
        if (array == null || array.length == 0) return result;
        subListHelper(0, result, new ArrayList<Integer>(), array);
        return result;
    }

    public static void subListHelper(int curIndex, List<ArrayList<Integer>> result, List<Integer> current, int[] array) {
        if (curIndex == array.length) {
            result.add(new ArrayList<>(current));
        } else {
            subListHelper(curIndex + 1, result, current, array);
            current.add(array[curIndex]);
            subListHelper(curIndex + 1, result, current, array);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(subList(arr));

        int[] arr1 = new int[]{1, 2, 2};
        System.out.println(subListDup(arr1));

    }

    public static List<ArrayList<Integer>> subListDup(int[] array) {

        List<ArrayList<Integer>> result = new ArrayList<>();
        if (array == null || array.length == 0) return result;
        subListDupHelper(0, true, result, new ArrayList<Integer>(), array);
        return result;
    }

    public static void subListDupHelper(int curIndex, boolean token, List<ArrayList<Integer>> result, List<Integer> current, int[] array) {
        if (curIndex == array.length) {
            result.add(new ArrayList<>(current));
        } else {
            subListDupHelper(curIndex + 1, false, result, current, array);
            if (token || array[curIndex] != array[curIndex - 1]) {
                current.add(array[curIndex]);
                subListDupHelper(curIndex + 1, true, result, current, array);
                current.remove(current.size() - 1);
            }
        }
    }
}
