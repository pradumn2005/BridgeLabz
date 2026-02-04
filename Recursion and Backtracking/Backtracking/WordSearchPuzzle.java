public class WordSearchPuzzle {
    public static boolean solve(char[][] board, String word, int r, int c, int index, boolean[][] visited) {
        if (index == word.length()) return true;

        if (r < 0 || c < 0 || r >= 4 || c >= 4 || visited[r][c] || board[r][c] != word.charAt(index)) {
            return false;
        }

        visited[r][c] = true;
        int[] rowDir = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] colDir = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int i = 0; i < 8; i++) {
            if (solve(board, word, r + rowDir[i], c + colDir[i], index + 1, visited)) {
                return true;
            }
        }

        visited[r][c] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'C', 'A', 'T', 'S'},
            {'O', 'R', 'E', 'A'},
            {'D', 'E', 'A', 'M'},
            {'E', 'L', 'L', 'S'}
        };
        String target = "DREAM";
        boolean[][] visited = new boolean[4][4];
        
        boolean found = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (solve(grid, target, i, j, 0, visited)) {
                    found = true;
                    break;
                }
            }
        }
        System.out.println("Word found: " + found);
    }
}
