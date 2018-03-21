/**
 * 报数指的是，按照其中的整数的顺序进行报数，然后得到下一个数。如下所示：
 * 1, 11, 21, 1211, 111221, ...
 * 1 读作 "one 1" -> 11.
 * 11 读作 "two 1s" -> 21.
 * 21 读作 "one 2, then one 1" -> 1211.
 * 给定一个整数 n, 返回 第 n 个顺序。
 */
public class E_420_CountAndSay {

    public String countAndSay(int n) {
        String oldString = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] oldChars = oldString.toCharArray();
            for (int i = 0; i < oldChars.length; i++) {
                int count = 1;
                while ((i + 1) < oldChars.length && oldChars[i] == oldChars[i + 1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count)).append(String.valueOf(oldChars[i]));
            }
            oldString = sb.toString();
        }
        return oldString;
    }
}
