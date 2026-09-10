class Leetcode61 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length and tail
        int n = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // Avoid unnecessary full rotations
        k = k % n;

        if (k == 0) {
            return head;
        }

        // Make the list circular
        tail.next = head;

        // Find the new tail
        int steps = n - k - 1;
        ListNode newTail = head;

        while (steps > 0) {
            newTail = newTail.next;
            steps--;
        }

        // Node after newTail becomes the new head
        ListNode newHead = newTail.next;

        // Break the circular list
        newTail.next = null;

        return newHead;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode result = rotateRight(head, k);

        printList(result);
    }
}