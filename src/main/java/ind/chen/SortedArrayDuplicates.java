package ind.chen;

/**
 * 对已经排序的数组，在原地删除其重复项，要求空间复杂度为O(1)，并返回删除重复项后的数组长度
 *
 * @author Mr.Chen
 **/
public abstract class SortedArrayDuplicates {

    /**
     * @param nums 已经排序的数组
     * @Description 双指针去除重复项
     * @Return 去除重复项后的数组长度
     * @Date 2021/9/15
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
