import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class TestBST {
    public static void main(String[] args) {
        // Create a BST
        StackBST<String> tree = new StackBST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        // Traverse tree
        System.out.print("Inorder (sorted): ");
        tree.inorder();
        System.out.print("\nInorder (STACKSorted): ");
        tree.inOrder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();

        System.out.print("\nHeight of BST: ");
        System.out.print(tree.height());

        System.out.print("\nThe number of nodes is " + tree.getSize());

        // Search for an element
        System.out.print("\nIs Peter in the tree? " + tree.search("Peter"));

        // Get a path from the root to Peter
        System.out.print("\nA path from the root to Peter is: ");
        ArrayList<TreeNode<String>> path = tree.path("Peter");
        for (int i = 0; path != null && i < path.size(); i++){
            System.out.print(path.get(i).element + " ");
        }

        Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
        BST<Integer> intTree = new BST<>(numbers);
        System.out.print("\nInorder (sorted): ");
        intTree.inorder();


        Integer[] numList = new Integer[10];
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        //Prompt for string input
        System.out.print("\nEnter 10 ints: ");

        //prompts the user to enter an integer

        //Add numbers to numList until 0 is entered
        for (int i = 0; i < 10; i++) {
            numList[i] = input.nextInt();
        }

        System.out.print("\n " + Arrays.stream(numList).toList());

        //To BST
        StackBST<Integer> intTree2 = new StackBST<>(numList);
        BST<Integer> intTree3 = new BST<>(numList);
        System.out.print("\nPreOrder (Sorted): ");
        intTree2.preOrder();

        System.out.println("\n \n \n");
        intTree3.preorder();

    }
}
