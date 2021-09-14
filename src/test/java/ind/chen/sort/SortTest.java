package ind.chen.sort;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    @Test
    public void selectSort() {
        Integer[] a = new Integer[20];
        for (int i = 0; i < 20; i++) {
            a[i] = StdRandom.uniform(0, 31);
        }
        Sort.selectSort(a);
    }

    @Test
    public void insertionSort() {
        Integer[] a = new Integer[20];
        for (int i = 0; i < 20; i++) {
            a[i] = StdRandom.uniform(0, 31);
        }
        Sort.insertionSort(a);
        System.out.println("数组是否排序成功: " + Sort.isSorted(a));
    }

    @Test
    public void shellSort() {
        Integer[] a = new Integer[20];
        for (int i = 0; i < 20; i++) {
            a[i] = StdRandom.uniform(0, 31);
        }
        Sort.shellSort(a);
    }

    @Test
    public void mergeSort() {
        Integer[] a = new Integer[20];
        for (int i = 0; i < 20; i++) {
            a[i] = StdRandom.uniform(0, 31);
        }
        Integer[] backup = new Integer[20];
        System.arraycopy(a, 0, backup, 0, a.length);
        Sort.mergeSort(a);
        Sort.shellSort(backup);
        System.out.println("数组是否排序成功: " + Arrays.equals(a, backup));
    }

    @Test
    public void bottomUpMergeSort() {
        Integer[] a = new Integer[20];
        for (int i = 0; i < 20; i++) {
            a[i] = StdRandom.uniform(0, 31);
        }
        Integer[] backup = new Integer[20];
        System.arraycopy(a, 0, backup, 0, a.length);
        Sort.bottomUpMergeSort(a);
        Sort.shellSort(backup);
        System.out.println("数组是否排序成功: " + Arrays.equals(a, backup));
    }

    @Test
    public void quickSort() {
        Integer[] a = new Integer[20];
        for (int i = 0; i < 20; i++) {
            a[i] = StdRandom.uniform(0, 31);
        }
        Sort.quickSort(a);
    }
}