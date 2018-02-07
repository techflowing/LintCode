/**
 * 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
 */
public class M_003_DigitCounts {

    public static void main(String[] args) {
        System.out.println(new M_003_DigitCounts().digitCounts(3, 345));
    }

    /**
     * 假设n是三位数，n=abc(如果n=345的话，a=3,b=4,c=5)
     * 1.从0到n中个位数上是k的数字一共多少个？ c>k: (34+1)*1=35      c<k: 34*1=34        c=k:34*1+0+1=34
     * 2.从0到n中十位数上是k的数字一共多少个？ b>K: (3+1)*10=40      b<k: 3*10=30        b=k:3*10+5+1=36
     * 3.从0到n中百位数上是k的数字一共多少个？ a>k: (0+1)*100=100    a<k: 0*100=0        a=k:0*10+45+1=46
     * <p>
     * 结论：
     * 当某一位的数字小于k时，那么该位出现k的次数为：更高位数字x当前位数
     * 当某一位的数字等于k时，那么该位出现k的次数为：更高位数字x当前位数+低位数字+1
     * 当某一位的数字大于k时，那么该位出现k的次数为：(更高位数字+1)x当前位数
     */
    public int digitCounts(int k, int n) {
        int result = 0;
        int base = 1;
        if (k == 0 && n == 0) {
            return 1;
        }
        while (n / base > 0) {
            int current = (n / base) % 10;
            int low = n - (n / base) * base;
            int high = n / (base * 10);

            if (k == 0 && current > k) {
                if (high != 0) {
                    result += high + 1;
                } else {
                    result += high;
                }
            } else if (current == k) {
                result += high * base + low + 1;
            } else if (current < k) {
                result += high * base;
            } else {
                result += (high + 1) * base;
            }

            base *= 10;
        }
        return result;
    }
}
