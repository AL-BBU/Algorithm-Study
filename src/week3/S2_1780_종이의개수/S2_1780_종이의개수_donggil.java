package week3.S2_1780_종이의개수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_1780_종이의개수_donggil {
	static int n, m, k;
	static int[][] arr;
	static int total;
	static StringTokenizer st;
	static StringBuilder sb;
	static int max, min;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] timer;
	static int zero, plus, minus;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		zero = plus = minus = 0;
		dfs(0, 0, n);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
		br.close();
		bw.close();
	}

	static void dfs(int x, int y, int size) {
		if (check(x, y, size)) {
			if (arr[x][y] == -1) {
				minus++;
			} else if (arr[x][y] == 0) {
				zero++;
			} else if (arr[x][y] == 1) {
				plus++;
			}
			return;
		}

		int nextSize = size / 3;
		for (int i = x; i < x + size; i += nextSize) {
			for (int j = y; j < y + size; j += nextSize) {
				dfs(i, j, nextSize);
			}
		}
	}

	static boolean check(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] != arr[x][y])
					return false;
			}
		}
		return true;
	}
}