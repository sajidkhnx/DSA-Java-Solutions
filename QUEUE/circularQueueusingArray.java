public class circularQueueusingArray {

    public static class queue {
        int arr[];
        int size;
        int rear;
        int front;

        queue(int n) {  
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is Already Full!!");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int remove() {  // ✅ Changed return type
            if (isEmpty()) {
                System.err.println("Queue is Empty !! Can't remove any Data.");
                return -1;
            }
            int result = arr[front];

            // if only one element
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        public int peek() {
            if (isEmpty()) {
                System.err.println("Queue is Empty !!");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        queue q = new queue(5);
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
