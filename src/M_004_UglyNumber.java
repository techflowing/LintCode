import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
 * 符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 */
public class M_004_UglyNumber {

    public static void main(String[] args) {
        System.out.println(new M_004_UglyNumber().nthUglyNumber(9));
    }

    /**
     * 用2,3,5三个数去组合拼装出所有的丑数
     * 没次循环将上一个丑数依次乘以2、3、5获取下一轮丑数，取最小值
     */
    public int nthUglyNumber(int n) {
        List<Integer> uglyNumberList = new ArrayList<>();
        uglyNumberList.add(1);

        int p2Index = 0;
        int p3Index = 0;
        int p5Index = 0;

        for (int i = 1; i < n; i++) {
            int lastUglyNumber = uglyNumberList.get(i - 1);
            while (uglyNumberList.get(p2Index) * 2 <= lastUglyNumber) {
                p2Index++;
            }
            while (uglyNumberList.get(p3Index) * 3 <= lastUglyNumber) {
                p3Index++;
            }
            while (uglyNumberList.get(p5Index) * 5 <= lastUglyNumber) {
                p5Index++;
            }
            // 下一个丑数
            int nextUglyNumber = Math.min(uglyNumberList.get(p2Index) * 2,
                    Math.min(uglyNumberList.get(p3Index) * 3, uglyNumberList.get(p5Index) * 5));
            uglyNumberList.add(nextUglyNumber);
        }
        return uglyNumberList.get(n - 1);
    }
}
