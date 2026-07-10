class DiagonalSum {
    public static int diagnolSum(int[][] matrix){
        int sum = 0;
        // //BruteForce
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         if ( i == j){
        //             sum += matrix[i][j];
        //         }
        //         else if( (i+j) == (matrix.length -1)){
        //             sum += matrix[i][j];
        //         }
        //     }
        // }

        // Optimal Solution
        for (int i = 0; i < matrix.length; i++) {
            //pd
            sum += matrix[i][i];
            // sd
            if ( i != (matrix.length-i-1)){
                sum += matrix[i][matrix.length-i-1];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int [][] arr = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int sum_of_diagnal = diagnolSum(arr);
        System.out.println(sum_of_diagnal); 
    }
}