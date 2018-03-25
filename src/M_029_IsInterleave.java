/**
 * 给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
 */
public class M_029_IsInterleave {
    /**
     * DP求解
     * res[i][j] 代表s1中前i个字符与s2中前j个字母是否可以交叉匹配成为s3中前i+j个字符。
     * <p>
     * 公式为：
     * <p>
     * if s3[i + j] = s1[i] = s2[j] res[i][j] = res[i - 1][j] || res[i][j - 1]
     * if s3[i + j] = s1[i]  res[i][j] = res[i - 1][j]
     * if s3[i + j] = s2[j]  res[i][j] = res[i][j - 1]
     * else s3[i + j] = false;
     * <p>
     * 初始条件是res[0][0] = true. 即s1前0个字符加s2前0个字符，可以拼凑成s3前0个字符。
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] res = new boolean[s1.length() + 1][s2.length() + 1];
        res[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1) && res[i - 1][0]) {
                res[i][0] = true;
            }
        }

        for (int j = 1; j <= s2.length(); j++) {
            if (s3.charAt(j - 1) == s2.charAt(j - 1) && res[0][j - 1]) {
                res[0][j] = true;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (((s3.charAt(i + j - 1) == s1.charAt(i - 1) && res[i - 1][j]))
                        || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && res[i][j - 1])) {
                    res[i][j] = true;
                }
            }
        }

        return res[s1.length()][s2.length()];
    }

}
