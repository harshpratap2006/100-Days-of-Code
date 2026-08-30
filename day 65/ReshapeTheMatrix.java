public class ReshapeTheMatrix {

    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;

        // Check if reshaping is possible
        if (m * n != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];

        int row = 0;
        int col = 0;

        // Traverse original matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                result[row][col] = mat[i][j];

                col++;

                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }

        return result;
    }

    // Print matrix
    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] mat = {
            {1, 2},
            {3, 4}
        };

        int r = 1;
        int c = 4;

        System.out.println("Original Matrix:");
        printMatrix(mat);

        int[][] result = matrixReshape(mat, r, c);

        System.out.println("Reshaped Matrix:");
        printMatrix(result);
    }
}