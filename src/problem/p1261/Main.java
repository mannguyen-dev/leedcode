package problem.p1261;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(-1,null,-1,-1,null,-1);
        TreeNode root = TreeNode.createTree(arr);

        System.out.println("Inorder Traversal:");
        TreeNode.inorderTraversal(root);

        FindElements findElements = new FindElements(root);
        System.out.println(findElements.nodeValues +" " + findElements.find(2));

    }
}
