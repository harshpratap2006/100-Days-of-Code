/*
LeetCode 876 - Middle of the Linked List

Given the head of a singly linked list, return the middle node.
If there are two middle nodes, return the second middle node.

Example:
Input: 1 -> 2 -> 3 -> 4 -> 5
Output: 3 -> 4 -> 5

Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6
Output: 4 -> 5 -> 6
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

public class Leetcode876 {

    // Function to find the middle node
    public ListNode middleNode(ListNode head) {

        // Initialize both pointers at the head
        ListNode slow = head;
        ListNode fast = head;

        // Move slow by 1 step and fast by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // When fast reaches the end,
        // slow will be at the middle node.
        return slow;
    }

    // Function to print a linked list
    public static void printList(ListNode head) {
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

        Leetcode876 obj = new Leetcode876();

        ListNode middle = obj.middleNode(head);

        System.out.println("\nMiddle Node onwards:");
        printList(middle);

        System.out.println("\nMiddle Node Value: " + middle.val);
    }
}