import java.util.Arrays;
import java.util.Stack;

class MaxArea {
    public static int[] nextSmallerRight(int[] arr) {
        int[] nextSmallerRight = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nextSmallerRight[i] = arr.length;
            } else {
                nextSmallerRight[i] = stack.peek();
            }

            stack.push(i);
        }

        return nextSmallerRight;
    }

    public static int[] nextSmallerLeft(int[] arr) {
        int[] nextSmallerLeft = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nextSmallerLeft[i] = -1;
            } else {
                nextSmallerLeft[i] = stack.peek();
            }

            stack.push(i);
        }

        return nextSmallerLeft;
    }

    public static int largestRectangleArea(int[] heights) {
        int[] nsr = nextSmallerRight(heights);
        int[] nsl = nextSmallerLeft(heights);

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int currentArea = height * width;

            maxArea = Math.max(maxArea, currentArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        int[] nsr = nextSmallerRight(heights);
        int[] nsl = nextSmallerLeft(heights);
        int answer = largestRectangleArea(heights);

        System.out.println("Heights: " + Arrays.toString(heights));
        System.out.println("Next smaller right: " + Arrays.toString(nsr));
        System.out.println("Next smaller left:  " + Arrays.toString(nsl));
        System.out.println("Largest rectangle area: " + answer);
    }
}