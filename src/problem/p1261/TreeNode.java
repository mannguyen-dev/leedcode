package problem.p1261;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node.
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(Integer val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(List<Integer> arr){
        if (arr == null || arr.isEmpty()) return null;

        TreeNode root = new TreeNode(arr.getFirst()); // Gốc của cây
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < arr.size()) {
            TreeNode current = queue.poll(); // Lấy node hiện tại

            if (current == null) {
                i++;
                continue;
            }

            // Gán con trái
            if (arr.get(i) != null) {
                current.left = new TreeNode(arr.get(i));
                queue.add(current.left);
            }
            // Gán con phải
            if (arr.get(i) != null) {
                current.right = new TreeNode(arr.get(i));
                queue.add(current.right);
            }
        }
        return root;
    }

    // Hàm duyệt cây theo thứ tự Reorder (NLR)
    public static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        inorderTraversal(root.left);
        inorderTraversal(root.right);
    }
}

