import java.util.HashMap;

/**
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * <p>
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。
 * 注意这里下标的范围是 0 到 n-1。
 */
public class E_056_TwoSum {
    /**
     * 假设target = A + B；
     * 使用map存储，key：需要的另一个数字B，value：当前数字A的位置
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                return new int[]{map.get(numbers[i]), i};
            }
            map.put(target - numbers[i], i);
        }
        return new int[]{};
    }
}
