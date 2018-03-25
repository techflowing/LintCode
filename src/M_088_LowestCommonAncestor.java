import model.TreeNode;

/**
 * 给定一棵二叉树，找到两个节点的最近公共父节点(LCA)。
 * 最近公共祖先是两个节点的公共的祖先节点且具有最大深度。
 * <p>
 * 对于下面这棵二叉树
 * <p>
 * 4
 * / \
 * 3  7
 * / \
 * 5   6
 * LCA(3, 5) = 4
 * <p>
 * LCA(5, 6) = 7
 * <p>
 * LCA(6, 7) = 7
 */
public class M_088_LowestCommonAncestor {

    /**
     * 在root为根的二叉树中找A,B的LCA:
     * 如果找到了就返回这个LCA
     * 如果只碰到A，就返回A
     * 如果只碰到B，就返回B
     * 如果都没有，就返回null
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}
