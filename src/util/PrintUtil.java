package util;

public class PrintUtil {

    public static void printCharArray(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        for (char c : chars) {
            System.out.print(c);
        }
    }
}
