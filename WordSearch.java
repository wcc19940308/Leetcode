package LeetCode100;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = backTrack(board, word, i, j, m, n, 0, visited);
                if (res == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backTrack(char[][] board, String word, int x, int y, int m, int n, int index, boolean[][] visited) {
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        visited[x][y] = true;
        if (backTrack(board, word, x + 1, y, m, n, index+1, visited)
                || backTrack(board, word, x - 1, y, m, n, index+1, visited)
                || backTrack(board, word, x, y + 1, m, n, index+1, visited)
                || backTrack(board, word, x, y - 1, m, n, index+1, visited)) {
            return true;
        }
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'a', 'a'}};
        String s = "aa";
        boolean res = exist(arr, s);
        System.out.println(res);
    }
}
