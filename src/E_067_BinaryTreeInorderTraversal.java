import model.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树的中序遍历
 */
public class E_067_BinaryTreeInorderTraversal {

    /**
     * 递归方式
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        res = inTurn(res, root);
        return res;
    }

    public ArrayList<Integer> inTurn(ArrayList<Integer> res, TreeNode root) {
        if (root == null) {
            return res;
        } else {
            if (root.left != null) {
                res = inTurn(res, root.left);
            }
            res.add(root.val);
            if (root.right != null) {
                res = inTurn(res, root.right);
            }
        }
        return res;
    }
}
