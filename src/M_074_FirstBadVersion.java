import util.SVNRepo;

/**
 * 代码库的版本号是从 1 到 n 的整数。某一天，有人提交了错误版本的代码，
 * 因此造成自身及之后版本的代码在单元测试中均出错。请找出第一个错误的版本号。
 */
public class M_074_FirstBadVersion {

    public int findFirstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (SVNRepo.isBadVersion(start)) {
            return start;
        }
        return end;
    }
}
