import model.TreeNode;

import java.util.*;

/**
 * 给出一棵二叉树，返回其节点值从底向上的层次序遍历
 * （按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历）
 */
public class M_070_BinaryTreeLevelOrderTraversal {

    /**
     * 使用队列实现
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }
        Collections.reverse(result);
        return result;
    }
}
