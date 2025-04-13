package problem.p0xxx.p01xx.p145e;

import dsa.tree.TreeNode;
import problem.UtilityClass;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private static void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;

        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeNode root = TreeNode.buildTreeBFS(arr);
        UtilityClass.logResult(postorderTraversal(root));
    }
}
