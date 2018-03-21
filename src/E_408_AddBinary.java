/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）
 */
public class E_408_AddBinary {
    /**
     * 字符转换为数字，char - '0'
     */
    public String addBinary(String a, String b) {
        String ans = "";

        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;
            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            ans = (sum % 2) + ans;
            carry = sum / 2;
        }
        if (carry != 0) {
            ans = carry + ans;
        }
        return ans;
    }
}
