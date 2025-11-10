public class zigzag {
    Node head;

    // Node class definition
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Print the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Find the middle node
    private Node getMid(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Zigzag rearrangement for linked list
    public void opzigzag() {
        if (head == null || head.next == null) {
            return;
        }
        // find mid
        Node mid = getMid(head);
        // reverse second half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node newLeft = head;
        Node newRight = prev;
        Node nextL, nextR;
        // zigzag merge
        while (newLeft != null && newRight != null) {
            nextL = newLeft.next;
            newLeft.next = newRight;
            nextR = newRight.next;
            newRight.next = nextL;
            newLeft = nextL;
            newRight = nextR;
        }
    }

   public static void main(String[] args) {
    zigzag ll = new zigzag();
    // Insert in reverse order to get 1->2->3->4->5
    ll.addFirst(5);
    ll.addFirst(4);
    ll.addFirst(3);
    ll.addFirst(2);
    ll.addFirst(1);
    ll.printList();
    ll.opzigzag();
    ll.printList();
}
}