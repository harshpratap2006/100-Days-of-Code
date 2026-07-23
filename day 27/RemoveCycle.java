public class RemoveCycle {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Remove cycle using Floyd's Algorithm
    static void removeCycle(Node head) {

        Node slow = head;
        Node fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        // No cycle
        if (fast == null || fast.next == null) {
            System.out.println("No Cycle Found");
            return;
        }

        // Find starting point of cycle
        slow = head;

        if (slow == fast) {
            while (fast.next != slow)
                fast = fast.next;
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Remove cycle
        fast.next = null;

        System.out.println("Cycle Removed");
    }

    // Print Linked List
    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // Creating nodes
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        // Linking nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Create cycle manually
        // 5 -> 3
        fifth.next = third;

        System.out.println("Cycle Created");

        removeCycle(head);

        System.out.println("Linked List after removing cycle:");
        display(head);
    }
}