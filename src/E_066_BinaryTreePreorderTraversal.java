import model.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树的前序遍历
 */
public class E_066_BinaryTreePreorderTraversal {

    /**
     * 递归方式
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        res = preTurn(res, root);
        return res;
    }

    public ArrayList<Integer> preTurn(ArrayList<Integer> res, TreeNode root) {
        if (root == null) {
            return res;
        } else {
            res.add(root.val);
            if (root.left != null) {
                res = preTurn(res, root.left);
            }
            if (root.right != null) {
                res = preTurn(res, root.right);
            }
        }

        return res;

    }
}
