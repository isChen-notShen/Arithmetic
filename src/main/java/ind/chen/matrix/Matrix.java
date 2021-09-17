package ind.chen.matrix;

public class Matrix {

    private final int[][] values;
    private int row = 0;
    private int col = 0;

    public Matrix(int row, int col) {
        values = new int[row][col];
        this.row = row;
        this.col = col;
    }

    public Matrix(int[][] values) {
        this.values = values;
        this.row = values.length;
        if (row > 0)
            this.col = values[0].length;
        else
            this.col = 0;
    }

    public Matrix(int row, int col, int initValue) {
        values = new int[row][col];
        this.row = row;
        this.col = col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                values[i][j] = initValue;
            }
        }
    }

    public Matrix(int[][] values, boolean isCopy) {
        if (isCopy) {
            int row = values.length;
            int col = row > 0 ? values[0].length : 0;
            this.values = new int[row][col];
            for (int i = 0; i < row; i++) {
                System.arraycopy(values[i], 0, this.values[i], 0, col);
            }
            return;
        }
        this.values = values;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue(int row, int col) {
        return values[row][col];
    }

    public void setValue(int row, int col, int value) {
        values[row][col] = value;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                buffer.append(values[i][j]).append(" ");
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
