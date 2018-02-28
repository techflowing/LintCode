import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 * <p>
 * 注意事项
 * 在三元组(a, b, c)，要求a <= b <= c。
 * <p>
 * 结果不能包含重复的三元组。
 */
public class M_057_ThreeSum {
    /**
     * 先对数组排序，然后开始遍历，对于数组中的每一个元素，用两指针往中间夹，直到找出所有的解
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> arrayListArrayList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return arrayListArrayList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.add(nums[left]);
                    arrayList.add(nums[right]);
                    arrayListArrayList.add(arrayList);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return arrayListArrayList;
    }
}
