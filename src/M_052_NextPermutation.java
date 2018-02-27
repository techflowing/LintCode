import java.util.Arrays;

/**
 * 给定一个整数数组来表示排列，找出其之后的一个排列。
 */
public class M_052_NextPermutation {

    /**
     * 从后往前找，找到第一对(i,j)，使得 nums[i] < num[j] ,然后将两者交换后，后面部分排序即可。
     */
    public int[] nextPermutation(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return nums;
        }
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums, i + 1, nums.length);
                    return nums;
                }
            }
        }
        Arrays.sort(nums);
        return nums;
    }
}
