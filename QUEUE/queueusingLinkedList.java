public class circularQueueusingArray {
    public class node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static class queue {
        static Node head =null;
        static Ndoe tail =null;

        public boolean isEmpty() {
            return head==null & tail == null;
        }
        // add

        public void add(int data) {
            Node newNode = new Node(data);
            if(head==null){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode; 
        }

        public int remove() {  // ✅ Changed return type
            if (isEmpty()) {
                System.out.println("Queue is Empty !! Can't remove any Data.");
                return -1;
            }
            int front =  head.data;
            //single element hai
            if(rear == front ){
                tail = head = null;
            }
            else{
                head = head.next;
            }
            return front;
        }
        //peek 
        public int peek() {
            if (isEmpty()) {
                System.err.println("Queue is Empty !!");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        queue q = new queue();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        System.out.println(q.remove());
        System.out.println(q.remove());

        q.add(60);
        q.add(70);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
