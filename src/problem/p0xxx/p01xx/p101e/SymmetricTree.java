package problem.p0xxx.p01xx.p101e;

import dsa.tree.TreeNode;
import problem.UtilityClass;

import java.util.*;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        boolean endOfTree = false;

        while(!endOfTree){
            List<Integer> valueList = new ArrayList<>();
            List<TreeNode> nodeList = new ArrayList<>();
            endOfTree = true;

            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if (node != null){
                    endOfTree = false;
                    valueList.add(node.val);
                    nodeList.add(node.left);
                    nodeList.add(node.right);
                } else {
                    valueList.add(null);
                    nodeList.add(null);
                    nodeList.add(null);
                }
            }

            queue.addAll(nodeList);

            if (!isMirrorList(valueList)){
                return false;
            }
        }

        return true;
    }

    private static boolean isMirrorList(List<Integer> valueList) {
        if (valueList.isEmpty()) return true;
        for (int i = 0; i <= valueList.size()/2; i++){
            if (!Objects.equals(valueList.get(i), valueList.get(valueList.size() - 1 - i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isSymmetric2(TreeNode root) {
        return checkLeftRight(root.left, root.right);
    }

    private static boolean checkLeftRight(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }

        return left.val == right.val &&
                checkLeftRight(left.left, right.right) &&
                checkLeftRight(left.right, right.left);
    }

    public static void main(String[] args) {
        Integer[] arr = {2,3,3,4,5,null,4};
        TreeNode root = TreeNode.buildTreeBFS(arr);
        TreeNode.printNLR(root);
        UtilityClass.logResult(isSymmetric2(root));
    }
}
