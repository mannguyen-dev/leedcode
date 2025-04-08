package problem.p0xxx.p01xx.p144e;

import dsa.tree.TreeNode;
import problem.UtilityClass;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        dfs(root, res);
        return res;
    }

    private static void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeNode root =  TreeNode.buildTreeBFS(arr);
        UtilityClass.logResult(preorderTraversal(root));
    }
}
