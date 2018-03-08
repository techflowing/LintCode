import model.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class E_067_BinaryTreeInorderTraversal_1 {

    /**
     * 非递归方式
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            inOrder.add(curNode.val);
            curNode = curNode.right;
        }
        return inOrder;
    }
}
