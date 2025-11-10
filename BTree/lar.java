import java.util.*;
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class lar {
    static class Info{
    Node node;
    int hd;

    public Info(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}
public static void topView(Node root){
     if (root == null) return;
    Queue<Info> q =  new LinkedList<>();
    HashMap <Integer, Node> map = new HashMap<>();
    
    int min = 0 , max = 0;
    q.add(new Info(root,0));

    while (!q.isEmpty()){
        Info curr = q.remove();
        // if(q.isEmpty()){
        //     break;
        // }
        // else{
        //     q.add(null);
        // }
        if(!map.containsKey(curr.hd)){ // first time horizontal distance add ho rha hai
            map.put(curr.hd, curr.node);
        }
        if (curr.node.left != null){
            q.add(new Info(curr.node.left, curr.hd-1));
            min = Math.min(min, curr.hd-1); // min max isliye lete hai kyuki isse pata chalta ki kaha se kaha tak map mein loop chalna hai value ke liye!!
        }
        if(curr.node.right !=null){
            q.add(new Info(curr.node.right, curr.hd+1));
            max = Math.max(max, curr.hd+1);
        }
    }
    for (int i = min; i<=max; i++){
        System.out.println(map.get(i).data);
    }
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
        topView(root);

}
}
