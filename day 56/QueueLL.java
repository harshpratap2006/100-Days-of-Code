// implementing queue using linked list
class QueueLL {
    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        // isEmpty
        public static boolean isEmpty(){
            return head ==null && tail == null;
        }

        //add
        public static void add(int data){
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // remove
        public static int remove(){
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int front = head.data;
            // Single element
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        // peek
        public static int peek(){
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {

        Queue q = new Queue();

        // Check isEmpty
        System.out.println("Is queue empty? " + q.isEmpty());

        // Add elements
        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Is queue empty? " + q.isEmpty());

        // Peek
        System.out.println("Front element: " + q.peek());

        // Remove elements
        System.out.println("Removed: " + q.remove());
        System.out.println("Removed: " + q.remove());

        // Peek after removal
        System.out.println("Front element: " + q.peek());

        // Add another element
        q.add(40);

        System.out.println("Front element: " + q.peek());

        // Remove remaining elements
        System.out.println("Removed: " + q.remove());
        System.out.println("Removed: " + q.remove());

        // Queue should now be empty
        System.out.println("Is queue empty? " + q.isEmpty());

        // Try removing from empty queue
        System.out.println("Removed: " + q.remove());
    }
}