package problem.p0xxx.p00xx.p94e;

import dsa.tree.TreeNode;
import problem.UtilityClass;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        inorder(root, res);

        return res;
    }

    private static void inorder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);

    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        TreeNode root = TreeNode.buildTreeBFS(arr);
        TreeNode.printLNR(root);
        UtilityClass.logResult(inorderTraversal(root));
    }
}
