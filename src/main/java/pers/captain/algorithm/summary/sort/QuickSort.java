package pers.captain.algorithm.summary.sort;

import org.junit.Test;
import pers.captain.algorithm.CapL;

public class QuickSort {


    private int partition(int[] a, int lo, int hi) {
        int v = a[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (v > a[++i]) if (i == hi) break;
            while (v < a[--j]) if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void sort(int a[], int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j+1, hi);
    }

    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    @Test
    public void sort(){
        int[] a = new int[]{2,3,5,1,7,8,6};
        sort(a);
        CapL.print(a);
    }
}
