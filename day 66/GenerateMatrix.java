public class GenerateMatrix {

    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int k = 1;

        int sr = 0, sc = 0, er = n - 1, ec = n - 1;

        while (k <= n * n) {

            // Top
            for (int j = sc; j <= ec; j++) {
                matrix[sr][j] = k;
                k++;
            }

            // Right
            for (int i = sr + 1; i <= er; i++) {
                matrix[i][ec] = k;
                k++;
            }

            // Bottom
            if (sr <= er) {
                for (int j = ec - 1; j >= sc; j--) {
                    matrix[er][j] = k++;
                }
            }

            // Left
            if (sc <= ec) {
                for (int i = er - 1; i >= sr + 1; i--) {
                    matrix[i][sc] = k++;
                }
            }

            // Update boundaries
            sr++;
            sc++;
            er--;
            ec--;
        }

        return matrix;
    }

    public static void main(String[] args) {

        int n = 3;

        int[][] matrix = generateMatrix(n);

        // Print matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}