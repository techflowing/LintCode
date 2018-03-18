/**
 * 给出两个字符串，找到最长公共子序列(LCS)，返回LCS的长度。
 */
public class M_077_LongestCommonSubsequence {

    /**
     * 动态规划问题
     * ff[i][j]表示以字符串A的第i位结束，以字符串B的第j位结束，的最长公共子序列。
     * 状态转移方程：
     * if (A[i] == B[j])
     * f[i][j] = f[i-1][j-1] + 1;
     * else
     * f[i][j] = max(f[i-1][j], f[i][j-1]);
     */
    public int longestCommonSubsequence(String A, String B) {
        int n = A.length();
        int m = B.length();
        int f[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[n][m];
    }
}
