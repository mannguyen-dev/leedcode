package problem.p0xxx.p05xx.p889;

import problem.p1xxx.p1261.TreeNode;

public class Main {
    static int preIdx = 0;
    static int postInx = 0;

    public static void main(String[] args) {
        int[] prerorder = new int[]{1,2,4,5,3,6,7};
        int[] postorder = new int[]{4,5,2,6,7,3,1};
        TreeNode tree = constructFromPrePost(prerorder, postorder);
        TreeNode.inorderTraversal(tree);
    }

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode curr = new TreeNode(preorder[preIdx]);
        preIdx++;

        if (curr.val != postorder[postInx]){
            curr.left = constructFromPrePost(preorder, postorder);
        }

        if (curr.val != postorder[postInx]){
            curr.right = constructFromPrePost(preorder, postorder);
        }
        postInx++;
        return curr;
    }
}
