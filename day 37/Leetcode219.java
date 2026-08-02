import java.util.HashMap;
import java.util.Scanner;

public class Leetcode219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                int previousIndex = map.get(nums[i]);

                if (i - previousIndex <= k) {
                    return true;
                }
            }

            // Update the latest index of the current number
            map.put(nums[i], i);
        }

        return false;
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

        // Input value of k
        int k = sc.nextInt();

        // Check for nearby duplicates
        boolean result = containsNearbyDuplicate(nums, k);

        System.out.println(result);

        sc.close();
    }
}