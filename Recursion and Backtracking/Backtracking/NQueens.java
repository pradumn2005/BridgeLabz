public class NQueens {
    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }

    public static boolean solveNQueens(int[][] board, int row, int n) {
        if (row >= n) {
            printBoard(board);
            return true;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                if (solveNQueens(board, row + 1, n)) return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        if (!solveNQueens(board, 0, n)) {
            System.out.println("No solution found");
        }
    }
}
