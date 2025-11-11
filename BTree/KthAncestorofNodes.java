import java.util.*;
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class KthAncestorofNodes {
    static class Info{
    Node node;
    int hd;

    public Info(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}
public static int kthancestor(Node root,int n,int k){
    if (root == null){
        return -1;
    }
    if (root.data ==n){
        return 0;
    }
    int leftdist = kthancestor(root.left, n, k);
    int rightdist = kthancestor(root.right, n, k);
    if(leftdist==-1 && rightdist==-1){
        return -1;
    }
    int maxdist = Math.max(leftdist, rightdist);

    if (maxdist+1==k){
        System.out.println("Ancestor Node = "+root.data);
    }
    return maxdist+1;
}

public static void main(String[] args) {
        // Build main tree: 1 2 3 4 5 6
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right = new Node(8);
        int n = 8;
        int k = 1;
        System.out.println( "Distance = "+ kthancestor(root, n, k));
}
}
