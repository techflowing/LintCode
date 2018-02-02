/**
 * 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
 */
public class E_001_APlusB {

    public static void main(String[] args) {
        System.out.println(aplusb(10, 63));
    }

    /**
     * 异或运算又称为 不进位加法
     * a^b 表示为 a+b 后，该进位的地方不进位的结果
     * 然后考虑哪些地方需要进位，（a和b里都是1的位置）
     * a&b 表示a和b中都是1的位置，(a&b)<<1 既表示进位后的结果
     * 所以：a + b = (a ^ b) + (a & b << 1)
     * 在进位变为0的时候，表示运算结束
     */
    public static int aplusb(int a, int b) {
        if (b == 0) {
            return a;
        }
        int noCarrySum = a ^ b;
        int carry = (a & b) << 1;
        return aplusb(noCarrySum, carry);
    }
}
