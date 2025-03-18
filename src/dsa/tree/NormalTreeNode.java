package dsa.tree;

import java.util.ArrayList;

public class NormalTreeNode {
    String data;
    ArrayList<NormalTreeNode> children;

    public NormalTreeNode(String data){
        this.data = data;
        this.children = new ArrayList<NormalTreeNode>();
    }

    public void addChildren(NormalTreeNode node) {
        this.children.add(node);
    }

    public String print(int level){
        StringBuilder ret;
        ret = new StringBuilder("  ".repeat(level) + data + "\n");
        for (NormalTreeNode node : this.children){
            ret.append(node.print(level + 1));
        }
        return ret.toString();
    }
}
