import java.util.HashMap;
import java.util.List;

/**
 * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k。
 * <p>
 * 注意事项
 * 数组中只有唯一的主元素
 */
public class M_048_MajorityNumber {
    /**
     * 遍历一遍数组统计每一个数字出现的次数存到hash表中，
     * 由于只有唯一的主元素，所以当次数大于n/k时直接输出该元素
     */
    public int majorityNumber(List<Integer> nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int threshold = nums.size() / k;
        for (Integer num : nums) {
            if (hashMap.containsKey(num)) {
                int count = hashMap.get(num) + 1;
                if (count > threshold) {
                    return num;
                }
                hashMap.put(num, count);
            } else {
                hashMap.put(num, 1);
            }
        }
        return 0;
    }
}
