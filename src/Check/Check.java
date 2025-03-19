package Check;

public class Check {
    public static boolean isValidMove(int x, int[][] board, int row, int col) {
        return CheckRows(x, board, row) && CheckCols(x, board, col) && CheckZone(x, board, row, col);
    }

    public static boolean CheckRows(int x, int[][] board, int row) {
        for (int j = 0; j < 9; ++j)
            if (x == board[row][j] && board[row][j] != 0)
                return false;
        return true;
    }

    public static boolean CheckCols(int x, int[][] board, int col) {
        for (int i = 0; i < 9; ++i)
            if (x == board[i][col] && board[i][col] != 0)
                return false;
        return true;
    }

    public static boolean CheckZone(int x, int[][] board, int row, int col) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == x)
                    return false;
            }
        }
        return true;
    }
}