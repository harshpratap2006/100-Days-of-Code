/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:
Input: n = 1
Output: [[1]*/

public class SpiralMatrixII {

    // Function to generate an n x n spiral matrix
    public int[][] generateMatrix(int n) {

        // Create an n x n matrix
        int[][] matrix = new int[n][n];

        // Number to be inserted into the matrix
        int k = 1;

        // Define the four boundaries of the current layer
        int sr = 0;      // Starting Row
        int sc = 0;      // Starting Column
        int er = n - 1;  // Ending Row
        int ec = n - 1;  // Ending Column

        // Continue until all numbers from 1 to n*n are filled
        while (k <= n * n) {

            // Fill from left to right
            for (int j = sc; j <= ec; j++) {
                matrix[sr][j] = k++;
            }

            // Fill from top to bottom
            for (int i = sr + 1; i <= er; i++) {
                matrix[i][ec] = k++;
            }

            // Fill from right to left
            // Execute only if a valid bottom row exists
            if (sr <= er) {
                for (int j = ec - 1; j >= sc; j--) {
                    matrix[er][j] = k++;
                }
            }

            // Fill from bottom to top
            // Execute only if a valid left column exists
            if (sc <= ec) {
                for (int i = er - 1; i >= sr + 1; i--) {
                    matrix[i][sc] = k++;
                }
            }

            // Move towards the inner layer
            sr++;
            sc++;
            er--;
            ec--;
        }

        return matrix;
    }

    // Main function
    public static void main(String[] args) {

        SpiralMatrixII obj = new SpiralMatrixII();

        int n = 4;

        int[][] result = obj.generateMatrix(n);

        // Print the generated matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", result[i][j]);
            }
            System.out.println();
        }
    }
}
