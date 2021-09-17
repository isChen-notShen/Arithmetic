package ind.chen;

/**
 * 给定一个数组，找出平均值最大的连续长度为k的子数组。返回其平均值
 *
 * @author Mr.Chen
 **/
public abstract class MaxAverage {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (k > nums.length) {
            throw new IllegalArgumentException("k 不能大于数组的长度");
        }
        if (k <= 0) {
            throw new IllegalArgumentException("k 不能小于等于0");
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int newSum = sum;
        for (int i = 1; i + k - 1 < nums.length; i++) {
            newSum = newSum - nums[i - 1] + nums[i + k - 1];
            if (newSum > sum) {
                sum = newSum;
            }
        }
        return 1.0 * sum / k;
    }
}
