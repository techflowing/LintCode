/**
 * 设计一种方法，将一个字符串中的所有空格替换成 %20 。
 * 你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。
 */
public class E_212_ReplaceBlank {
    /**
     * 先计算出最终长度，然后倒序依次填充每一个位置的值
     */
    public int replaceBlank(char[] string, int length) {
        int realLength = length;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                realLength += 2;
            }
        }
        int index = realLength;
        for (int i = length - 1; i >= 0; i--) {
            if (string[i] == ' ') {
                string[--index] = '0';
                string[--index] = '2';
                string[--index] = '%';
            } else {
                string[--index] = string[i];
            }
        }
        return realLength;
    }
}
