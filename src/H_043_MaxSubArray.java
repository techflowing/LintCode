/**
 * 给定一个整数数组和一个整数 k，找出 k 个不重叠子数组使得它们的和最大。每个子数组的数字在数组中的位置应该是连续的。
 * 返回最大的和。
 * <p>
 * 注意事项
 * 子数组最少包含一个数
 */
public class H_043_MaxSubArray {
    /**
     * 典型划分类动态规划
     * localMax[i][k] 表示前i个数，取k个子数组，包含第i个数的Maximum Sum
     * globalMax[i][k] 表示前i个数，取k个子数组，可以不包含第i个数的Maximum Sum
     * <p>
     * 状态转移方程
     * localMax[i][k] = max(localMax[i - 1][k] + nums[i - 1], globalMax[i - 1][k - 1] + nums[i - 1])
     * globalMax[i][k] = max(globalMax[i - 1][k], localMax[i][k])
     */
    public int maxSubArray(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int len = nums.length;


        int[][] globalMax = new int[k + 1][len + 1];
        int[][] localMax = new int[k + 1][len + 1];

        for (int i = 1; i <= k; i++) {
            localMax[i][i - 1] = Integer.MIN_VALUE;
            //小于 i 的数组不能够partition
            for (int j = i; j <= len; j++) {
                localMax[i][j] = Math.max(localMax[i][j - 1], globalMax[i - 1][j - 1]) + nums[j - 1];
                if (j == i) {
                    globalMax[i][j] = localMax[i][j];
                } else {
                    globalMax[i][j] = Math.max(globalMax[i][j - 1], localMax[i][j]);
                }
            }
        }
        return globalMax[k][len];
    }
}
