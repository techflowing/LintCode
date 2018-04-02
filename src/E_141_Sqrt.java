/**
 * 实现 int sqrt(int x) 函数，计算并返回 x 的平方根。
 */
public class E_141_Sqrt {
    public int sqrt(int x) {
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
}
