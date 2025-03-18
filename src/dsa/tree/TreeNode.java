package dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTreeBFS(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        int n = arr.length;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < n) {
            TreeNode node = queue.poll();
            assert node != null;
            node.left = new TreeNode(arr[i]);
            queue.add(node.left);
            i++;
            if (i < n) {
                node.right = new TreeNode(arr[i]);
                queue.add(node.right);
                i++;
            }
        }

        return root;
    }

    public static void printLNR(TreeNode root) {
        if (root == null) {
            return;
        }
        printLNR(root.left);
        System.out.print(root.val + " ");
        printLNR(root.right);
    }
}
