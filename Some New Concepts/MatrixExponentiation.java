class MyFibonacci {
    public static int[][] matrixMultiplication(int A[][], int B[][]) {
        return new int[][] {
            {(A[0][0] * B[0][0] + A[0][1] * B[1][0]), (A[0][0] * B[0][1] + A[0][1] * B[1][1])},
            {(A[1][0] * B[0][0] + A[1][1] * B[1][0]), (A[1][0] * B[0][1] + A[1][1] * B[1][1])}
        };
    }

    public static int[][] matrixExponentiation(int matrix[][], int power) {
        int result[][] = {{1, 0}, {0, 1}};
        int base[][] = matrix;

        while(power > 0) {
            if((power & 1) != 0) {
                result = matrixMultiplication(result, base);
            }

            base = matrixMultiplication(base, base);

            power >>= 1;
        }

        return result;
    }

    public int getFibonacciOfN(int n) {
        int matrix[][] = {{1, 1}, {1, 0}};
        int result[][] = matrixExponentiation(matrix, n);
        return result[0][1];
    }
}

class Fibonacci {
    //multiply two matrix
    public static int[][] matrixMultiplication(int a[][], int b[][]) {
        int n = a.length;
        int ans[][] = new int[n][n];

        for(int i=0; i<n; ++i) {
            for(int j=0; j<n; ++j) {
                for(int k=0; k<n; ++k) {
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return ans;
    }

    //matrix exponentiation using fast/modular exponentiation
    public static int[][] matrixExponentiation(int matrix[][], int n) {
        int res[][] = {{1, 0}, {0, 1}};
        int x[][] = matrix;

        while(n > 0) {
            if(n % 2 != 0) {
                res = matrixMultiplication(res, x);
            }

            x = matrixMultiplication(x, x);

            n /= 2;
        }

        return res;
    }

    public int getFibonacciOfN(int n) {
        int matrix[][] = {{1, 1}, {1, 0}};
        int res[][] = matrixExponentiation(matrix, n);
        return res[0][1];
    }
}

//Matrix Exponentiation - Time Complexity = (log(n)), Space Complexity = O(1)
public class MatrixExponentiation {
    public static void main(String[] args) {
        Fibonacci obj1 = new Fibonacci();
        System.out.println(obj1.getFibonacciOfN(5));
        
        MyFibonacci obj2 = new MyFibonacci();
        System.out.println(obj2.getFibonacciOfN(5));
    }
}