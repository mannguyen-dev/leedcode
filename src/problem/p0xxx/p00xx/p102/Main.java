package problem.p0xxx.p00xx.p102;

import problem.p1xxx.p1261.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int currentSize = queue.size();
            List<Integer> currentList = new ArrayList<>();

            while (currentSize > 0){
                TreeNode node = queue.poll();
                currentList.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                currentSize--;
            }
            res.add(currentList);
        }
        return res;
    }


}
