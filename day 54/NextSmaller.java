import java.util.Stack;

class NextSmaller {
    public static int[] NextSmallerRight( int[] arr){
        int[] nextSmallerRight = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length-1; i >= 0; i--) {
            // 1. while
            while (!s.isEmpty() && arr[s.peek()]>arr[i]) {
                s.pop();
            }

            // 2. if- else
            if(s.isEmpty()) nextSmallerRight[i] = -1;
            else nextSmallerRight[i] = s.peek();// we are not adding values to the next smaller array we are adding indexes

            // 3. push
            s.push(i);
        }
        return nextSmallerRight;
    }

    public static int[] NextSmallerLeft( int[] arr){
        int[] nextSmallerleft = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            // 1. while
            while (!s.isEmpty() && arr[s.peek()]>arr[i]) {
                s.pop();
            }

            // 2. if- else
            if(s.isEmpty()) nextSmallerleft[i] = -1;
            else nextSmallerleft[i] = s.peek();// we are not adding values to the next smaller array we are adding indexes


            // 3. push
            s.push(i);
        }
        return nextSmallerleft;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        int[] nextsmalleright = NextSmallerRight(arr);
        for (int i = 0; i < nextsmalleright.length; i++) {
            System.out.print(nextsmalleright[i]+ " ");
        }
        System.out.println();

        int[] nextSmallerleft = NextSmallerLeft(arr);
        for (int i = 0; i < nextSmallerleft.length; i++) {
            System.out.print(nextSmallerleft[i]+ " ");
        }
    }
}