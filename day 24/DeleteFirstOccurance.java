/*
Problem: Delete First Occurrence of a Key - Implement using linked list with dynamic memory allocation.

Input:
- First line: integer n
- Second line: n space-separated integers
- Third line: integer key

Output:
- Print the linked list elements after deletion, space-separated

Example:
Input:
5
10 20 30 40 50
30

Output:
10 20 40 50

Explanation:
Traverse list, find first node with key, remove it by adjusting previous node's next pointer.*/

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}



public class DeleteFirstOccurance {

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static Node deleteNode(Node head, int key){
        if (head == null)
        return null;

        // Delete head
        if (head.data == key)
            return head.next;

        Node prev = head;
        Node curr = head.next;

        while(curr != null){
            if (curr.data == key) {
                prev.next = curr.next;
                break;
            }
            curr = curr.next;
            prev = prev.next;
        }
        return head;
    }

    public static void main(String[] args) {

        Node first = new Node(10);
        first.next = new Node(20);
        first.next.next = new Node(30);
        first.next.next.next = new Node(40);
        first.next.next.next.next = new Node(50);

        printList(first);

        // deleteNode(first,30);
        first = deleteNode(first, 30);
        printList(first);

    }

}
