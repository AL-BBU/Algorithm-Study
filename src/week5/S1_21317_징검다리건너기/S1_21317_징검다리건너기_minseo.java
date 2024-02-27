package week5.S1_21317_징검다리건너기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_21317_징검다리건너기_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, K;
	static int[][] arr, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[2][Math.max(4,N)];
		dp = new int[2][Math.max(4,N + 1)];

		for (int i = 1; i <= N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
		}

		K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], 10000);
		}
		
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 0;
		dp[0][2] = arr[0][1];
		dp[0][3] = Math.min(dp[0][2] + arr[0][2], dp[0][0] + arr[1][1]);
		for (int i = 4; i <= N; i++) {

			dp[0][i] = Math.min(dp[0][i - 1] + arr[0][i-1], dp[0][i - 2] + arr[1][i - 2]);
			dp[1][i] = Math.min(Math.min(dp[1][i - 1] + arr[0][i-1], dp[1][i - 2] + arr[1][i-2]), dp[0][i - 3] + K);

		}

//		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j <= N; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		int result = Math.min(dp[1][N], dp[0][N]);
		System.out.println(result);

	}

}
