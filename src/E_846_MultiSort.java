import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定 n 个学生（ 1 到 n 编号）以及他们的考试成绩，这里有两个关键字，考试成绩以及学生学号。
 * 根据第一关键字(成绩)对数组进行排序(降序)，如果第一关键字（成绩）相同则根据第二关键字（学号）进行排序(升序).
 * <p>
 * 给出 [[2,50],[1,50],[3,100]]，
 * 返回 [[3,100],[1,50],[2,50]]
 */
public class E_846_MultiSort {
    public int[][] multiSort(int[][] array) {
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        return array;
    }
}
