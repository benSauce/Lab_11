import java.util.Stack;

public class StackBST<E> extends BST {
    protected java.util.Comparator<E> c;
    /** Create a default BST with a natural order comparator */
    public StackBST() {
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
    }

    /** Create a BST with a specified comparator */
    public StackBST(java.util.Comparator<E> c) {
        this.c = c;
    }

    /** Create a binary tree from an array of objects */
    public StackBST(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /**
     * Inorder traversal from the root
     */
    //public void inOrder()
    //no parameter constructor
    public void inOrder() {
        inOrder(root);
    }

    /*
     *  void inorder()
     *  description: Takes a TreeNode and calculates the height of that Treenode
     *  by recursively calculating the heights of the left and right Treenode and only adding the max of both.
     *  parameters: TreeNode<E>
     *  returns: int
     */
    protected void inOrder(TreeNode<E> root) {
        if (root == null){
            return;
        }

        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> current = root;

        while (current != null || !stack.isEmpty()) {
            //Find leftmost node of current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            //Once leftmost node is reached then we are at null
            current = stack.pop();
            System.out.print(current.element + " ");

            //After node and its left subtree
            //we then check the right subtree
            current = current.right;

        }
    }

    //public void preOrder()
    //no parameter constructor
    public void preOrder() {
        preOrder(root);
    }

    /*
     *  void preOrder()
     *  description: Takes a TreeNode and calculates the height of that Treenode
     *  by recursively calculating the heights of the left and right Treenode and only adding the max of both.
     *  parameters: TreeNode<E>
     *  returns: int
     */
    protected void preOrder(TreeNode<E> root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode<E>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<E> current = stack.pop();
            System.out.print(current.element + " ");

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }


    }

}