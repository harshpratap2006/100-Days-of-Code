public class PalindromeLL {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Reverse linked list
    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Check if palindrome
    public boolean isPalindrome() {

        if (head == null || head.next == null)
            return true;

        // Find middle
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow.next);

        // Compare both halves
        Node firstHalf = head;
        Node temp = secondHalf;

        while (temp != null) {
            if (firstHalf.data != temp.data)
                return false;

            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        return true;
    }

    // Display linked list
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {

        PalindromeLL list = new PalindromeLL();

        // Palindrome List: 1 -> 2 -> 3 -> 2 -> 1
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(2);
        list.insert(1);

        System.out.println("Linked List:");
        list.display();

        if (list.isPalindrome()) {
            System.out.println("The linked list is a Palindrome.");
        } else {
            System.out.println("The linked list is NOT a Palindrome.");
        }
    }
}