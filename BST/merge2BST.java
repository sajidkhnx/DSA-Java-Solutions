import java.lang.reflect.Array;
import java.util.*;
public class merge2BST {
    static class Node {
        Node left;
        int data;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void getInOrder(Node root, ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        getInOrder(root.left, arr);
        arr.add(root.data);
        getInOrder(root.right, arr);
    }
    public static Node createBST(ArrayList<Integer> arr, int st, int end){
        if(st>end){
            return null;
        }
        int mid  = (st + end) /2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, st, mid-1);
        root.right =createBST(arr, mid+1, end);
        return root;
    }
    public static Node mergeBST(Node root1, Node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInOrder(root1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOrder(root2, arr2);
        // merge two sorted arrays
        int i = 0; int j =0;
        ArrayList<Integer> finallist = new ArrayList<>();
        while(i<arr1.size()&&j<arr2.size()){
            if (arr1.get(i)<=arr2.get(j)){
                finallist.add(arr1.get(i));
                i++;
            }
            else{
                finallist.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            finallist.add(arr1.get(i));
                i++;    
        }
        while(j<arr2.size()){
            finallist.add(arr2.get(j));
            j++;
        }
        return createBST(finallist,0, finallist.size()-1);
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {

        // Example unbalanced BST
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBST(root1, root2);
        preorder(root);
    }

}