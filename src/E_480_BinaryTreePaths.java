import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一棵二叉树，找出从根节点到叶子节点的所有路径。
 */
public class E_480_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        findPath(root, paths, "" + root.val);
        return paths;
    }

    private void findPath(TreeNode root, List<String> paths, String currentPath) {
        if (root.left == null && root.right == null) {
            paths.add(currentPath);
        }
        if (root.left != null) {
            findPath(root.left, paths, currentPath + "->" + root.left.val);
        }
        if (root.right != null) {
            findPath(root.right, paths, currentPath + "->" + root.right.val);
        }
    }

}
