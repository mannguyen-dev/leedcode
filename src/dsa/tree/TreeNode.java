package dsa.tree;

import java.util.ArrayList;

public class TreeNode {
    String data;
    ArrayList<TreeNode> children;

    public TreeNode(String data){
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }

    public void addChildren(TreeNode node) {
        this.children.add(node);
    }

    public String print(int level){
        StringBuilder ret;
        ret = new StringBuilder("  ".repeat(level) + data + "\n");
        for (TreeNode node : this.children){
            ret.append(node.print(level + 1));
        }
        return ret.toString();
    }
}
