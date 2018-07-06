/**
 * Reshape the Matrix
 */
public class E_1170_ReshapeMatrix {

    /**
     * index 指示拷贝数字的位置
     * index / 列数，二维数组的横坐标
     * index % 列数，二位数组的纵坐标
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null) {
            return null;
        }
        int originRow = nums.length;
        int originColumn = nums[0].length;
        if (originRow * originColumn != r * c) {
            return nums;
        }
        int[][] reshapeNum = new int[r][c];
        int index = 0;
        for (int i = 0; i < r * c; i++) {
            reshapeNum[index / c][index % c] = nums[index / originColumn][index % originColumn];
            index++;
        }
        return reshapeNum;
    }
}
