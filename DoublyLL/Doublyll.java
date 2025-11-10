import java.util.*;
public class Doublyll {

    public static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public Node head;
    public Node tail;
    public int size;
    // add - first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    // remove last
    public void removeLast() {
        if (head == null) {
            System.out.println("DLL is empty");
            return;
        }
        size--;
        if (head.next == null) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }
    // print
    public void print() {
        if (head == null) {
            System.out.println("DLL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    // reverse
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        Doublyll dll = new Doublyll(); 
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.print();
    }
}
