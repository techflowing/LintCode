/**
 * 将一个整数中的数字进行颠倒，当颠倒后的整数溢出时，返回 0 (标记为 32 位整数)。
 */
public class E_413_ReverseInteger {
    public int reverseInteger(int n) {
        long result = 0;
        while (n != 0) {
            result = result * 10 + n % 10;
            n = n / 10;
        }
        if (result <= Integer.MIN_VALUE || result >= Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;
    }
}
