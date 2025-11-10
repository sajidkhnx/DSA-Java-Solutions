class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class SubtreeOfAnotherTree{

    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }
        if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        return isIdentical(node.left, subRoot.left) &&
               isIdentical(node.right, subRoot.right);
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        // Build main tree: 1 2 3 4 5 6
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        // Build subtree: 2 4 5
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot)); // Output: true
    }
}
