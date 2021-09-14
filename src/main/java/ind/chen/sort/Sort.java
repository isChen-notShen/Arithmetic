package ind.chen.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.lang.reflect.Array;

/**
 * @Description Sort类是一个辅助类，提供各种用于排序的静态方法
 * @Author Mr.Chen
 * @Create 2021-04-12
 **/
public abstract class Sort {

    public static <T extends Comparable<T>> void quickSort(T[] ts) {
        StdRandom.shuffle(ts);
        //show(ts);
        quickSort(ts, 0, ts.length - 1);
        //show(ts);
    }

    private static <T extends Comparable<T>> void quickSort(T[] ts, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(ts, lo, hi);
        quickSort(ts, lo, j - 1);
        quickSort(ts, j + 1, hi);
    }

    private static <T extends Comparable<T>> int partition(T[] ts, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        T element = ts[lo];
        while (true) {
            while (less(ts[++i], element)) if (i == hi) break;
            while (less(element, ts[--j])) if (j == lo) break;
            if (i >= j) break;
            exchange(ts, i, j);
        }
        exchange(ts, lo, j);
        return j;
    }

    /**
     * @param ts 待排序的数组，要求实现Comparable接口
     * @Description selectSort的时间复杂的为Θ(n ^ 2)，空间复杂度为O(1)，且SelectSort是与输入序列无关的，即便是全排序的数组，也会花费
     * 同样的时间。SelectSort的原理是判断第i项是否为第i+1小的元素，如果不是就将其后的最小项放入该位置
     * @Date 2021/4/13
     */
    public static <T extends Comparable<T>> void selectSort(T[] ts) {
        int length = ts.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(ts[j], ts[min])) min = j;
            }
            exchange(ts, i, min);
        }
    }

    /**
     * @param ts 待排序的数组，要求实现Comparable接口
     * @Description insertionSort的时间复杂度为O(n ^ 2)，空间复杂度为Θ(1)，但在某些特定输入下，插入排序运行的比选择排序更快。
     * 算法是保证数组的ts[0]~ts[i-1]项是有序的，之后将ts[i]与前面的项比较交换。最终循环结束后ts[0]~ts[ts.length-1]项就是有序的
     * @Date 2021/4/13
     */
    public static <T extends Comparable<T>> void insertionSort(T[] ts) {
//        int length = ts.length;
//        for (int i = 1; i < length; i++) {
//            for (int j = i; j > 0 && less(ts[j], ts[j - 1]); j--) {
//                exchange(ts, j, j - 1);
//            }
//        }
        insertionSort(ts, 0, ts.length - 1);
    }

    private static <T extends Comparable<T>> void insertionSort(T[] ts, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && less(ts[j], ts[j - 1]); j--) {
                exchange(ts, j, j - 1);
            }
        }
    }

    /**
     * @param ts 待排序的数组，要求实现Comparable接口
     * @Description ShellSort算法，通过设置间隔gap，来产生gap有序子数组，并在之后缩小gap,直至整个数组有序。该算法比插入排序更加高效，
     * 因为它权衡了子数组的规模和有序性。在排序之初，数组虽然无序但，规模很小，在经过初步的排序后，子数组规模虽然扩大，但已经相对有序
     * ShellSort的时间复杂度不容易确定，但可以保证它是比平方级要小
     * @Return void
     * @Date 2021/4/13
     */
    public static <T extends Comparable<T>> void shellSort(T[] ts) {
        int length = ts.length;
        int gap = 1;
        //下列循环代表着shellSort的递增序列，排序过程将按照该序列的gap值进行
        //while的条件并不会影响shellSort的正确性
        while (gap < length / 3) gap = 3 * gap + 1;
        while (gap >= 1) {
            for (int i = gap; i < length; i++) {
                //将ts[i]插入到ts[i-gap]、ts[i-2*gap]、ts[i-3*gap]......之中
                //j >= gap保证了交换不会出现越界
                for (int j = i; j >= gap && less(ts[j], ts[j - gap]); j -= gap) {
                    exchange(ts, j, j - gap);
                }
            }
            gap /= 3;
        }
    }

    /**
     * @param ts 待排序的数组
     * @Description mergeSort有着Θ(NlgN)的性能，但空间复杂度是Θ(N)，不适合用于大数组的排序。
     * 归并排序的原理，是将数组划分为左右两个子数组，再对子数组进行归并排序，之后将排序后的左右子数组合并
     * @Date 2021/4/15
     */
    public static <T extends Comparable<T>> void mergeSort(T[] ts) {
        T[] aux = ts.clone();
        mergeSort(ts, aux, 0, ts.length - 1);
    }

    /**
     * @param ts 代排序的数组
     * @Description bottomUpMergeSort算法同样是归并算法，但采用的是自底向上的思想，即迭代法。和递归的归并算法相比，不会大量占有栈空间。
     * 但执行的速度比优化后的递归归并算法要慢。理论上的时间空间复杂度与递归的归并算法相同
     * @Return void
     * @Date 2021/4/15
     */
    public static <T extends Comparable<T>> void bottomUpMergeSort(T[] ts) {
        int length = ts.length;
        T[] aux = (T[]) Array.newInstance(ts.getClass().getComponentType(), length);
        //show(ts);
        for (int sz = 1; sz < length; sz += sz) {
            for (int lo = 0; lo < length - sz; lo += sz + sz) {
                BottomUpMerge(ts, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, length - 1));
            }
        }
        //show(ts);
    }

    private static <T extends Comparable<T>> void BottomUpMerge(T[] ts, T[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        if (hi + 1 - lo >= 0) System.arraycopy(ts, lo, aux, lo, hi + 1 - lo);
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                ts[k] = aux[j++];
            else if (j > hi)
                ts[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                ts[k] = aux[j++];
            else
                ts[k] = aux[i++];
        }
    }

    private static <T extends Comparable<T>> void mergeSort(T[] ts, T[] aux, int lo, int hi) {
        //if (lo >= hi) return;

        //改进:使用插入排序，对较小的子数组进行排序
        if (hi - lo <= 14) {
            insertionSort(ts, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        //切换角色，将排序好的子数组放入辅助数组
        mergeSort(aux, ts, lo, mid);
        mergeSort(aux, ts, mid + 1, hi);

        //改进:跳过两个数组已经有序的情况
        if (!less(aux[mid + 1], aux[mid])) {
            System.arraycopy(aux, lo, ts, lo, hi - lo + 1);
            return;
        }
        merge(ts, aux, lo, mid, hi);
    }

    private static <T extends Comparable<T>> void merge(T[] ts, T[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        //改进:减少每次将数据复制到辅助数组的时间
        //if (hi + 1 - lo >= 0) System.arraycopy(ts, lo, aux, lo, hi + 1 - lo);
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                ts[k] = aux[j++];
            else if (j > hi)
                ts[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                ts[k] = aux[j++];
            else
                ts[k] = aux[i++];
        }
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] ts) {
        for (int i = 1; i < ts.length; i++) {
            if (less(ts[i], ts[i - 1])) return false;
        }
        return true;
    }

    private static <T extends Comparable<T>> void exchange(T[] c, int i, int j) {
        T t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    private static <T extends Comparable<T>> void show(T[] ts) {
        for (T t : ts) {
            StdOut.print(t + " ");
        }
        StdOut.println();
    }
}