import java.util.*;
public class deleteanode {

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
public static Node delete (Node root,int val){
    if (root.data>val){
        root.left = delete(root.left, val);
    }
    else if(root.data<val){
        root.right = delete(root.right,val);
    }
    else{ // when root.data == val (found)
        // Case 1 : - leaf node
        if (root.left==null && root.right==null){
            return null;
        }
        // Case 2 : - single node
        if(root.left == null){
            return root.right;
        }
        else if(root.right==null){
            return root.left; 
        }
        // Case 3 : - Both are childeren ie.. need to find successor - left most node in the right subtree 
        Node IS = findinorderSuccessor(root.right);
        root.data = IS.data;
        root.right = delete(root.right, val);
    } 
    return root;
}
public static Node findinorderSuccessor(Node root){
    while(root.left!=null){
        root = root.left;
    }
    return root;
}
// find in range question 
public static void printInRange(Node root, int k1,int k2){
    if(root==null){
        return;
    }
    if(root.data >=k1 && root.data<=k2){
        printInRange(root.left, k1, k2);
        System.out.print(root.data+" ");
        printInRange(root.right, k1, k2);
    }
    else if(root.data<k1){
        printInRange(root.left, k1, k2);
    }
    else{
        printInRange(root.right, k1, k2);
    }
}
public static void main(String[] args) {
    int val[] = {8,5,3,1,4,6,10,11,14};
    Node root = null;
    for(int i=0;i<val.length;i++){
        root = insert(root, val[i]);
    }

    inorder(root);
    System.out.println();

    root = delete(root, 10);
    System.out.println();
    inorder(root);
    System.out.println(search(root, 812));
    // printInRange(root, 5, 12);
}
}