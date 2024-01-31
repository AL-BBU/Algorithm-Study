import java.util.Scanner;

public class Main {
    static int rst = 0;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[][] board = new int[n][n];
        backtracking(0, board);
        System.out.println(rst);
    }

    static void backtracking(int cnt, int[][] board) {
        if (cnt == n) {
            rst++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(board, cnt, i)) {
                board[cnt][i] = 1;
                backtracking(cnt + 1, board);
                board[cnt][i] = 0;
            }
        }
    }

    static boolean isValid(int[][] board, int r, int c) {
        for (int i = 0; i < r; i++) { // 열 탐색
            if (board[i][c] == 1) {
                return false;
            }
        }
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) { // 행 탐색
                return false;
            }
        }
        for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) { // 대각선 방향 탐색
                return false;
            }
        }
        return true;
    }
}