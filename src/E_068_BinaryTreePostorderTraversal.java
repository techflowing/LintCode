import model.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树的后序遍历
 */
public class E_067_BinaryTreePostorderTraversal {

    /**
     * 递归方式
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        res = postTurn(res, root);
        return res;
    }

    public ArrayList<Integer> postTurn(ArrayList<Integer> res, TreeNode root) {
        if (root == null) {
            return res;
        } else {
            if (root.left != null) {
                res = postTurn(res, root.left);
            }
            if (root.right != null) {
                res = postTurn(res, root.right);
            }
            res.add(root.val);
        }
        return res;
    }
}
