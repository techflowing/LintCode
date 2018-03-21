/**
 * 实现一个算法确定字符串中的字符是否均唯一出现
 */
public class E_157_IsUnique {
    /**
     * 用数组标记字母是否出现过
     */
    public boolean isUnique(String str) {
        boolean[] charSet = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }
}
