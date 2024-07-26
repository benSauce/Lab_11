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
    }// END OF inOrder


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
        //Current node is visited first
        stack.push(root);

        // Push right and then left child to stack
        // The left child is pushed last so that it is processed first
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
    } // END OF preOrder

    //public void postOrder()
    //no parameter constructor
    public void postOrder() {
        postOrder(root);
    }

    /*
     *  void postOrder()
     *  description: Takes a TreeNode and calculates the height of that Treenode
     *  by recursively calculating the heights of the left and right Treenode and only adding the max of both.
     *  parameters: TreeNode<E>
     *  returns: int
     */
    protected void postOrder(TreeNode<E> root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode<E>> stack1 = new Stack<>();
        Stack<TreeNode<E>> stack2 = new Stack<>();

        // Push root to first stack
        stack1.push(root);

        //Run while first stack is not empty
        while (!stack1.isEmpty()) {
            //Pop element from first stack and push to the second stack
            TreeNode<E> current = stack1.pop();
            stack2.push(current);

            //Push left and right children of the removed element to the first stack
            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        //Print all elements of the second stack
        while (!stack2.isEmpty()) {
            TreeNode<E> current = stack2.pop();
            System.out.print(current.element + " ");
        }

    }// END OF postOrder

}