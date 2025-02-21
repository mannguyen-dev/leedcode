package problem.p1261;

import java.util.HashSet;
import java.util.Set;

class FindElements {

    Set<Integer> nodeValues;

    public FindElements(TreeNode root) {
        nodeValues = new HashSet<>();
        nodeValues.add(0);
        recoverBinaryTree(root.left, 1);
        recoverBinaryTree(root.left, 2);
    }

    private void recoverBinaryTree(TreeNode curr, int value) {
        if (curr == null || curr.val == null){
            return;
        }

        nodeValues.add(value);
        recoverBinaryTree(curr.left, 2*value + 1);
        recoverBinaryTree(curr.right, 2*value + 2);
    }

    public boolean find(int target) {
        return nodeValues.contains(target);
    }
}
