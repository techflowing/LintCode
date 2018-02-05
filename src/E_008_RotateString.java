import util.PrintUtil;

/**
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * 对于字符串 "abcdefg".
 * <p>
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 */
public class E_008_RotateString {

    public static void main(String[] args) {
        String str = "abcdef";
        char[] chars = str.toCharArray();
        rotateString(chars, 3);
        PrintUtil.printCharArray(chars);
    }


    /**
     * 前部分逆序，后部分逆序，整体逆序
     * 这里注意的是offset会大于字符串长度的情况，所以要对offeset处理：offset = offset%len
     */
    public static void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0) {
            return;
        }
        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }

    private static void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
