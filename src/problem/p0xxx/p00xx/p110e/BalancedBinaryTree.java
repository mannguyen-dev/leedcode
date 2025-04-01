package problem.p0xxx.p00xx.p110e;

import dsa.tree.TreeNode;
import problem.UtilityClass;

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        return (boolean) dfs(root)[0];
    }

    private static Object[] dfs(TreeNode root){
        if (root == null) return new Object[]{true, 0};

        Object[] left = dfs(root.left);
        Object[] right = dfs(root.right);
        boolean isBalanced = (boolean) left[0] && (boolean) right[0] && Math.abs((int) left[1] - (int) right[1]) <= 1;
        return new Object[]{isBalanced, 1 + Math.max((int) left[1], (int) right[1])};
    }

    public static boolean isBalanced2(TreeNode root) {
        if (root == null) return true;

        int hLeft = height(root.left);
        int hRight = height(root.right);

        if (Math.abs(hLeft - hRight) > 1) return false;

        return isBalanced2(root.left) && isBalanced2(root.right);
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,2,3,3,null,null,4,4};
        TreeNode root = TreeNode.buildTreeBFS(arr);
        UtilityClass.logResult(isBalanced2(root));
    }
}
