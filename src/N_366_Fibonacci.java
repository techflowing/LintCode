/**
 * 查找斐波纳契数列中第 N 个数。
 */
public class N_366_Fibonacci {
    public int fibonacci(int n) {
        int a = 0, b = 1, result = 0;
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            for (int i = 3; i <= n; i++) {
                result = a + b;
                a = b;
                b = result;
            }
            return result;
        }
    }
}
