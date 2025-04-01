package problem.p0xxx.p00xx.p104e;

import dsa.tree.TreeNode;
import problem.UtilityClass;

public class MaximumDepth {
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = TreeNode.buildTreeBFS(arr);
        TreeNode.printNLR(root);
        UtilityClass.logResult(maxDepth(root));
    }
}
