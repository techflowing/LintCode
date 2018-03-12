import model.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 */
public class E_068_BinaryTreePostorderTraversal_1 {

    /**
     * 非递归方式
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            result.add(0, top.val);
            if (top.left != null) {
                stack.push(top.left);
            }
            if (top.right != null) {
                stack.push(top.right);
            }
        }
        return result;
    }
}
