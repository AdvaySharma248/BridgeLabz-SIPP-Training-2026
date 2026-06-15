public class MatrixAdvancedOperations {

    public static int[][] createRandomMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) (Math.random() * 10) + 1;
            }
        }
        return matrix;
    }

    public static int[][] findTranspose(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] transpose = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    public static double findDeterminant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static double findDeterminant3x3(int[][] matrix) {
        double determinant = matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        return determinant;
    }

    public static double[][] findInverse2x2(int[][] matrix) {
        double determinant = findDeterminant2x2(matrix);
        if (determinant == 0) {
            return null;
        }
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / determinant;
        inverse[0][1] = -matrix[0][1] / determinant;
        inverse[1][0] = -matrix[1][0] / determinant;
        inverse[1][1] = matrix[0][0] / determinant;
        return inverse;
    }

    public static double[][] findInverse3x3(int[][] matrix) {
        double determinant = findDeterminant3x3(matrix);
        if (determinant == 0) {
            return null;
        }

        double[][] cofactors = new double[3][3];
        cofactors[0][0] = (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]);
        cofactors[0][1] = -(matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]);
        cofactors[0][2] = (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        cofactors[1][0] = -(matrix[0][1] * matrix[2][2] - matrix[0][2] * matrix[2][1]);
        cofactors[1][1] = (matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0]);
        cofactors[1][2] = -(matrix[0][0] * matrix[2][1] - matrix[0][1] * matrix[2][0]);
        cofactors[2][0] = (matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1]);
        cofactors[2][1] = -(matrix[0][0] * matrix[1][2] - matrix[0][2] * matrix[1][0]);
        cofactors[2][2] = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);

        double[][] inverse = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverse[i][j] = cofactors[j][i] / determinant;
            }
        }
        return inverse;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void displayDoubleMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(String.format("%.4f", matrix[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix2x2 = createRandomMatrix(2, 2);
        System.out.println("2x2 Matrix:");
        displayMatrix(matrix2x2);

        double det2x2 = findDeterminant2x2(matrix2x2);
        System.out.println("Determinant (2x2): " + det2x2);

        double[][] inverse2x2 = findInverse2x2(matrix2x2);
        if (inverse2x2 != null) {
            System.out.println("Inverse (2x2):");
            displayDoubleMatrix(inverse2x2);
        } else {
            System.out.println("Inverse does not exist (Determinant is 0)");
        }

        System.out.println();

        int[][] matrix3x3 = createRandomMatrix(3, 3);
        System.out.println("3x3 Matrix:");
        displayMatrix(matrix3x3);

        int[][] transpose = findTranspose(matrix3x3);
        System.out.println("\nTranspose (3x3):");
        displayMatrix(transpose);

        double det3x3 = findDeterminant3x3(matrix3x3);
        System.out.println("Determinant (3x3): " + det3x3);

        double[][] inverse3x3 = findInverse3x3(matrix3x3);
        if (inverse3x3 != null) {
            System.out.println("Inverse (3x3):");
            displayDoubleMatrix(inverse3x3);
        } else {
            System.out.println("Inverse does not exist (Determinant is 0)");
        }
    }
}
