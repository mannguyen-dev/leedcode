package problem.p1xxx.p1123m;

import dsa.tree.TreeNode;
import problem.UtilityClass;

public class LCAOfDeepestLeaves {
    static class Pair {
        TreeNode node;
        int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair res = findLCA(root);
        return res.node;
    }

    private static Pair findLCA(TreeNode root) {
        if (root == null){
            return new Pair(null, 0);
        }

        Pair left = findLCA(root.left);
        Pair right = findLCA(root.right);

        if (left.depth == right.depth){
            return new Pair(root, 1 + left.depth);
        }

        if (left.depth > right.depth){
            return new Pair(left.node, left.depth + 1);
        }

        return new Pair(right.node, right.depth + 1);
    }

    public static void main(String[] args) {
        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNode.buildTreeBFS(arr);
        UtilityClass.logResult(lcaDeepestLeaves(root));
    }
}
