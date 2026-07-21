/* Linked List Cycle II
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list. */

/*


Algorithm:
1. Use two pointers (slow & fast).
2. If they meet, a cycle exists.
3. Move slow back to head.
4. Move both pointers one step at a time.
5. The node where they meet again is the starting node of the cycle.

Time Complexity : O(n)
Space Complexity: O(1)

Interview Trick:
✔ Slow moves 1 step.
✔ Fast moves 2 steps.
✔ First meeting -> Cycle detected.
✔ Second meeting -> Start of the cycle.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycleII {

    // Function to detect the starting node of the cycle
    public static ListNode detectCycle(ListNode head) {

        // Edge case: Empty list
        if (head == null)
            return null;

        // Both pointers start from the head
        ListNode slow = head;
        ListNode fast = head;

        boolean cycle = false;

        // Step 1: Detect whether a cycle exists
        while (fast != null && fast.next != null) {

            // Slow moves one step
            slow = slow.next;

            // Fast moves two steps
            fast = fast.next.next;

            // If both pointers meet, a cycle exists
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        // No cycle found
        if (!cycle)
            return null;

        // Step 2:
        // Move slow back to the head.
        // Now move both pointers one step at a time.
        // They will meet at the starting node of the cycle.
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Return the starting node of the cycle
        return slow;
    }

    public static void main(String[] args) {

        /*
                3 → 2 → 0 → -4
                    ↑         |
                    |_________|

            Cycle starts at node with value 2
        */

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Creating the cycle
        head.next.next.next.next = head.next;

        ListNode cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node: " + cycleStart.val);
        } else {
            System.out.println("No cycle found.");
        }
    }
}
