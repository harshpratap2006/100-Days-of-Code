import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leetcode118 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            // First and last element are always 1
            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int value = triangle.get(i - 1).get(j - 1)
                              + triangle.get(i - 1).get(j);
                    row.add(value);
                }
            }

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of rows
        int numRows = sc.nextInt();

        // Generate Pascal's Triangle
        List<List<Integer>> result = generate(numRows);

        // Print the triangle
        System.out.println(result);

        sc.close();
    }
}