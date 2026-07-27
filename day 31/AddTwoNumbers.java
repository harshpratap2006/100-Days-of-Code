public class AddTwoNumbers {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int digit1 = 0;
            int digit2 = 0;

            if (l1 != null) {
                digit1 = l1.val;
            }

            if (l2 != null) {
                digit2 = l2.val;
            }

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            int digit = sum % 10;

            current.next = new ListNode(digit);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }

    // Create linked list from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }

    // Print linked list
    public static void printList(ListNode head) {
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

        // Number 342 represented as 2 -> 4 -> 3
        int[] num1 = {2, 4, 3};

        // Number 465 represented as 5 -> 6 -> 4
        int[] num2 = {5, 6, 4};

        ListNode l1 = createList(num1);
        ListNode l2 = createList(num2);

        System.out.print("First Number : ");
        printList(l1);

        System.out.print("Second Number: ");
        printList(l2);

        AddTwoNumbers solution = new AddTwoNumbers();

        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.print("Result       : ");
        printList(result);
    }
}