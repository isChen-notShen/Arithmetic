package ind.chen.problem;

import java.util.Arrays;

/**
 * 找出数组中三个数，使得三个数的乘积是最大的
 *
 * @author Mr.Chen
 **/
public abstract class MaxProduct {

    public static int sort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    public static int linearSweep(int[] nums) {
        int min2 = Integer.MAX_VALUE, min1 = Integer.MAX_VALUE;
        int max3 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max1 = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x < min2) {
                min1 = min2;
                min2 = x;
            } else if (x < min1) {
                min1 = x;
            }
            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }
        return Math.max(min2 * min1 * max1, max3 * max2 * max1);
    }
}
