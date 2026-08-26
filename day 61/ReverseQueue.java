import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ReverseQueue {
    public static Queue<Integer> reverseQueue(Queue<Integer>q){
        Stack<Integer> s = new Stack<>();

        // Move all elements from queue to stack
        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        // Move all elements back from stack to queue
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println("Original Queue: " + q);

        q = reverseQueue(q);

        System.out.println("Reversed Queue: " + q);

        

    }
}
