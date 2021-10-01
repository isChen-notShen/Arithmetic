package ind.chen.problem;

/**
 * 求取n下标的斐波那契数列值
 *
 * @author Mr.Chen
 **/
public abstract class Fibonacci {

    public static void main(String[] args) {
        System.out.println(iteration(10));
    }

    public static int recursion(int n) {
        int[] auxiliary = new int[n + 1];
        return recursion(auxiliary, n);
    }

    private static int recursion(int[] auxiliary, int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (auxiliary[n] != 0) {
            return auxiliary[n];
        }
        auxiliary[n] = recursion(auxiliary, n - 1) + recursion(auxiliary, n - 2);
        return auxiliary[n];
    }

    public static int iteration(int n) {
        int low = 0, high = 1, sum = -1;
        if (n == 0 || n == 1) {
            return n;
        }
        while (n-- >= 2) {
            sum = low + high;
            low = high;
            high = sum;
        }
        return sum;
    }
}
