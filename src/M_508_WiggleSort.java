/**
 * 给你一个没有排序的数组，请将原数组就地重新排列满足如下性质
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * <p>
 * 给出数组为 nums = [3, 5, 2, 1, 6, 4] 一种输出方案为 [1, 6, 2, 5, 3, 4]
 */
public class M_508_WiggleSort {

    /**
     * 解法一：先给数组排个序，然后我们只要每次把第三个数和第二个数调换个位置，
     * 第五个数和第四个数调换个位置，以此类推直至数组末尾，这样我们就能完成摆动排序了
     * <p>
     * 解法二：
     * 当i为奇数时，nums[i] >= nums[i - 1]
     * 当i为偶数时，nums[i] <= nums[i - 1]
     * 只要对每个数字，根据其奇偶性，跟其对应的条件比较，如果不符合就和前面的数交换位置即可
     */
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 != 0 && (nums[i] < nums[i - 1]) ||
                    (i % 2 == 0) && (nums[i] > nums[i - 1]))) {
                swap(nums, i - 1, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
