/**
 * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
 * 如果有4个物品[2, 3, 5, 7]
 * <p>
 * 如果背包的大小为11，可以选择[2, 3, 5]装入背包，最多可以装满10的空间。
 * <p>
 * 如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。
 * <p>
 * 函数需要返回最多能装满的空间大小。
 */
public class M_092_BackPack {
    /**
     * 使用一维数组 dp[i] 记录所有物品在背包大小为 j 的条件下，最多可以装满的空间
     * 状态转移方程为：dp[j] = max(dp[j], dp[j - A[i]] + A[i])
     * dp[j - A[i]] 表示：要想装入A[i]大小的东西，必须在现有的基础上减去A[i]大小
     */
    public int backPack(int m, int[] A) {
        int dp[] = new int[m + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
            }
        }
        return dp[m];
    }
}
