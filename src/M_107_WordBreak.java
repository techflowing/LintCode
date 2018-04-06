import java.util.Set;

/**
 * 给出一个字符串s和一个词典，判断字符串s是否可以被空格切分成一个或多个出现在字典中的单词。
 */
public class M_107_WordBreak {
    /**
     * 用一个dp数组保存前i个字符能否切分
     * 每次从字典中拿出一个元素和子串比较，复杂度是nk。
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null && dict == null) {
            return true;
        }
        if (s == null || dict == null) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (String str : dict) {
                if (dp[i] && i + str.length() <= s.length() && s.substring(i, i + str.length()).equals(str)) {
                    dp[i + str.length()] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
