/**
 * 给定一个排序的整数数组（升序）和一个要查找的整数target，
 * 用O(logn)的时间查找到target第一次出现的下标（从0开始），如果target不存在于数组中，返回-1。
 */
public class E_014_BinarySearch {

    public int binarySearch(int[] nums, int target) {
        //write your code here
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] == target) {
                while (middle - 1 > 0 && nums[middle - 1] == target) {
                    middle--;
                }
                return middle;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;

    }
}
