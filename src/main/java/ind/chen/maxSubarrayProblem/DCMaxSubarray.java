package ind.chen.maxSubarrayProblem;

import java.util.Random;

/**
 * 采用分治法解决(Divide and Conquer)
 * @author ChenShiLi
 */
public abstract class DCMaxSubarray {

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10000];
        float flag;
        for (int i = 0; i < a.length; i++) {
            flag = random.nextFloat();
            a[i] = flag > 0.5 ? random.nextInt(5000) : -random.nextInt(5000);
        }
//        for (int i : a) {
//            System.out.print(i + " ");
//        }
        long before = System.currentTimeMillis();
        Triplet result = findMaxSubarray(a, 0, a.length - 1);
        long after = System.currentTimeMillis();
//        System.out.println("\n" + result);
        System.out.println(after - before);
    }

    /**
     * 该方法用于寻找和最大子数组，采用了分治法
     *
     * @param a    父数组
     * @param low  低位下标
     * @param high 高位下标
     * @return 返回一个包含子数组下标与和的三元组
     */
    public static Triplet findMaxSubarray(int[] a, int low, int high) {
        /* base case */
        if (low == high)
            return new Triplet(low, high, a[low]);

        int mid = (high + low) / 2;
        Triplet maxLeft = findMaxSubarray(a, low, mid);
        Triplet maxRight = findMaxSubarray(a, mid + 1, high);
        Triplet maxCrossing = findMaxCrossingSubarray(a, low, mid, high);
        if (maxLeft.sum >= maxRight.sum && maxLeft.sum >= maxCrossing.sum) {
            return maxLeft;
        } else if (maxRight.sum >= maxLeft.sum && maxRight.sum >= maxCrossing.sum) {
            return maxRight;
        } else
            return maxCrossing;
    }

    /**
     * 该方法是一个辅助性方法，查找快过中点的最大子数组。该子数组最小为A[mid, mid + 1]
     *
     * @param high 高位下标,严格遵循数组下标规范
     * @param low  低位下标，严格遵循数组下标规范
     * @param a    需要寻找跨越中点的最大子数组的数组
     */
    private static Triplet findMaxCrossingSubarray(int[] a, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;
        int maxRight = mid + 1;
        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += a[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        return new Triplet(maxLeft, maxRight, leftSum + rightSum);
    }
}