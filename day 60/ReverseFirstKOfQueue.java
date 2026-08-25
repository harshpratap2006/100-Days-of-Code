import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKOfQueue {
    public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {

        // Edge case
        if (q == null || q.isEmpty() || k <= 0 || k > q.size()) {
            return q;
        }

        Stack<Integer> s = new Stack<>();

        // 1. Push first k elements into stack
        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }

        // 2. Add elements back to queue
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        // 3. Rotate remaining elements to the back
        int remainingElements = q.size() - k;

        for (int i = 0; i < remainingElements; i++) {
            q.add(q.remove());
        }

        return q;
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        int k = 3;

        System.out.println("Original Queue: " + q);

        q = reverseFirstK(q, k);

        System.out.println("After reversing first " + k + " elements: " + q);
    }
}
