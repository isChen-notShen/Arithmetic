package ind.chen.util;

import edu.princeton.cs.algs4.StdRandom;
import ind.chen.sort.Sort;

/**
 * @Description 辅助类SortCompare用于比较排序算法的性能差异
 * @Author Mr.Chen
 * @Create 2021-04-13
 **/
public class SortCompare {
    private static final ArithmeticTimer timer = new ArithmeticTimer();
    public static final String SELECT_SORT = "selectSort";
    public static final String INSERTION_SORT = "insertionSort";
    public static final String SHELL_SORT = "shellSort";
    public static final String MERGE_SORT = "mergeSort";
    public static final String BOTTOM_UP_MERGE_SORT = "bottomUpMergeSort";
    public static final String QUICK_SORT = "quickSort";

    public static <T extends Comparable<T>> double time(String alg, T[] ts) {
        timer.start();
        switch (alg) {
            case SELECT_SORT:
                Sort.selectSort(ts);
                break;
            case INSERTION_SORT:
                Sort.insertionSort(ts);
                break;
            case SHELL_SORT:
                Sort.shellSort(ts);
                break;
            case MERGE_SORT:
                Sort.mergeSort(ts);
                break;
            case BOTTOM_UP_MERGE_SORT:
                Sort.bottomUpMergeSort(ts);
                break;
            case QUICK_SORT:
                Sort.quickSort(ts);
                break;
        }
        double time = timer.elapsedTime();
        timer.reset();
        return time;
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }
}
