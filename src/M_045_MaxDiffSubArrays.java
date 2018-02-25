/**
 * Created by yuanzeng on 18/2/25.
 */
public class M_045_MaxDiffSubArrays {

    /**
     * 复用“求最大字数组和”的代码,求出从左自右遍历数的最大子数组maxLeft、最小子数组minLeft
     * 从右自左遍历数的最大子数组maxRight、最小子数组minRight。
     * 然后求出maxLeft与minRight的最大差，minLeft与maxRight的最大差。即可得出最大子数组差。
     * {@link E_041_MaxSubArray} 最大子数组
     * {@link E_044_MinSubArray} 最小子数组
     */
    public int maxDiffSubArrays(int[] nums) {
        int size = nums.length;
        int[] maxLeft = new int[size];
        int[] minLeft = new int[size];
        int[] maxRight = new int[size];
        int[] minRight = new int[size];

        int max = Integer.MIN_VALUE;
        int sum = 0;
        /*Forward: get max subarray*/
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
            maxLeft[i] = max;
        }
        /*Backward: get max subarray*/
        max = Integer.MIN_VALUE;
        sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
            maxRight[i] = max;
        }
        /*Forward: get min subarray*/
        int min = Integer.MAX_VALUE;
        sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
            sum = Math.min(sum, 0);
            minLeft[i] = min;
        }
        /*Backward: get min subarray*/
        min = Integer.MAX_VALUE;
        sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums[i];
            min = Math.min(min, sum);
            sum = Math.min(sum, 0);
            minRight[i] = min;
        }
        int diff = 0;
        for (int i = 0; i < size - 1; i++) {
            diff = Math.max(diff, Math.abs(maxLeft[i] - minRight[i + 1]));
            diff = Math.max(diff, Math.abs(minLeft[i] - maxRight[i + 1]));
        }
        return diff;
    }
}
