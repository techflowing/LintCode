import model.TreeNode;

/**
 * 根据中序遍历和后序遍历树构造二叉树
 * 注意事项
 * 你可以假设树中不存在相同数值的节点
 */
public class M_072_ConstructBinaryTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        return buildTreeLoop(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeLoop(int[] inorder, int instart, int inend,
                                   int[] postorder, int poststart, int postend) {
        if (instart > inend) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postend]);
        // 找出根节点的位置
        int position = findPosition(inorder, instart, inend, postorder[postend]);

        root.left = buildTreeLoop(inorder, instart, position - 1,
                postorder, poststart, poststart + position - instart - 1);
        root.right = buildTreeLoop(inorder, position + 1, inend,
                postorder, poststart + position - instart, postend - 1);
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
