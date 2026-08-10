import java.util.Stack;

public class StockSpan {
    public static int[] StackSpanBrute(int[] prices){
        int n = prices.length;
        int[] span = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 1;
            int j = i-1;

            // walk background while price is <= current price
            while (j>=0 && prices[j]<=prices[i]) {
                count++;
                j--;
            }
            span[i] = count;
        }
        return span;
    }

    public static int[] StackSpanEfficient(int[] prices){
        int n = prices.length;
        int[] span = new int[n];

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            // pop indices whose prices is <= current price
            while (!s.empty() && prices[s.peek()]<= prices[i]) {
                s.pop();
            }
            // if the stack is empty -> span covers all days so far
            // else -> span is distributed to nearest greater price day
            if (s.isEmpty()) {
                span[i] = i+1;
            } else {
                span[i] = i - s.peek();
            }
            // push current index for future reference
            s.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] result = StackSpanBrute(prices);
        System.out.print("Span: ");
        for (int s : result) {
            System.out.print(s + " ");
        }
    }
}
