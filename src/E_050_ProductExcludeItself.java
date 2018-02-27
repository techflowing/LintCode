import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组A。
 * <p>
 * 定义B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]， 计算B的时候请不要使用除法。
 * 样例
 * 给出A=[1, 2, 3]，返回 B为[6, 3, 2]
 */
public class E_050_ProductExcludeItself {

    /**
     * 先遍历一遍数组，每一个位置上存之前所有数字的乘积。
     * 那么一遍下来，最后一个位置上的数字是之前所有数字之积;
     * 这时候再从后往前扫描，每个位置上的数在乘以后面所有数字之积.
     * 对于最后一个位置来说，由于后面没有数字了，所以乘以1就行。
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        long[] res = new long[nums.size()];
        long left = 1;
        res[0] = 1;
        for (int i = 1; i < nums.size(); i++) {
            left = left * (long) nums.get(i - 1);
            res[i] = left;
        }
        long right = 1;
        for (int i = nums.size() - 2; i >= 0; i--) {
            right = right * nums.get(i + 1);
            res[i] = res[i] * right;
        }

        List<Long> result = new ArrayList<>();
        for (long num : res) {
            result.add(num);
        }

        return result;
    }
}
