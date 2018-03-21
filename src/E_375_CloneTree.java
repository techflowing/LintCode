import model.TreeNode;

/**
 * 深度复制一个二叉树。
 * <p>
 * 给定一个二叉树，返回一个他的 克隆品 。
 */
public class E_375_CloneTree {

    public TreeNode cloneTree(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode cloneNode = new TreeNode(root.val);
            cloneNode.left = cloneTree(root.left);
            cloneNode.right = cloneTree(root.right);
            return cloneNode;
        }
    }
}
