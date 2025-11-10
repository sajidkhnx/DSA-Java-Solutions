import java.util.*;
import java.util.LinkedList;
public class preOrderTraversal {
    static class Node {
        int data;
        Node left;
        Node right;
    
    Node (int data){
        this.data = data;
        this.left = null;
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

    public static void preOrdertraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrdertraversal(root.left);
        preOrdertraversal(root.right);
    } 
    // inorder traversal
    public static void levelorderTraversal(Node root, int count){
        if(root == null){
            return;
        }
         Queue <Node> q = new LinkedList<>();
         q.add(root);
         q.add(null); 
         while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                count++;
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
        System.out.println("Height of tree is "+count);
    }
    public static int countnodes(Node root){
        if (root == null){
            return 0;
        }
        int lcount = countnodes(root.left);
        int rcount = countnodes(root.right);
        int treecount = lcount+rcount+1;
        return treecount;
    }
    public static int sumnodes(Node root){
        if(root==null){
            return 0;
        }
        int lsum = sumnodes(root.left);
        int rsum = sumnodes(root.right);
        return lsum+rsum+root.data;
    }
}
public static void main(String[] args) {
    int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    int count = 0;
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(nodes);
    // tree.preOrdertraversal(root);
    // tree.levelorderTraversal(root,count);
    System.out.println("Number of Node = " +tree.countnodes(root));
    System.out.println("Sum of Nodes = " +tree.sumnodes(root));
}
}
