/**
 * 实现一个leftpad库，如果不知道什么是leftpad可以看样例
 * <p>
 * leftpad("foo", 5)
 * >> "  foo"
 * <p>
 * leftpad("foobar", 6)
 * >> "foobar"
 * <p>
 * leftpad("1", 2, "0")
 * >> "01"
 */
public class E_524_LeftPad {

    public static String leftPad(String originalStr, int size) {
        return leftPad(originalStr, size, ' ');
    }

    public static String leftPad(String originalStr, int size, char padChar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - originalStr.length(); i++) {
            sb.append(padChar);
        }
        sb.append(originalStr);
        return sb.toString();
    }
}
