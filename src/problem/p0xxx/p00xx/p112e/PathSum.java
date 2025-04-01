package problem.p0xxx.p00xx.p112e;

import dsa.tree.TreeNode;
import problem.UtilityClass;

public class PathSum {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private static boolean dfs(TreeNode root, int curSum, int targetSum) {
        if (root == null) return false;

        curSum += root.val;
        if (root.left == null && root.right == null){
            return curSum == targetSum;
        }
        return dfs(root.left, curSum, targetSum) || dfs(root.right, curSum, targetSum);
    }

    public static void main(String[] args) {
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = TreeNode.buildTreeBFS(arr);

        int targetSum = 22;
        UtilityClass.logResult(hasPathSum(root, targetSum));
    }
}
