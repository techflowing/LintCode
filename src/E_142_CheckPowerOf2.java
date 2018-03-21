/**
 * 用 O(1) 时间检测整数 n 是否是 2 的幂次。
 */
public class E_142_CheckPowerOf2 {
    public boolean checkPowerOf2(int n) {
        if (n < 1) {
            return false;
        } else {
            return (n & (n - 1)) == 0;
        }
    }
}
