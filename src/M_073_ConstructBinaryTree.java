import model.TreeNode;

/**
 * 根据前序遍历和中序遍历树构造二叉树.
 * <p>
 * 注意事项
 * 你可以假设树中不存在相同数值的节点
 */
public class M_073_ConstructBinaryTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length != preorder.length) {
            return null;
        }
        return buildTreeLoop(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTreeLoop(int[] inorder, int instart, int inend,
                                   int[] preorder, int prestart, int preend) {
        if (instart > inend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);
        int position = findPosition(inorder, instart, inend, preorder[prestart]);

        root.left = buildTreeLoop(inorder, instart, position - 1,
                preorder, prestart + 1, prestart + position - instart);
        root.right = buildTreeLoop(inorder, position + 1, inend,
                preorder, position - inend + preend + 1, preend);
        return root;
    }

    private int findPosition(int[] arr, int start, int end, int key) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
