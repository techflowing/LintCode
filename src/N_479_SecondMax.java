/**
 * 在数组中找到第二大的数
 */
public class N_479_SecondMax {
    /**
     * 如果当前元素大于最大数 max，则让第二大数等于原来的最大数 max，再把当前元素的值赋给 max。
     * 如果当前的元素大于等于第二大数secondMax的值而小于最大数max的值，则要把当前元素的值赋给 secondMax
     */
    public int secondMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second) {
                second = num;
            }
        }
        return second;
    }
}
