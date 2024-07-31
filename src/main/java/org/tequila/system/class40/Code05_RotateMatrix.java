package org.tequila.system.class40;

import org.junit.Test;

/**
 * @ClassName Code05_RotateMatrix
 * @Description TODO
 * @Author GT-R
 * @Date 2024/2/1310:29
 * @Version 1.0
 */
public class Code05_RotateMatrix {
    public void rotate(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a < c) {
            rotateEdge(matrix, a++, b++, c--, d--);
        }
    }

    public void rotateEdge(int[][] m, int a, int b, int c, int d) {
        int tmp = 0;
        for (int i = 0; i < d - b; i++) {
            tmp = m[a][b + i];
            m[a][b + i] = m[a + i][d];
            m[a + i][d] = m[c][d - i];
            m[c][d - i] = m[c - i][b];
            m[c - i][b] = tmp;
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
