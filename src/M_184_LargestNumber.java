import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出一组非负整数，重新排列他们的顺序把他们组成一个最大的整数。
 */
public class M_184_LargestNumber {
    /**
     * 转换成字符串排序
     * 最后去除前导0，是因为需要考虑：032、09类似的情况
     */
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new NumbersComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        String result = sb.toString();
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        if (index == result.length()) {
            return "0";
        }
        return result.substring(index);
    }

    private class NumbersComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    }

}
