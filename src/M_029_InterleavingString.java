/**
 * 给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
 * <p>
 * 比如 s1 = "aabcc" s2 = "dbbca"
 * - 当 s3 = "aadbbcbcac"，返回  true.
 * - 当 s3 = "aadbbbaccc"， 返回 false.
 */
public class M_029_InterleavingString {

    /**
     * 这道题可以用动态规划的思想解决。
     * dp[i][j]：表示s1的前i个字符和s2的前j个字符是否由交叉构成。
     * 显然对于i+j个字符，要么等于s1的第i个，要么等于s2的第j个
     * <p>
     * 当等于s1的第i个时，那么必须dp[i-1][j]是true,也就是前面i+j-2个字符是由交叉构成的，那么加进来的就为true。
     * <p>
     * 同理对于等于s2的第j个也是。
     * <p>
     * 初始条件，当j=0时，那么s1与s3每个字符相等的话，就为true
     * 同样当i=0时，也是一样！
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // TODO: 2018/2/8
        return false;
    }
}
