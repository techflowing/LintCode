/**
 * 反转一个只有3位数的整数。
 * <p>
 * 注意事项
 * 你可以假设输入一定是一个只有三位数的整数，这个整数大于等于100，小于1000。
 */
public class N_037_ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new N_037_ReverseInteger().reverseInteger(123));
    }

    public int reverseInteger(int number) {
        int result = 0;
        while (number != 0) {
            result = result * 10 + number % 10;
            number /= 10;
        }
        return result;
    }
}
