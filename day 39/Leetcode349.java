import java.util.HashSet;
import java.util.Scanner;

public class Leetcode349 {

    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        // Store elements of nums1
        for (int num : nums1) {
            set1.add(num);
        }

        // Find common elements
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert HashSet to array
        int[] result = new int[resultSet.size()];
        int index = 0;

        for (int num : resultSet) {
            result[index] = num;
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of first array
        int n = sc.nextInt();
        int[] nums1 = new int[n];

        // Input first array
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }

        // Input size of second array
        int m = sc.nextInt();
        int[] nums2 = new int[m];

        // Input second array
        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }

        int[] result = intersection(nums1, nums2);

        // Print result
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}