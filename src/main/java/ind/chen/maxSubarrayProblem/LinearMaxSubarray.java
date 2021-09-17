package ind.chen.maxSubarrayProblem;

import java.util.Random;

public abstract class LinearMaxSubarray {

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];
        float flag;
        for (int i = 0; i < a.length; i++) {
            flag = random.nextFloat();
            a[i] = flag > 0.5 ? random.nextInt(20) : -random.nextInt(20);
        }
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        //long before = System.currentTimeMillis();
        Triplet resultA = findMaxSubarray(a, 0, a.length - 1);
        //Triplet result = findMaxSubarray(a, 0, a.length - 1, 3);
        //long after = System.currentTimeMillis();
        System.out.println("\n" + resultA);
        //System.out.println(after - before);
    }

    /**
     * 动态规划算法
     * 这是一个非递归，线性时间的最大子数组算法。本算法的关键思想在于如果前面i个元素的最大子数组找到了，那么前i+1个元素的最大子数组有两种可能
     * 第一种： 前i+1个元素的最大子数组就是前i个元素的最大子数组
     * 第二种： 前i+1个元素的最大子数组是一个包含第i+1个元素的子数组
     * 对于第二种情况，如果知道包含第i个元素的x~i的子数组是1~i中包含第i个元素的数组的最大子数组，那么1~i+1的中包含i+1的最大子数组，要么是x~i+1,要么是第i+1个元素
     * 自身。
     *
     * @param a    父数组
     * @param low  低位下标
     * @param high 高位下标
     * @return 返回包含最大子数组边界和元素和的三元组
     */
    public static Triplet findMaxSubarray(int[] a, int low, int high) {
        Triplet maxSubarray = new Triplet(low, low, a[low]);

        int backLowIndex = low;
        int backHighIndex;
        int sumOfBackMaxSubarray = a[low];
        for (int i = low; i < high; i++) {
            if (sumOfBackMaxSubarray + a[i + 1] > a[i + 1]) {
                sumOfBackMaxSubarray += a[i + 1];
            } else {
                sumOfBackMaxSubarray = a[i + 1];
                backLowIndex = i + 1;
            }
            backHighIndex = i + 1;
            if (maxSubarray.sum < sumOfBackMaxSubarray) {
                maxSubarray.sum = sumOfBackMaxSubarray;
                maxSubarray.maxLeft = backLowIndex;
                maxSubarray.maxRight = backHighIndex;
            }
        }
        return maxSubarray;
    }

    public static Triplet findMaxSubarray(int[] a, int low, int high, int k) {

        Triplet maxSubarray = new Triplet(low, low, a[low]);

        int offset = k;
        int backLowIndex = low;
        int backHighIndex;
        int sumOfBackMaxSubarray = a[low];
        for (int i = low; i < high; i++) {
            if (sumOfBackMaxSubarray + a[i + 1] > a[i + 1] && --offset >= 0) {
                sumOfBackMaxSubarray += a[i + 1];
            } else {
                offset = k;
                sumOfBackMaxSubarray = a[i + 1];
                backLowIndex = i + 1;
            }
            backHighIndex = i + 1;
            if (maxSubarray.sum < sumOfBackMaxSubarray) {
                maxSubarray.sum = sumOfBackMaxSubarray;
                maxSubarray.maxLeft = backLowIndex;
                maxSubarray.maxRight = backHighIndex;
            }
        }
        return maxSubarray;
    }
}