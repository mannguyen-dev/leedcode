package problem.p0xxx.p00xx.p236m;

import dsa.tree.TreeNode;
import problem.UtilityClass;

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val == root.val || q.val == root.val) {
            return root;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode root = TreeNode.buildTreeBFS(arr);
        UtilityClass.logResult(lowestCommonAncestor(root, p, q).val);
    }
}
