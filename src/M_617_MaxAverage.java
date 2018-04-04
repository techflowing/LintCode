/**
 * 给出一个整数数组，有正有负。找到这样一个子数组，他的长度大于等于 k，且平均值最大。
 */
public class M_617_MaxAverage {
    /**
     * 把从0到i的和全部存在一个数组里，只要用sums[j] - sums[i]就可以知道从i到j的subarray的和
     */
    public double maxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        long[] sums = new long[n + 1];
        sums[0] = 0L;
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        double maxAvg = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = i + k; j < n + 1; j++) {
                long sum = sums[j] - sums[i];
                double avg = ((double) sum) / (j - i);
                maxAvg = Math.max(maxAvg, avg);
            }
        }

        return maxAvg;
    }
}
