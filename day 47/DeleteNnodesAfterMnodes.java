// Given a linked list, delete n nodes after skipping m nodes of a linked list until the last of the linked list.

// Examples:

// Input: head: 9 -> 1 -> 3 -> 5 -> 9 -> 4 -> 10 -> 1, n = 1, m = 2

// Output: 9 -> 1 -> 5 -> 9 -> 10 -> 1

// Explanation: Deleting 1 node after skipping 2 nodes each time, we have list as 9 -> 1 -> 5 -> 9 -> 10 -> 1.
// Input: head: 1 -> 2 -> 3 -> 4 -> 5 -> 6, n = 1, m = 6

// Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6

// Explanation: After skipping 6 nodes for the first time , we will reach of end of the linked list, so, we will get the given linked list itself.
public class DeleteNnodesAfterMnodes {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node deleteNAfterM(Node head, int m, int n) {
        Node current = head;

        while (current != null) {
            // Skip m nodes
            for (int i = 1; i < m && current != null; i++) {
                current = current.next;
            }

            if (current == null) {
                break;
            }

            // Delete n nodes
            Node temp = current.next;
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;
            }

            // Link the m-th node to the node after the deleted nodes
            current.next = temp;

            // Move to the next node to continue the process
            current = temp;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6); //1 -> 2 -> 3 -> 4 -> 5 -> 6


        int m = 2;
        int n = 1;  // Delete 1 node after skipping 2 nodes

        head = deleteNAfterM(head, m, n); // output: 1 -> 2 -> 4 -> 5 

        // Print the modified linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
