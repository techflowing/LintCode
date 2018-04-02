/**
 * 给定数组，除了一个数出现一次外，所有数都出现两次，
 * 并且所有出现两次的数都挨着。请找出找出那个出现一次的数。
 */
public class M_824_GetSingleNumber {
    /**
     * 二分长度，通过奇偶性找出落单的数
     * 假设落单的数在位置 x
     * 那么 x 之前的数中，每对数字的第一个数是奇数位，
     * x 之后的数字中，每对数字的第一个数是偶数位
     */
    public int getSingleNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == nums[mid - 1]) {
                if ((mid - left + 1) % 2 == 1) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if ((right - mid + 1) % 2 == 1) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}
