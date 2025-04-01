package problem.p0xxx.p00xx.p111e;

import dsa.tree.TreeNode;
import problem.UtilityClass;

public class MinimumDepth {
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        if (root.left == null) return 1 + minDepth(root.right);

        if (root.right == null) return 1 + minDepth(root.left);

        return 1 + Math.min(minDepth(root.right), minDepth(root.left));
    }

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.buildTreeBFS(arr);
        UtilityClass.logResult(minDepth(root));
    }
}
