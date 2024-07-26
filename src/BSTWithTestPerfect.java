/*
 *  CS 2013
 *  Lab 11 - BST With Test Perfect
 *  Benjamin Saucedo
 *  Write a method that tests whether the BST is complete
 *  Meaning it is full at every level
 */
public class BSTWithTestPerfect<E> extends BST {
    protected java.util.Comparator<E> c;
    /** Create a default BST with a natural order comparator */
    public BSTWithTestPerfect() {
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
    }

    /** Create a BST with a specified comparator */
    public BSTWithTestPerfect(java.util.Comparator<E> c) {
        this.c = c;
    }

    /** Create a binary tree from an array of objects */
    public BSTWithTestPerfect(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    // Helper method to calculate the depth of the tree
    private int depth(TreeNode node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }

    public boolean isPerfect(TreeNode root, int d, int level) {
        //if empty then perfect
        if (root == null) {
            return true;
        }

        //if leaf node, check if its level is equal to expected depth
        if (root.left == null && root.right == null) {
            return d == level + 1;
        }

        //If current node only has 1 child then not perfect
        if (root.left == null || root.right == null) {
            return false;
        }

        //recursively call left and right subtrees to check for perfect
        return isPerfect(root.left, d, level + 1) &&
                isPerfect(root.right, d, level + 1);
    }

    //Check if the bst is perfect
    public boolean isPerfectBST() {
            int d = depth(root);
            return isPerfect(root, d, 0);
    }

    public static void main(String[] args) {
        String[] stringArr = {"Tom", "George", "Jean", "Jane", "kevin", "Peter",
                "Susan", "Jen", "Kim", "Michael", "Michelle"};

        BSTWithTestPerfect<String> tree1 = new BSTWithTestPerfect<>(stringArr);

        System.out.println("Is tree1 perfect?");
        if (tree1.isPerfectBST()) {
            System.out.print(" true");
        }
        else {
            System.out.println(" false");
        }

        Integer[] intArr = {50, 45, 75, 18, 49, 51, 98};
        BSTWithTestPerfect<Integer> tree2 = new BSTWithTestPerfect<>(intArr);

        System.out.println("Is tree2 perfect?");
        if (tree2.isPerfectBST()) {
            System.out.print(" true");
        }
        else {
            System.out.println(" false");
        }

    }
}
