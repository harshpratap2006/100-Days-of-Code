/*
Problem: LeetCode 707 - Design Linked List

Operations Supported:
1. get(index)
2. addAtHead(val)
3. addAtTail(val)
4. addAtIndex(index, val)
5. deleteAtIndex(index)

Time Complexity:
get()            -> O(n)
addAtHead()      -> O(1)
addAtTail()      -> O(n)
addAtIndex()     -> O(n)
deleteAtIndex()  -> O(n)

Space Complexity:
O(1) Extra Space

Important Rules:
1. Head points to the first node.
2. Size stores the current number of nodes.
3. Validate index before every operation.
4. For insertion:
      index == 0      -> addAtHead()
      index == size   -> addAtTail()
      index > size    -> do nothing
5. For deletion:
      index must satisfy
      0 <= index < size
*/

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DesignLL {

    // First node of the linked list
    private Node head;

    // Current number of nodes
    private int size;

    // Constructor
    public DesignLL() {
        head = null;
        size = 0;
    }

    // Return value at a particular index
    public int get(int index) {

        // Invalid index
        if (index < 0 || index >= size)
            return -1;

        Node temp = head;

        // Reach the required node
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.val;
    }

    // Insert at the beginning
    public void addAtHead(int val) {

        Node newNode = new Node(val);

        // New node points to current head
        newNode.next = head;

        // Update head
        head = newNode;

        size++;
    }

    // Insert at the end
    public void addAtTail(int val) {

        Node newNode = new Node(val);

        // Empty list
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node temp = head;

        // Reach last node
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        size++;
    }

    // Insert before the given index
    public void addAtIndex(int index, int val) {

        // Invalid index
        if (index < 0 || index > size)
            return;

        // Insert at head
        if (index == 0) {
            addAtHead(val);
            return;
        }

        // Insert at tail
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node newNode = new Node(val);

        Node temp = head;

        // Reach one node before the required index
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        // Insert the node
        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }

    // Delete node at the given index
    public void deleteAtIndex(int index) {

        // Invalid index
        if (index < 0 || index >= size)
            return;

        // Delete head
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node prev = null;
        Node curr = head;

        // Reach the required index
        for (int i = 0; i < index; i++) {
            prev = curr;
            curr = curr.next;
        }

        // Remove current node
        prev.next = curr.next;

        size--;
    }

    // Print Linked List
    public void printList() {

        if (head == null) {
            System.out.println("Linked List is Empty.");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null)
                System.out.print(" -> ");

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        DesignLL list = new DesignLL();

        System.out.println("Adding elements at head...");
        list.addAtHead(20);
        list.addAtHead(10);
        list.printList();

        System.out.println("\nAdding element at tail...");
        list.addAtTail(30);
        list.addAtTail(40);
        list.printList();

        System.out.println("\nAdding 25 at index 2...");
        list.addAtIndex(2, 25);
        list.printList();

        System.out.println("\nElement at index 3:");
        System.out.println(list.get(3));

        System.out.println("\nDeleting element at index 2...");
        list.deleteAtIndex(2);
        list.printList();

        System.out.println("\nDeleting head...");
        list.deleteAtIndex(0);
        list.printList();

        System.out.println("\nCurrent Size = " + list.size);
    }
}