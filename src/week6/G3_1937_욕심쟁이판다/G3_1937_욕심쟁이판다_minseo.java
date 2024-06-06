package week6.G3_1937_욕심쟁이판다;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_1937_욕심쟁이판다_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, result;
	static int[][] arr, dp;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n][n];
		arr = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		dfs로만 돌리면 500 ^ 4로 시간초과 => dp를 이용해서 연산 저장
		// 모든 지점에서 DFS 수행하여 판다가 이동할 수 있는 최대 칸 수 계산
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result = Math.max(dfs(new Point(i, j)), result);
			}
		}
		
		System.out.println(result);

	}

	static int dfs(Point p) {
		
//		방문체크 이미 dp에 값이 저장 되어 있다면
		if(dp[p.x][p.y] != 0) {
			return dp[p.x][p.y];
		}
		
//		초기값 기본적으로 1
		dp[p.x][p.y] = 1;

		for (int i = 0; i < 4; i++) {
			int ax = p.x + dx[i];
			int ay = p.y + dy[i];

			if (!check(ax, ay))
				continue;

			if (arr[p.x][p.y] < arr[ax][ay]) {
				dp[p.x][p.y] = Math.max(dp[p.x][p.y], dfs(new Point(ax, ay)) + 1);
			}

		}
		
		return dp[p.x][p.y];
	}

	static boolean check(int ax, int ay) {
		return ax >= 0 && ax < n && ay >= 0 && ay < n;
	}
}
