/**
 * 给定一个十进制数 n 和 一个整数 k, 将 十进制数 n 转换成 k进制数.
 * 1.0<=n<=2^31-1, 2<=k<=16
 * 2.每个大于 9 的字符都用大写字母表示
 */
public class N_763_HexConversion {

    public static void main(String[] args) {
        System.out.println(new N_763_HexConversion().hexConversion(5, 16));
    }

    public String hexConversion(int n, int k) {
        if (n == 0) {
            return getDigit(n);
        }
        String result = "";
        while (n != 0) {
            result = getDigit(n % k) + result;
            n = n / k;
        }
        return result;
    }

    private String getDigit(int n) {
        if (n < 0 || n > 16) {
            throw new IllegalArgumentException();
        }
        String digits = "0123456789ABCDEF";
        return String.valueOf(digits.charAt(n));
    }
}
