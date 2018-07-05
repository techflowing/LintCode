import model.TreeNode;

/**
 * 在二叉树中寻找值最大的节点并返回。
 */
public class N_632_MaxNode {

    public TreeNode maxNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = maxNode(root.left);
        TreeNode right = maxNode(root.right);
        return max(root, max(left, right));

    }

    public TreeNode max(TreeNode a, TreeNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.val > b.val) {
            return a;
        }
        return b;
    }
}
