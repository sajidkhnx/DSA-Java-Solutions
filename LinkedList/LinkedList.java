public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void addMiddle(int index, int data) {
        Node newNode = new Node(data);
        if (head == null || index == 0) {
            addFirst(data);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp.next == null) {
                addLast(data);
                return;
            }
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }
    public void removeFirst() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        size--;
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }
    public void removeLast() {  
        if (head == null) { 
            System.out.println("LL is empty");
            return;
        }
        if (head.next == null) {
            head = tail = null;
            size--;
            return;
        }
        Node prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }
        prev.next = null;
        tail = prev;
        size--;
    }
    // iterative search
    public int iterativeSearch(int key) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == key) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1; // not found
    }
    // Recursive search

    public int recSearchHelper(Node head, int key) {
        if (head == null) {
            return -1; // not found
        }
        if (head.data == key) {
            return 0;
        }
        int idx = recSearchHelper(head.next, key);
        if (idx == -1) {
            return -1; // not found
        }
        return idx + 1;
    }

    public int recSearch(int key) {
        return recSearchHelper(head, key);
    }
    // reverse a linked list
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void deleteNthfromEnd(int n){
        int sz = 0;
        Node temp = head;
        while (temp!=null){
            temp = temp.next;
            sz++;
        }
        if (n==sz){
            head = head.next; //remove first
            return;
        }

        // sz-n
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i<iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }


    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        li.print();
        li.addFirst(1);
        li.print();
        li.addFirst(2);
        li.print();
        li.addFirst(3);
        li.print();
        li.addFirst(4);
        li.print();
        li.addFirst(5);
        li.print();
        // li.addLast(6);
        // li.addMiddle(3, 69);
        li.print();
        System.out.println(li.size);
        // li.removeLast();
        // if (li.recSearch(3) == -1) {
        //     System.out.println("not found");
        // } else {
        //     System.out.println("found at index: " + li.recSearch(3));
        // }
        li.reverseList(null);
        li.print();
    }
}