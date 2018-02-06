/**
 * 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。
 * 如果不存在，则返回 -1。
 */
public class E_013_StrStr {

    public static void main(String[] args) {
        String source = "123456abcdabcdefg";
        String target = "bcd";
        System.out.println(strStr(source, target));
    }

    /**
     * 暴力求解
     */
    public static int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        for (int i = 0; i < source.length() - target.length(); i++) {
            int j;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * KMP算法
     */
    public static int strStr2(String source, String target) {
        return -1;
    }
}
