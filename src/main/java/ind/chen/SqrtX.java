package ind.chen;

/**
 * 求根号x的整数部分
 *
 * @author Mr.Chen
 **/
public abstract class SqrtX {

    public static int binarySearch(int x) {
        int result = -1, l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid <= x) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
