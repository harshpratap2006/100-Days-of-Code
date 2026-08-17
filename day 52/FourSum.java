import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // Sorting helps use two pointers and skip duplicate values.
        Arrays.sort(nums);

        int n = nums.length;

        // Select the first number.
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate first numbers.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Select the second number.
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate second numbers.
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                // Find the remaining two numbers using two pointers.
                while (left < right) {
                    // Use long to prevent integer overflow.
                    long sum = (long) nums[i] + nums[j]
                             + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(
                                nums[i], nums[j], nums[left], nums[right]
                        ));

                        left++;
                        right--;

                        // Skip duplicate values at the left pointer.
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicate values at the right pointer.
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        System.out.println(fourSum(nums1, target1));
        // [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]

        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        System.out.println(fourSum(nums2, target2));
        // [[2, 2, 2, 2]]
    }
}