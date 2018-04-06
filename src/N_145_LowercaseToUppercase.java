/**
 * 将一个字符由小写字母转换为大写字母
 */
public class N_145_LowercaseToUppercase {
    /**
     * ASCII 表： a-97，A-65
     */
    public char lowercaseToUppercase(char character) {
        return (char) (character - 32);
    }
}
