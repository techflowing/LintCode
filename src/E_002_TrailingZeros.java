/**
 * 计算出n阶乘中尾部零的个数
 */
public class E_002_TrailingZeros {

    public static void main(String[] args) {
        System.out.println(new E_002_TrailingZeros().trailingZeros(100));
    }

    /**
     * n的阶乘可以分解为k和10的m次幂的乘积，结果result与m相等。
     * 将n的阶乘分解，分解为素数的幂的乘积，
     * 即n的阶乘可以分解为2的x次方，3的y次方，5的z次方，…的乘积。
     * 而显然，只有2*5=10，会产生一个0，则result=min(x,z)，显然z小于x，则result=z。
     * 所以，问题简化成为求z。
     * <p>
     * 公式
     * z=n/5+n/(5*5)+n/(5*5*5)+…+(直到n小于n的a次幂)
     * 解释：n/5表示能被5整除的数(大于等于5的数，eg. 5,10,15,20等)，可以贡献一个5；
     * n/(5*5)表示能被25整除的数(eg. 25,50,75,100等),可以再贡献一个5;
     * 以此类推，就会得出所有的数目。
     */
    public long trailingZeros(long n) {
        long result = 0;
        while (n != 0) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }
}
