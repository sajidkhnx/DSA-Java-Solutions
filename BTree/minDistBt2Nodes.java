import java.util.*;
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class minDistBt2Nodes {
    static class Info{
    Node node;
    int hd;

    public Info(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}
public static boolean getPath(Node root,int n,ArrayList<Node> path){
    if (root == null) {
            return false;
    }
    path.add(root);
    if(root.data == n){
        return true;
    }
    boolean foundright = getPath(root.right, n, path);
    boolean foundleft = getPath(root.left, n, path);

    if(foundleft || foundright){
        return true;
    }
    path.remove(path.size()-1);
    return false;
}
public static Node lca(Node root, int n1,int n2){
    ArrayList<Node> Path1 = new ArrayList<>();
    ArrayList<Node> Path2 = new ArrayList<>();
    
    getPath(root,n1,Path1);
    getPath(root,n2,Path2);

    // least common factor
    int i  = 0;
     for(; i < Path1.size() && i < Path2.size(); i++){
        if(Path1.get(i)!=Path2.get(i)){
            break;
        }
     }
     Node lca  = Path1.get(i-1);
     return lca;
}
public static int dist(Node root, int n){
    if(root == null){
        return -1;
    }
    if(root.data == n){
        return 0;
    }

    int leftdist = dist(root.left,n);
    int rightdist = dist(root.right,n);

    if(leftdist == -1 && rightdist ==-1){
        return -1;
    }
    else if (rightdist==-1 ) {
        return leftdist+1;
    }
    else{
        return rightdist+1;
    }
}
public static int mindist(Node root, int n1,int n2){
    Node lca = lca(root, n1, n2);
    int dist1 = dist (lca,n1);
    int dist2 = dist(lca,n2);
    return dist1+dist2;
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
        int n1 = 4;
        int n2 = 6;
        // System.out.println(lca(root, n1, n2).data);
        System.out.println("Minimun Distance Between Node "+n1+" and "+n2+" is "+mindist(root, n1, n2));
}
}
