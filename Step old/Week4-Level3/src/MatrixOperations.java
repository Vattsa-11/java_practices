public class MatrixOperations {

    public static int[][] createMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = (int) (Math.random() * 10);
        return matrix;
    }

    public static int[][] add(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    public static int[][] subtract(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B[0].length; j++)
                for (int k = 0; k < A[0].length; k++)
                    result[i][j] += A[i][k] * B[k][j];
        return result;
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                transposed[j][i] = matrix[i][j];
        return transposed;
    }

    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static double[][] inverse2x2(int[][] matrix) {
        int det = determinant2x2(matrix);
        if (det == 0) return null;

        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / (double) det;
        inverse[0][1] = -matrix[0][1] / (double) det;
        inverse[1][0] = -matrix[1][0] / (double) det;
        inverse[1][1] = matrix[0][0] / (double) det;
        return inverse;
    }

    public static void display(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void display(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) System.out.printf("%.2f ", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = createMatrix(2, 2);
        int[][] B = createMatrix(2, 2);

        System.out.println("Matrix A:");
        display(A);
        System.out.println("Matrix B:");
        display(B);

        System.out.println("A + B:");
        display(add(A, B));

        System.out.println("A - B:");
        display(subtract(A, B));

        System.out.println("A * B:");
        display(multiply(A, B));

        System.out.println("Transpose of A:");
        display(transpose(A));

        System.out.println("Determinant of A: " + determinant2x2(A));

        System.out.println("Inverse of A:");
        double[][] inverse = inverse2x2(A);
        if (inverse != null)
            display(inverse);
        else
            System.out.println("Matrix A is not invertible.");
    }
}
