import java.util.Scanner;

public class Leetcode136 {

    public static int singleNumber(int[] nums) {
        int result = 0;

        // XOR all elements
        for (int num : nums) {
            result = result ^ num;
        }

        return result;
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

        // Find the single number
        int answer = singleNumber(nums);

        // Print result
        System.out.println(answer);

        sc.close();
    }
}