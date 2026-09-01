public class SpiralMatrixIII {

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] result = new int[rows * cols][2];

        int count = 0;
        int r = rStart;
        int c = cStart;

        // Starting cell
        result[count][0] = r;
        result[count][1] = c;
        count++;

        int step = 1;

        while (count < rows * cols) {

            // Move East
            for (int i = 0; i < step; i++) {
                c++;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    result[count][0] = r;
                    result[count][1] = c;
                    count++;
                }
            }

            // Move South
            for (int i = 0; i < step; i++) {
                r++;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    result[count][0] = r;
                    result[count][1] = c;
                    count++;
                }
            }

            step++;

            // Move West
            for (int i = 0; i < step; i++) {
                c--;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    result[count][0] = r;
                    result[count][1] = c;
                    count++;
                }
            }

            // Move North
            for (int i = 0; i < step; i++) {
                r--;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    result[count][0] = r;
                    result[count][1] = c;
                    count++;
                }
            }

            step++;
        }

        return result;
    }

    public static void main(String[] args) {

        int rows = 5;
        int cols = 6;
        int rStart = 1;
        int cStart = 4;

        int[][] result = spiralMatrixIII(rows, cols, rStart, cStart);

        // Print result
        for (int i = 0; i < result.length; i++) {
            System.out.println(
                "[" + result[i][0] + ", " + result[i][1] + "]"
            );
        }
    }
}