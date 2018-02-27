import java.util.Collections;
import java.util.List;

/**
 * 给定一个整数数组来表示排列，找出其上一个排列。
 */
public class M_051_PreviousPermuation {
    /**
     * 从后往前找，找到第一对(i,j)，使得 nums[i] > num[j] ,然后将两者交换后，后面部分排序(降序)即可。
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        if (nums == null || nums.size() <= 0) {
            return nums;
        }
        for (int i = nums.size() - 1; i >= 0; i--) {
            for (int j = nums.size() - 1; j > i; j--) {
                if (nums.get(i) > nums.get(j)) {
                    int temp = nums.get(i);
                    nums.set(i, nums.get(j));
                    nums.set(j, temp);
                    Collections.sort(nums.subList(i + 1, nums.size()), Collections.reverseOrder());
                    return nums;
                }
            }
        }
        Collections.sort(nums, Collections.reverseOrder());
        return nums;
    }
}
