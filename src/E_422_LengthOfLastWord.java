/**
 * 给定一个字符串， 包含大小写字母、空格' '，请返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 */
public class E_422_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.length() < 1) {
            return 0;
        }
        String[] strings = s.split(" ");
        return strings[strings.length - 1].length();
    }
}
