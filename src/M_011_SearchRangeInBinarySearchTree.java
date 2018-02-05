import model.TreeNode;

import java.util.ArrayList;

/**
 * 给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点。
 * 找到树中所有值在 k1 到 k2 范围内的节点。即打印所有x (k1 <= x <= k2) 其中 x 是二叉查找树的中的节点值。返回所有升序的节点值。
 */
public class M_011_SearchRangeInBinarySearchTree {

    /**
     * 二叉查找树是这样一个二叉树：一个节点的左子节点的值都比它的值小，右子节点的值都比它的值大。
     * 题目要求返回所有升序的节点值，因此采用中序遍历的方法
     */
    public static ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        return midOrderSearch(root, k1, k2, integerArrayList);
    }

    private static ArrayList<Integer> midOrderSearch(TreeNode root, int k1, int k2, ArrayList<Integer> resultList) {
        if (root == null || resultList == null) {
            return resultList;
        }
        if (root.val > k1) {
            midOrderSearch(root.left, k1, k2, resultList);
        }
        if (root.val >= k1 && root.val <= k2) {
            resultList.add(root.val);
        }
        if (root.val < k2) {
            midOrderSearch(root.right, k1, k2, resultList);
        }
        return resultList;
    }
}
