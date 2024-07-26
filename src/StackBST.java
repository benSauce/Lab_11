import java.util.Stack;

public class StackBST<E> extends BST {

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
        if (root == null) return;

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

}