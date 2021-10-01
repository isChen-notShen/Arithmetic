package ind.chen.problem;

import java.util.Arrays;

/**
 * 合并有序数组nums1，nums2。假定nums1大小足够容纳nums1 + nums2。合并后的nums1有序
 *
 * @author Mr.Chen
 **/
public abstract class MargeSortedArray {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 7, 9, 0, 0, 0, 0, 0};
        int[] b = new int[]{2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(merge(a, 5, b, 5)));
    }

    public static int[] merge(int[] a, int aLength, int[] b, int bLength) {
        int aIndex = aLength - 1, bIndex = bLength - 1, endIndex = aLength + bLength - 1;
        while (aIndex >= 0 && bIndex >= 0) {
            if (a[aIndex] < b[bIndex]) {
                a[endIndex--] = b[bIndex--];
            } else {
                a[endIndex--] = a[aIndex--];
            }
        }
        while (bIndex >= 0) {
            a[endIndex--] = b[bIndex--];
        }
        return a;
    }
}
