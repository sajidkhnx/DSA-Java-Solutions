import java.util.*;
public class searchInBst {

    public static class Node{
        int data;
        Node left;
        Node right;
    
    Node(int data){
        this.data = data;
    }
}

public static Node insert (Node root, int val){
    if(root==null){
            root = new Node(val);
            return root;
    }
    if(root.data>val){
        root.left = insert (root.left,val);
    }
    else{
        root.right = insert(root.right, val);
    }
    return root;
}
public static void inorder(Node root){
    if(root==null){
        return;
    }
    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
}
// Searching Key Value in BST
public static boolean search(Node root,int val){
    if(root==null) return false; // condition 1

    if(root.data==val) return true; // key found at root

    if(root.data>val){
        return search(root.left,val); // go left
    }
    else{
        return search(root.right,val); // go right
    }
}
public static void main(String[] args) {
    int val[] = {5,1,3,4,2,7,6,9,8,10};
    Node root = null;
    for(int i=0;i<val.length;i++){
        root = insert(root, val[i]);
    }

    // inorder(root);
    System.out.println(search(root, 812));
}
}