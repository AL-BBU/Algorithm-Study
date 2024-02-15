package week3.S3_20300_서강근육맨;

/**
 * @author 강민서
 * @date 2024.02.15
 * @link https://www.acmicpc.net/problem/20300
 * @keyword_solution  PT를 받을 때 운동기구를 되도록이면 두 개 => 짝수면 2개씩 홀수면 나머지는 1개 
 *  운동기구마다 근손실이 일어나는 정도가 다르기 때문이다. => 근손실 값은 모두 다르게 주어짐 
 *  근손실의 최솟값 구하기
 *  => 운동기구 N이 짝수일 때와 홀수일 때 나눠서 정렬 후 짝수일 때는 작은 것과 큰 것을 더하면서 근손실을 구하고, 홀수 일 때는 가장 큰 값을 MAX값으로 설정하고 구했다.
 * @input (1 < N < 10000), (0 <= t < 10^18) => t가 10^18이므로 long로 풀기 
 * @output 근손실 최솟값 출력 
 * @time_complex O(logN)
 * @perf 18916	240  15m
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_20300_서강근육맨_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long answer, temp;
	static int N;
	static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);
		

//		짝수
		if (N % 2 == 0) {
			for (int i = 0; i < N / 2; i++) {
				temp = arr[i] + arr[N - i - 1];
				answer = Math.max(answer, temp); 
			}
		
		} 
//		홀수
		else {
			answer = arr[N - 1];
			for (int i = 0; i < N / 2; i++) {
				temp = arr[i] + arr[N - i - 2];
				answer = Math.max(answer, temp);
			}

		}

		System.out.println(answer);

	}

}
