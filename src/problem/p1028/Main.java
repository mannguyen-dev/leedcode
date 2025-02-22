package problem.p1028;

import problem.p1261.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static TreeNode recoverFromPreorder(String traversal) {
        AtomicInteger n = new AtomicInteger(traversal.length());
        AtomicInteger pos = new AtomicInteger(0);
        TreeNode root = new TreeNode(getVal(traversal, n, pos));
        
        buildTree(root, 1, traversal, n, pos);
        buildTree(root, 1, traversal, n, pos);
        return root;
    }

    private static Integer getVal(String traversal, AtomicInteger n, AtomicInteger pos) {
        int val = 0;
        while (pos.get() < n.get() && traversal.charAt(pos.get()) >= '0' && traversal.charAt(pos.get()) <= '9') {
            val = val * 10 + (traversal.charAt(pos.get()) - '0');
            pos.getAndIncrement();
        }
        return val;
    }

    private static void buildTree(TreeNode currentNode, int expectedDashLen, String traversal, AtomicInteger n, AtomicInteger pos) {
        if (pos.get() == n.get()) return;
        
        int prevPos = pos.get();
        int dashLen = getDashLen(traversal, n, pos);
        
        if (dashLen < expectedDashLen){
            pos.set(prevPos);
            return;
        }
        
        int nodeVal = getVal(traversal, n, pos);
        TreeNode newNode = new TreeNode(nodeVal);
        
        if (currentNode.left == null)
            currentNode.left = newNode;
        else 
            currentNode.right = newNode;
        
        buildTree(newNode, 1 + expectedDashLen, traversal, n, pos);
        buildTree(newNode, 1 + expectedDashLen, traversal, n, pos);
        
    }

    private static int getDashLen(String traversal, AtomicInteger n, AtomicInteger pos) {
        int dashLen = 0;
        while (pos.get() < n.get() && traversal.charAt(pos.get()) == '-'){
            dashLen++;
            pos.getAndIncrement();
        }
        return dashLen;
    }

    public static void main(String[] args) {
        TreeNode tree = recoverFromPreorder("1-2--3--4-5--6--7");

        TreeNode.inorderTraversal(tree);
    }
}
