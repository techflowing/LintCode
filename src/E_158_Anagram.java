/**
 * 写出一个函数 anagram(s, t) 判断两个字符串是否可以通过改变字母的顺序变成一样的字符串
 */
public class E_158_Anagram {
    /**
     * 数组标记每一个字母出现的次数
     */
    public boolean anagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[(int) s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[(int) t.charAt(i)]--;
            if (count[(int) t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;

    }
}
