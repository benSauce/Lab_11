//public class BSTWithHeight<E> extends BST {
//    //public int height()
//    //no parameter constructor
//    public int height() {
//        return height(root);
//    }
//
//    /*
//     *  public int height()
//     *  description: Takes a TreeNode and calculates the height of that Treenode
//     *  by recursively calculating the heights of the left and right Treenode and only adding the max of both.
//     *  parameters: TreeNode<E>
//     *  returns: int
//     */
//    public int height(TreeNode<E> root) {
//        //base case root == null
//        if (root == null) return -1;
//        //else recursive call both subtrees and only add the max
//        else
//            //add 1 for current(root) node
//            return 1 + Math.max(height(root.left), height(root.right));
//    }
//}
