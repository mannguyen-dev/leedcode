package problem.p0xxx.p637e;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int curSize = queue.size();
            int size = curSize;
            double sum = 0;

            while (curSize > 0){
                TreeNode n = queue.poll();
                sum += n.val;
                curSize--;
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }

            res.add(sum/(double)size);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(averageOfLevels(null));
    }
}
