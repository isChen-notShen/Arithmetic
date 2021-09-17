package ind.chen;

import java.util.HashMap;
import java.util.Map;

/**
 * 寻找数组中的两个数，使其和等于目标数，并返回两数下标，下标不能相等。假定结果唯一。
 *
 * @author Mr.Chen
 **/
public abstract class FindSum {

    public static int[] bf(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] marked(int[] nums, int target) {
        Map<Integer, Integer> mark = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mark.containsKey(target - nums[i])) {
                return new int[]{mark.get(target - nums[i]), i};
            }
            mark.put(nums[i], i);
        }
        return null;
    }

    public static int[] binarySearch(int[] sorted, int target) {
        for (int i = 0; i < sorted.length; i++) {
            int low = i, high = sorted.length - 1, mid;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (mid == target - sorted[i]) {
                    return new int[]{i, mid};
                } else if (mid < target - sorted[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return null;
    }

    public static int[] twoPoint(int[] sorted, int target) {
        int left = 0, right = sorted.length - 1;
        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left, right};
            }
        }
        return null;
    }
}
