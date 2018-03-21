/**
 * 给定一个非负数，表示一个数字数组，在该数的基础上+1，返回一个新的数组。
 * 该数字按照数位高低进行排列，最高位的数在列表的最前面。
 * <p>
 * 样例
 * 给定 [1,2,3] 表示 123, 返回 [1,2,4].
 * 给定 [9,9,9] 表示 999, 返回 [1,0,0,0].
 */
public class E_407_PlusOne {
    /**
     * 倒序 从低位处理进位
     */
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
    }
}
