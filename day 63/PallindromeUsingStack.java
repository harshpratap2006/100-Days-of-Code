import java.util.Stack;

public class PallindromeUsingStack {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> s = new Stack<>();
        ListNode temp = head;

        while (temp != null) {
            s.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if (temp.val != s.peek()) {
                return false;
            }

            temp = temp.next;
            s.pop();
        }

        return true;
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 2 -> 1

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        if (isPalindrome(head)) {
            System.out.println("Linked List is a Palindrome");
        } else {
            System.out.println("Linked List is not a Palindrome");
        }
    }
}

