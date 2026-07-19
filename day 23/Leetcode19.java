/*
LeetCode 19 - Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end
of the list and return its head.

Example:
Input: 1 -> 2 -> 3 -> 4 -> 5, n = 2
Output: 1 -> 2 -> 3 -> 5

Input: 1, n = 1
Output: Empty List
*/

// Definition for singly-linked list.
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

public class Leetcode19 {

    // Function to remove the nth node from the end
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 1: Calculate the size (length) of the linked list
        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // Step 2: If the node to be removed is the first node,
        // simply move the head to the next node.
        if (n == size) {
            return head.next;
        }

        // Step 3: Find the node just before the node to be deleted.
        // The node to delete is at position (size - n + 1),
        // so we stop at position (size - n).
        int i = 1;
        int iToFind = size - n;

        ListNode prev = head;

        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        // Step 4: Delete the nth node from the end
        // by skipping over it.
        prev.next = prev.next.next;

        // Step 5: Return the updated linked list
        return head;
    }

    // Function to print the linked list
    public static void printList(ListNode head) {

        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Creating the linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        int n = 2;

        Leetcode19 obj = new Leetcode19();

        head = obj.removeNthFromEnd(head, n);

        System.out.println("\nLinked List After Removing " + n + "th Node From End:");
        printList(head);
    }
}