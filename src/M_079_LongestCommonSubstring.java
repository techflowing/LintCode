/**
 * 给出两个字符串，找到最长公共子串，并返回其长度。
 */
public class M_079_LongestCommonSubstring {
    /**
     * 动态规划问题
     * f[i][j]表示以字符串A的第i位结束，以字符串B的第j位结束，的最长公共字串。
     */
    public int longestCommonSubstring(String A, String B) {
        int max = 0;
        int n = A.length();
        int m = B.length();
        int[][] f = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = 0;
                }
                max = Math.max(max, f[i][j]);
            }
        }
        return max;
    }
}
