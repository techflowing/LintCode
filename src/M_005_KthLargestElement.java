import java.util.Random;

/**
 * 在数组中找到第k大的元素
 */
public class M_005_KthLargestElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(new M_005_KthLargestElement().kthLargestElement(2, nums));
    }


    /**
     * 标准的 Quick Select 算法。
     * 快速排序算法：每次找到元素在有序数组中的最终位置（前面的数都比它小，后面的数都比它大）。
     * 因此，在算法中，将比第K大数小的都放在它的前面，大的放后面，有效快速找出目标数。
     * 时间复杂度接近于O(N)
     * <p>
     * 总体而言，Quick select采用和Quick sort类似的步骤。首先选定一个pivot，然后根据每个数字与该pivot的大小关系将整个数组分为两部分。
     * 那么与Quick sort不同的是，Quick select只考虑所寻找的目标所在的那一部分子数组，而非像Quick sort一样分别再对两边进行分割。
     * 正是因为如此，Quick select将平均时间复杂度从O(nlogn)降到了O(n)
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int len = nums.length;
        return quickSelect(nums, 0, len - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        // 选取随机数
        Random random = new Random();
        int index = random.nextInt(end - start + 1) + start;
        int pivot = nums[index];
        swap(nums, index, end);

        int left = start;
        int right = end;
        while (left < right) {
            if (nums[left++] <= pivot) {
                swap(nums, --left, --right);
            }
        }
        swap(nums, left, end);

        int m = left - start;
        if (m == k - 1) {
            return pivot;
        } else if (k <= m) {
            return quickSelect(nums, start, left - 1, k);
        } else {
            return quickSelect(nums, left, end, k - m);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
