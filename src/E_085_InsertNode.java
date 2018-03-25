import model.TreeNode;

/**
 * 给定一棵二叉查找树和一个新的树节点，将节点插入到树中。
 * 你需要保证该树仍然是一棵二叉查找树。
 */
public class E_085_InsertNode {
    /**
     * 二叉排序树或者是一棵空树，或者是具有下列性质的二叉树：
     * （1）若左子树不空，则左子树上所有结点的值均小于或等于它的根结点的值；
     * （2）若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值；
     * （3）左、右子树也分别为二叉排序树；
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }
}
