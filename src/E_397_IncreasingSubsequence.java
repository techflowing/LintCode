/**
 * 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。
 * （最长上升连续子序列可以定义为从右到左或从左到右的序列。）
 */
public class E_397_IncreasingSubsequence {
    /**
     * 连续上升序列
     * 只需要比较相邻数即可，升序或者降序
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int increase = 1;
        int decrease = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] <= A[i + 1]) {
                increase++;
            } else {
                result = result > increase ? result : increase;
                increase = 1;
            }
            if (A[i] >= A[i + 1]) {
                decrease++;
            } else {
                result = result > decrease ? result : decrease;
                decrease = 1;
            }
        }
        result = result > increase ? result : increase;
        result = result > decrease ? result : decrease;
        return result;
    }
}
