import java.util.Scanner;

public class Leetcode268 {

    public static int missingNumber(int[] nums) {
        int n = nums.length;

        // Expected sum of numbers from 0 to n
        int expectedSum = n * (n + 1) / 2;

        // Actual sum of array elements
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // Missing number
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of array
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Find the missing number
        int answer = missingNumber(nums);

        // Print result
        System.out.println(answer);

        sc.close();
    }
}