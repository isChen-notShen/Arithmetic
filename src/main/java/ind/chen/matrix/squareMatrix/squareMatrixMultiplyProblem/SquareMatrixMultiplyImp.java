package ind.chen.matrix.squareMatrix.squareMatrixMultiplyProblem;

import ind.chen.matrix.squareMatrix.SquareMatrix;

/**
 * 实现方阵的乘法,分治法目前只能运算2的n次幂的方阵
 *
 * @author ChenSL
 */
public abstract class SquareMatrixMultiplyImp {

    public static void main(String[] args) {
        int[][] ax = {{1, 2, 3, 4}, {3, 4, 6, 7}, {3, 7, 6, 7}, {3, 2, 4, 8}};
        int[][] bx = {{2, 1, 4, 3}, {6, 8, 2, 3}, {3, 4, 6, 7}, {1, 4, 8, 3}};
        SquareMatrix a = new SquareMatrix(ax);
        SquareMatrix b = new SquareMatrix(bx);
        System.out.println(a);
        System.out.println(b);
        System.out.println(ordinarySquareMatrixMultiply(a, b));
        System.out.println(dCSquareMatrixMultiply(a, b));
//        System.out.println(strassenSquareMatrixMultiply(a, b));
    }

    public static SquareMatrix ordinarySquareMatrixMultiply(SquareMatrix a, SquareMatrix b) {
        SquareMatrix result = new SquareMatrix(a.getCol());
        for (int i = 0; i < a.getCol(); i++) {
            for (int j = 0; j < a.getCol(); j++) {
                result.setValue(i, j, 0);
                for (int k = 0; k < a.getCol(); k++) {
                    result.setValue(i, j, result.getValue(i, j) + a.getValue(i, k) * b.getValue(k, j));
                }
            }
        }
        return result;
    }

    public static SquareMatrix strassenSquareMatrixMultiply(SquareMatrix a, SquareMatrix b) {
        if (a.getRow() != b.getRow() || !isValid(a.getRow()))
            throw new RuntimeException("Now can only be applied to n*n and n has to be 2'pow");

        SquareMatrix c = new SquareMatrix(a.getRow());
        IndexSubMatrix indexSubMatrixOfA = new IndexSubMatrix(a, 0, a.getRow() - 1, 0, a.getCol() - 1);
        IndexSubMatrix indexSubMatrixOfB = new IndexSubMatrix(b, 0, b.getRow() - 1, 0, b.getCol() - 1);
        return strassenSquareMatrixMultiply(indexSubMatrixOfA, indexSubMatrixOfB, c).matrix;
    }

    //这个方法有错误,问题在于squareMatrixReduce和squareMatrixAddition的计算结果存放位置不对。
    public static IndexSubMatrix strassenSquareMatrixMultiply(IndexSubMatrix a, IndexSubMatrix b, SquareMatrix c) {
        if (a.isOnlyOne() && b.isOnlyOne()) {
            IndexSubMatrix result = new IndexSubMatrix(c, a.startRow, a.endRow, b.startCol, b.endCol);
            result.matrix.setValue(a.startRow, b.startCol, c.getValue(a.startRow, b.startCol) + a.matrix.getValue(a.startRow, a.startCol) * b.matrix.getValue(b.startRow, b.startCol));
            return result;
        }

        IndexSubMatrix a11 = divideIndexSquareMatrix(a, false, true, false, true);
        IndexSubMatrix a12 = divideIndexSquareMatrix(a, false, true, true, false);
        IndexSubMatrix a21 = divideIndexSquareMatrix(a, true, false, false, true);
        IndexSubMatrix a22 = divideIndexSquareMatrix(a, true, false, true, false);
        IndexSubMatrix b11 = divideIndexSquareMatrix(b, false, true, false, true);
        IndexSubMatrix b12 = divideIndexSquareMatrix(b, false, true, true, false);
        IndexSubMatrix b21 = divideIndexSquareMatrix(b, true, false, false, true);
        IndexSubMatrix b22 = divideIndexSquareMatrix(b, true, false, true, false);
        IndexSubMatrix s1 = squareMatrixReduce(b12, b22, c);
        IndexSubMatrix s2 = squareMatrixAddition(a11, a12, c);
        IndexSubMatrix s3 = squareMatrixAddition(a21, a22, c);
        IndexSubMatrix s4 = squareMatrixReduce(b21, b11, c);
        IndexSubMatrix s5 = squareMatrixAddition(a11, a22, c);
        IndexSubMatrix s6 = squareMatrixAddition(b11, b22, c);
        IndexSubMatrix s7 = squareMatrixReduce(a12, a22, c);
        IndexSubMatrix s8 = squareMatrixAddition(b21, b22, c);
        IndexSubMatrix s9 = squareMatrixReduce(a11, a21, c);
        IndexSubMatrix s10 = squareMatrixAddition(b11, b12, c);
        IndexSubMatrix p1 = strassenSquareMatrixMultiply(a11, s1, c);
        IndexSubMatrix p2 = strassenSquareMatrixMultiply(s2, b22, c);
        IndexSubMatrix p3 = strassenSquareMatrixMultiply(s3, b11, c);
        IndexSubMatrix p4 = strassenSquareMatrixMultiply(a22, s4, c);
        IndexSubMatrix p5 = strassenSquareMatrixMultiply(s5, s6, c);
        IndexSubMatrix p6 = strassenSquareMatrixMultiply(s7, s8, c);
        IndexSubMatrix p7 = strassenSquareMatrixMultiply(s9, s10, c);
        squareMatrixAddition(squareMatrixReduce(squareMatrixAddition(p5, p4, c), p2, c), p6, c);
        squareMatrixAddition(p1, p2, c);
        squareMatrixAddition(p3, p4, c);
        squareMatrixReduce(squareMatrixReduce(squareMatrixAddition(p5, p1, c), p3, c), p7, c);
        return new IndexSubMatrix(c, a11.startRow, a22.endRow, b11.startCol, b22.endCol);
    }

    public static SquareMatrix dCSquareMatrixMultiply(SquareMatrix a, SquareMatrix b) {
        if (a.getRow() != b.getRow() || !isValid(a.getRow()))
            throw new RuntimeException("Now can only be applied to n*n and n has to be 2'pow");

        SquareMatrix c = new SquareMatrix(a.getRow());
        IndexSubMatrix indexSubMatrixOfA = new IndexSubMatrix(a, 0, a.getRow() - 1, 0, a.getCol() - 1);
        IndexSubMatrix indexSubMatrixOfB = new IndexSubMatrix(b, 0, b.getRow() - 1, 0, b.getCol() - 1);
        return auxiliaryDCSquareMatrixMultiply(indexSubMatrixOfA, indexSubMatrixOfB, c).matrix;
    }

    private static IndexSubMatrix auxiliaryDCSquareMatrixMultiply(IndexSubMatrix a, IndexSubMatrix b, SquareMatrix c) {
        if (a.isOnlyOne() && b.isOnlyOne()) {
            IndexSubMatrix result = new IndexSubMatrix(c, a.startRow, a.endRow, b.startCol, b.endCol);
            result.matrix.setValue(a.startRow, b.startCol, c.getValue(a.startRow, b.startCol) + a.matrix.getValue(a.startRow, a.startCol) * b.matrix.getValue(b.startRow, b.startCol));
            return result;
        }

        IndexSubMatrix a11 = divideIndexSquareMatrix(a, false, true, false, true);
        IndexSubMatrix a12 = divideIndexSquareMatrix(a, false, true, true, false);
        IndexSubMatrix a21 = divideIndexSquareMatrix(a, true, false, false, true);
        IndexSubMatrix a22 = divideIndexSquareMatrix(a, true, false, true, false);
        IndexSubMatrix b11 = divideIndexSquareMatrix(b, false, true, false, true);
        IndexSubMatrix b12 = divideIndexSquareMatrix(b, false, true, true, false);
        IndexSubMatrix b21 = divideIndexSquareMatrix(b, true, false, false, true);
        IndexSubMatrix b22 = divideIndexSquareMatrix(b, true, false, true, false);
        auxiliaryDCSquareMatrixMultiply(a11, b11, c);
        auxiliaryDCSquareMatrixMultiply(a12, b21, c);
        auxiliaryDCSquareMatrixMultiply(a11, b12, c);
        auxiliaryDCSquareMatrixMultiply(a12, b22, c);
        auxiliaryDCSquareMatrixMultiply(a21, b11, c);
        auxiliaryDCSquareMatrixMultiply(a22, b21, c);
        auxiliaryDCSquareMatrixMultiply(a21, b12, c);
        auxiliaryDCSquareMatrixMultiply(a22, b22, c);
        return new IndexSubMatrix(c, a11.startRow, a22.endRow, b11.startCol, b22.endCol);
    }

    private static IndexSubMatrix squareMatrixAddition(IndexSubMatrix a, IndexSubMatrix b, SquareMatrix c) {
        for (int i = a.startRow; i < a.row; i++) {
            for (int j = a.startCol; j < a.col; j++) {
                c.setValue(i, j, c.getValue(i, j) + a.matrix.getValue(i, j) + b.matrix.getValue(i, j));
            }
        }
        return new IndexSubMatrix(c, a.startRow, a.endRow, a.startCol, a.endCol);
    }

    private static IndexSubMatrix squareMatrixReduce(IndexSubMatrix a, IndexSubMatrix b, SquareMatrix c) {
        for (int i = a.startRow; i < a.row; i++) {
            for (int j = a.startCol; j < a.col; j++) {
                c.setValue(i, j, c.getValue(i, j) + a.matrix.getValue(i, j) - b.matrix.getValue(i, j));
            }
        }
        return new IndexSubMatrix(c, a.startRow, a.endRow, a.startCol, a.endCol);
    }

    private static IndexSubMatrix divideIndexSquareMatrix(IndexSubMatrix source, boolean startRow, boolean endRow, boolean startCol, boolean endCol) {
        IndexSubMatrix subMatrix = new IndexSubMatrix(source.matrix, source.startRow, source.endRow, source.startCol, source.endCol);
        if (startRow)
            subMatrix.setStartRow(source.startRow + source.row / 2);
        if (endRow)
            subMatrix.setEndRow(source.endRow - source.row / 2);
        if (startCol)
            subMatrix.setStartCol(source.startCol + source.col / 2);
        if (endCol)
            subMatrix.setEndCol(source.endCol - source.col / 2);
        return subMatrix;
    }

    private static boolean isValid(int n) {
        return n != 0 && ((n - 1) & n) == 0;
    }

    private static class IndexSubMatrix {
        SquareMatrix matrix;
        int startRow;
        int endRow;
        int row;
        int startCol;
        int endCol;
        int col;

        public IndexSubMatrix(SquareMatrix matrix, int startRow, int endRow, int startCol, int endCol) {
            this.matrix = matrix;
            this.startRow = startRow;
            this.endRow = endRow;
            this.row = endRow - startRow + 1;
            this.startCol = startCol;
            this.endCol = endCol;
            this.col = endCol - startCol + 1;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
            this.row = endRow - startRow + 1;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
            this.row = endRow - startRow + 1;
        }

        public void setStartCol(int startCol) {
            this.startCol = startCol;
            this.col = endCol - startCol + 1;
        }

        public void setEndCol(int endCol) {
            this.endCol = endCol;
            this.col = endCol - startCol + 1;
        }

        public boolean isOnlyOne() {
            return row == 1 && col == 1;
        }
    }
}