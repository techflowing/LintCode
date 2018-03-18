import java.util.Arrays;

/**
 * 给定一个未排序的整数数组，找到其中位数。
 * <p>
 * 中位数是排序后数组的中间值，如果数组的个数是偶数个，则返回排序后数组的第N/2个数。
 */
public class E_080_Median {
    public int median(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        if (nums.length % 2 == 0) {
            return nums[nums.length / 2 - 1];
        } else {
            return nums[nums.length / 2];
        }
    }
}
