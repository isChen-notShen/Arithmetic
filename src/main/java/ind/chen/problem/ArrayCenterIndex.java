package ind.chen.problem;

import java.util.Arrays;

/**
 * 找到数组的中心点， 使中心点左右的和相等
 * @author Mr.Chen
 **/
public abstract class ArrayCenterIndex {

    public static int pivotIndex(int[] nums){
        int sum = Arrays.stream(nums).sum();
        int totalLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            totalLeft += nums[i];
            if (totalLeft == sum){
                return i;
            }
            sum -= nums[i];
        }
        return -1;
    }
}
