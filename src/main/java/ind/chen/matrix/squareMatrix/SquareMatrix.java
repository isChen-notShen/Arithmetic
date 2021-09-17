package ind.chen.matrix.squareMatrix;

import ind.chen.matrix.Matrix;

public class SquareMatrix extends Matrix {

    public SquareMatrix(int n) {
        super(n, n);
    }

    public SquareMatrix(int[][] values) {
        this(values.length);
        if (values.length != values[0].length) {
            throw new ExceptionInInitializerError("The parameter should be a n * n array");
        }
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                setValue(i, j, values[i][j]);
            }
        }
    }

    public SquareMatrix(int n, int initValue) {
        super(n, n, initValue);
    }
}
