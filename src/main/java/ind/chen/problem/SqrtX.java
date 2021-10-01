package ind.chen.problem;

/**
 * 求根号x的整数部分
 *
 * @author Mr.Chen
 **/
public abstract class SqrtX {

    public static void main(String[] args) {
        System.out.println(newton(26));
    }

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

    public static int newton(int x) {
        int x1 = x / 2;
        int x2 = (x1 + x / x1) / 2;
        while (x2 != x1) {
            x1 = x2;
            x2 = (x1 + x / x1) / 2;
        }
        return x2;
    }
}
