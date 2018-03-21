/**
 * 如果要将整数A转换为B，需要改变多少个bit位？
 */
public class E_181_BitSwapRequired {
    public static int bitSwapRequired(int a, int b) {
        int x = a ^ b;
        int count = 0;
        while (x != 0) {
            if ((x & 1) == 1) {
                count++;
            }
            x = x >>> 1;
        }
        return count;
    }
}
