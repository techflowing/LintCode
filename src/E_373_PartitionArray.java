/**
 * 分割一个整数数组，使得奇数在前偶数在后。
 */
public class E_373_PartitionArray {
    /**
     * 双指针的思想
     */
    public void partitionArray(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 == 1) {
                start++;
            }
            while (start < end && nums[end] % 2 == 0) {
                end--;
            }
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}
