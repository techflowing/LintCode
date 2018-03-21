import java.util.ArrayList;

/**
 * 给一个词典，找出其中所有最长的单词。
 */
public class E_133_LongestWords {

    public ArrayList<String> longestWords(String[] dictionary) {
        int maxLength = Integer.MIN_VALUE;
        for (String string : dictionary) {
            maxLength = maxLength > string.length() ? maxLength : string.length();
        }
        ArrayList<String> stringList = new ArrayList<>();
        for (String string : dictionary) {
            if (string.length() == maxLength) {
                stringList.add(string);
            }
        }
        return stringList;
    }
}
