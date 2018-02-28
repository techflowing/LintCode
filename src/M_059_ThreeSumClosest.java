import java.util.Arrays;

/**
 * 给一个包含 n 个整数的数组 S, 找到和与给定整数 target 最接近的三元组，返回这三个数的和。
 * <p>
 * 注意事项
 * 只需要返回三元组之和，无需返回三元组本身
 */
public class M_059_ThreeSumClosest {

    /**
     * 思路和{@link M_057_ThreeSum} 类似
     */
    public int threeSumClosest(int[] numbers, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right] + numbers[i];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum <= target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
