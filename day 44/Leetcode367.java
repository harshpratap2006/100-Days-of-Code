import java.util.Scanner;

public class Leetcode367 {

    public static boolean isPerfectSquare(int num) {

        int left = 1;
        int right = num;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            long square = (long) mid * mid;

            if (square == num) {
                return true;
            } 
            else if (square < num) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input
        int num = sc.nextInt();

        // Check whether num is a perfect square
        boolean result = isPerfectSquare(num);

        // Output
        System.out.println(result);

        sc.close();
    }
}