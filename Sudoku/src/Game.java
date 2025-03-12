import java.util.Random;

public class Game {
    private static final int SIZE = 9;
    private static final int[][] board = new int[SIZE][SIZE];
    private static final Random rand = new Random();

    public static void GenerateFullBoard() {
        fillDiagonal(); // Điền các vùng 3x3 chéo trước để tạo cơ sở
        solve(board); // Dùng thuật toán backtracking để tạo bảng hoàn chỉnh
    }

    public static void RemoveNumbers(int level) {
        int removeCount = switch (level) {
            case 1 -> 40; // Dễ
            case 2 -> 50; // Trung bình
            case 3 -> 55; // Khó
            case 4 -> 60; // Siêu khó
            default -> 50;
        };

        while (removeCount > 0) {
            int i = rand.nextInt(9);
            int j = rand.nextInt(9);
            if (board[i][j] != 0) {
                int backup = board[i][j];
                board[i][j] = 0;

                if (!isUniqueSolution()) {
                    board[i][j] = backup; // Nếu xóa số này làm Sudoku có nhiều lời giải, khôi phục lại
                } else {
                    removeCount--;
                }
            }
        }
    }

    private static void fillDiagonal() {
        for (int i = 0; i < SIZE; i += 3) {
            fillBlock(i, i);
        }
    }

    private static void fillBlock(int row, int col) {
        boolean[] used = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num;
                do {
                    num = rand.nextInt(9) + 1;
                } while (used[num]);
                used[num] = true;
                board[row + i][col + j] = num;
            }
        }
    }

    private static boolean solve(int[][] grid) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (Check.CheckRows(num, grid, row) &&
                            Check.CheckCols(num, grid, col) &&
                            Check.CheckZone(num, grid, row, col)) {
                            grid[row][col] = num;
                            if (solve(grid)) return true;
                            grid[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isUniqueSolution() {
        int[][] tempBoard = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            System.arraycopy(board[i], 0, tempBoard[i], 0, SIZE);

        return solve(tempBoard);
    }

    public static void OutputLevel() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(board[i][j] == 0 ? " * " : " " + board[i][j] + " ");
            System.out.println();
        }
    }

    public static int[][] getBoard(){
        return board;
    }
}
