class MinStack {

    private Node head;

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(2);

        System.out.println("Top: " + stack.top());
        System.out.println("Minimum: " + stack.getMin());

        stack.pop();

        System.out.println("After pop:");
        System.out.println("Top: " + stack.top());
        System.out.println("Minimum: " + stack.getMin());

        stack.pop();

        System.out.println("After another pop:");
        System.out.println("Top: " + stack.top());
        System.out.println("Minimum: " + stack.getMin());
    }
}