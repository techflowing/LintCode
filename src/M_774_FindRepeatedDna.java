import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 所有的DNA由一系列缩写的核苷酸 A, C, G 和 T组成.
 * 比如; "ACGAATTCCG". 在研究 DNA 时, 有时候鉴别出 DNA 中的重复序列是很有用的.
 * 写一个函数来找到所有在 DNA 中出现超过一次且长度为 10个字母 的序列(子串).
 */
public class M_774_FindRepeatedDna {
    /**
     * 使用set判断重复和结果去重
     */
    public List<String> findRepeatedDna(String s) {
        Set<String> one = new HashSet<>();
        Set<String> two = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String tmp = s.substring(i, i + 10);
            if (!one.add(tmp)) {
                two.add(tmp);
            }
        }
        return new ArrayList<>(two);
    }
}
