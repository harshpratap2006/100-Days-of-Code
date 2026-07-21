/*
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Example 1:

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []*/

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Leetcode203 {

    // Function to remove all nodes whose value equals 'key'
    public static ListNode removeElements(ListNode head, int key) {

        // Edge case: Empty linked list
        if (head == null)
            return null;

        // Remove all nodes from the beginning whose value equals 'key'
        // Example: 6 -> 6 -> 6 -> 1 -> 2
        // After this loop: 1 -> 2
        while (head != null && head.val == key) {
            head = head.next;
        }

        // If every node was deleted, return null
        if (head == null)
            return null;

        // prev always points to the last node that we are keeping
        ListNode prev = head;

        // curr is the node currently being checked
        ListNode curr = head.next;

        // Traverse the remaining list
        while (curr != null) {

            // If current node contains the key,
            // remove it by skipping the node
            if (curr.val == key) {

                // Link previous node directly to the next node
                prev.next = curr.next;

                // Stay on the same prev because there might be
                // multiple consecutive nodes with the key
                curr = prev.next;

            } else {

                // Current node is valid, so move both pointers forward
                prev = curr;
                curr = curr.next;
            }
        }

        // Return the updated head of the linked list
        return head;
    }

    // Function to print the linked list
    public static void printList(ListNode head) {

        if (head == null) {
            System.out.println("null");
            return;
        }

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null)
                System.out.print(" -> ");

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Creating the linked list:
        // 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.println("Original Linked List:");
        printList(head);

        int key = 6;

        head = removeElements(head, key);

        System.out.println("\nLinked List after removing " + key + ":");
        printList(head);
    }
}