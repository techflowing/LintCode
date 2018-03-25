/**
 * 给出一个非负整数 num，反复的将所有位上的数字相加，直到得到一个一位的整数。
 * <p>
 * 给出 num = 38。
 * 相加的过程如下：3 + 8 = 11，1 + 1 = 2。因为 2 只剩下一个数字，所以返回 2。
 */
public class E_569_AddDigits {

    public static void main(String[] args) {
        System.out.println(new E_569_AddDigits().addDigits(129));
    }

    public int addDigits(int num) {
        int result = num;
        while (num >= 10) {
            result = 0;
            while (num > 0) {
                result = result + num % 10;
                num = num / 10;
            }
            num = result;
        }
        return result;
    }
}
