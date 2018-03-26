import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个整数数组，找到一个和最接近于零的子数组。
 * 返回第一个和最右一个指数。你的代码应该返回满足要求的子数组的起始位置和结束位置
 */
public class M_139_SubarraySumClosest {

    public static void main(String[] args) {
        int[] nums = new int[]{-3, 1, 1, -3, 5};
        new M_139_SubarraySumClosest().subarraySumClosest(nums);
    }

    /**
     * 将数组元素依次相加求和，并连同最后一位的index存入pair[]中。
     * 然后将pair[]按照sum的大小进行排序,那么排序后相邻的两个sum值得差越小，
     * 说明从index1到index2之间元素的和越接近0
     * <p>
     * pair[index1] = sum(num[0]...num[index1])
     * pair[index2] = sum(num[0]...num[index2])
     * <p>
     * pair[index2] - pair[index1] = sum(num[index1 +1]...num[index2])
     */
    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }

        int len = nums.length;
        if (len == 1) {
            res[0] = res[1] = 0;
            return res;
        }

        Pair[] pairs = new Pair[len];
        int prev = 0;
        for (int i = 0; i < len; i++) {
            pairs[i] = new Pair(prev + nums[i], i);
            prev = pairs[i].sum;
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {

            if (ans > pairs[i].sum - pairs[i - 1].sum) {
                ans = pairs[i].sum - pairs[i - 1].sum;
                int index1 = pairs[i].index;
                int index2 = pairs[i - 1].index;
                int start = index1 < index2 ? index1 : index2;
                int end = index1 < index2 ? index2 : index1;
                res[0] = start + 1;
                res[1] = end;
            }
        }

        return res;
    }

    class Pair {
        int sum;
        int index;

        public Pair(int s, int i) {
            sum = s;
            index = i;
        }
    }

}
