/**
 * 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。
 * 如果不存在，则返回 -1。
 */
public class E_013_StrStr {

    public static void main(String[] args) {
        String source = "123456abcdabcdefg";
        String target = "bcd";
        System.out.println(new E_013_StrStr().strStr(source, target));
    }

    /**
     * 暴力求解
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        if (source.equals(target)) {
            return 0;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
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
    public int strStr2(String source, String target) {
        // TODO: 2018/2/6 KMP 实现
        return -1;
    }
}
