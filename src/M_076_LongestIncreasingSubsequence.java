/**
 * 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
 * <p>
 * 最长上升子序列的定义：
 * 最长上升子序列问题是在一个无序的给定序列中找到一个尽可能长的由低到高排列的子序列，
 * 这种子序列不一定是连续的或者唯一的。
 */
public class M_076_LongestIncreasingSubsequence {
    /**
     * 动态规划
     * 构建数组result[]，result[i]表示已以元素nums[i]为末尾的最长子序列的长度。
     * 动态转换方程为：
     * result[i]=max(result[i], result[j]+1)(nums[j]<nums[i],j<i)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        int[] result = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
