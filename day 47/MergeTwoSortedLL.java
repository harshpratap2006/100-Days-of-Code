public class MergeTwoSortedLL {
    public static class ListNode {
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
    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        // Handle empty lists
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        // Dummy node helps us build the merged list easily
        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;

        // Compare both lists and attach the smaller node
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // Attach the remaining nodes
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        // Skip the dummy node
        return mergedLL.next;
    }
    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null)
                System.out.print(" -> ");

            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // Creating the first sorted linked list: 1 -> 3 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        // Creating the second sorted linked list: 2 -> 4 -> 6
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        // Merging the two sorted linked lists
        ListNode mergedHead = mergeTwoLists(head1, head2);

        // Printing the merged linked list
        printList(mergedHead);
    }
}
