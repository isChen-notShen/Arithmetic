package ind.chen;

/**
 * 计算从n以内的素数个数
 *
 * @author Mr.Chen
 **/
public abstract class PrimeNumberCounter {

    public static int direct(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int eratosthenes(int n) {
        boolean[] notPrime = new boolean[n];    //false为素数
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!notPrime[i]){
                count++;
                for (int j =i * i; j < n; j += i) {     //不必从2 * i开始，在i * i之前的已经在之前被计算过了
                    notPrime[j] = true;
                }
            }
        }
        return count;
    }
}
