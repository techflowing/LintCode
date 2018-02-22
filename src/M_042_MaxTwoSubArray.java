import java.util.List;

/**
 * 给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
 * 每个子数组的数字在数组中的位置应该是连续的。
 * 返回最大的和。
 * <p>
 * 注意事项
 * 子数组最少包含一个数
 */
public class M_042_MaxTwoSubArray {
    /**
     * 从左自右、从右自左分别遍历数组。每次遍历均记录当前最大的单子数组，用2个数组left,right保存。
     * 如left[i]的值表示nums从0至i中最大子数组的值，right[i]的值表示nums从i至size-1中最大子数组的值。
     * 最后遍历left,right数组，left[i]+right[i+1]表示在第i位拆分数组，得到其子数组的和。
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
            left[i] = max;
        }

        sum = 0;
        max = Integer.MIN_VALUE;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
            right[i] = max;
        }

        max = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
}
