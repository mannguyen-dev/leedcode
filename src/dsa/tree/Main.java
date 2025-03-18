package dsa.tree;

public class Main {
    public static void main(String[] args) {
        NormalTreeNode drinks = new NormalTreeNode("Drinks");
        NormalTreeNode hot = new NormalTreeNode("Hot");
        NormalTreeNode cold = new NormalTreeNode("Cold");
        NormalTreeNode wine = new NormalTreeNode("wine");
        NormalTreeNode tea = new NormalTreeNode("Tea");
        NormalTreeNode coffee = new NormalTreeNode("Coffee");
        NormalTreeNode beer = new NormalTreeNode("Beer");

        drinks.addChildren(hot);
        drinks.addChildren(cold);

        hot.addChildren(tea);
        hot.addChildren(coffee);

        cold.addChildren(wine);
        cold.addChildren(beer);

        System.out.println(drinks.print(0));
    }
}
