/**
 * 在数组中找到第k大的元素
 */
public class M_005_KthLargestElement {

    /**
     * 标准的 Quick Select 算法。
     * 快速排序算法：每次找到元素在有序数组中的最终位置（前面的数都比它小，后面的数都比它大）。
     * 因此，在算法中，将比第K大数小的都放在它的前面，大的放后面，有效快速找出目标数。
     * 时间复杂度接近于O(N)
     */
    public static int kthLargestElement() {

    }

    private static int quickSelect(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }

        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }

        return nums[right + 1];
    }
}
