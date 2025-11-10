import java.util.*;
import java.util.LinkedList;
public class KthlevelOfTree {
    static class Node {
        int data;
        Node left;
        Node right;
    
    Node (int data){
        this.data = data;
        this.left =this.right = null;
    }
}

 public static void klevelorderTraversal(Node root, int count, int k){
    if (root ==null){
        return;
    }
    Queue<Node> q  =  new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        int size  = q.size();
        count++;
        if(count==k){
            for(int i = 0;i<size;i++){
                Node curr = q.remove ();
                System.out.print(curr.data+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<size;i++){
            Node currNode = q.remove();
            if(currNode.left!=null){
                q.add(currNode.left);
            }
            if(currNode.right!=null){
                q.add(currNode.right);
            }
        }
    }
 }

 public static void Kthlevel(Node root,int level,int k){
    if(root == null){
        return;
    }
    if(level == k){
        System.out.print (root.data+" "); return;
    }
    Kthlevel(root.left, level+1,k);
    Kthlevel(root.right,level+1,k);
 } 
 
public static void main(String[] args) {
        // Build main tree: 1 2 3 4 5 6
        int level = 1;
        int k =3;

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // klevelorderTraversal(root,count,k);
        Kthlevel(root,level,k);
}
}