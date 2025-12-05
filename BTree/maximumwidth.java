import java.util.*;
import java.util.LinkedList;
public class maximumwidth {
    static class Node {
        int data;
        Node left;
        Node right;
    
    Node (int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
static class BinaryTree{
    static int idx = -1;
    public static Node buildTree(int nodes[]){
        idx++;
        if(nodes[idx]==-1){
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }


    // inorder traversal
   public static void maxwidth(Node root) {
    if (root == null) return;

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    int maxWidth = 0;

    while (!q.isEmpty()) {
        int levelSize = q.size();   // nodes in current level
        maxWidth = Math.max(maxWidth, levelSize);

        // Print the current level
        for (int i = 0; i < levelSize; i++) {
            Node curr = q.remove();
            System.out.print(curr.data + " ");

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        System.out.println();
    }

    // Height adjust as you wrote (ternary)
    int finalHeight = (maxWidth % 2 == 0) ? maxWidth : maxWidth + 1;

    System.out.println("Height of tree is " + finalHeight);
}
}
public static void main(String[] args) {
    int nodes[] = {1, 3, 5, -1, -1, 3, -1, -1, 2, -1, 9, -1, -1};
    int maxcount = 0;
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(nodes);
    // tree.preOrdertraversal(root);
    tree.maxwidth(root);
    // System.out.println("Number of Node = " +tree.countnodes(root));
    // System.out.println("Sum of Nodes = " +tree.sumnodes(root));
}
}
