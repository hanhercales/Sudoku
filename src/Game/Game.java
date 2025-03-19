package Game;

import Check.Check;

import java.util.Random;

public class Game {
    private static final int SIZE = 9;
    private int[][] board;
    private Random rand;

    public Game() {
        board = new int[SIZE][SIZE];
        rand = new Random();
    }

    public void GenerateFullBoard() {
        fillDiagonal();
        solve(board);
    }

    public void RemoveNumbers(int level) {
        int removeCount = switch (level) {
            case 1 -> 40;
            case 2 -> 50;
            case 3 -> 55;
            case 4 -> 60;
            default -> 50;
        };

        while (removeCount > 0) {
            int i = rand.nextInt(9);
            int j = rand.nextInt(9);
            if (board[i][j] != 0) {
                int backup = board[i][j];
                board[i][j] = 0;

                if (!isUniqueSolution()) {
                    board[i][j] = backup;
                } else {
                    removeCount--;
                }
            }
        }
    }

    private void fillDiagonal() {
        for (int i = 0; i < SIZE; i += 3) {
            fillBlock(i, i);
        }
    }

    private void fillBlock(int row, int col) {
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

    private boolean solve(int[][] grid) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (Check.isValidMove(num, grid, row, col)) {
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

    private boolean isUniqueSolution() {
        int[][] tempBoard = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            System.arraycopy(board[i], 0, tempBoard[i], 0, SIZE);
        return solve(tempBoard);
    }

    public void OutputLevel() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(board[i][j] == 0 ? " * " : " " + board[i][j] + " ");
            System.out.println();
        }
    }

    public int[][] getBoard() {
        return board;
    }
}