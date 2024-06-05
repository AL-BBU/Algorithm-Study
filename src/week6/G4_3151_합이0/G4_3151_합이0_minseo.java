package week6.G4_3151_합이0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_3151_합이0_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n;
	static long result;
	static long[] arr;

	public static void main(String[] args) throws IOException {

		n = Integer.parseInt(br.readLine());
		arr = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; i < n - 2; i++) {
			find(i);
		}

		System.out.println(result);

	}

	static void find(int target) {
		int start = target + 1;
		int end = n - 1;

		while (start < end) {
			long sum = arr[target] + arr[start] + arr[end];
			if (sum == 0) {
				// 같은 값이 여러 개 있을 때 경우의 수를 세기 위한 처리
				if (arr[start] == arr[end]) {
					int cnt = end - start + 1; // 동일한 값 개수
					result += (cnt * (cnt - 1)) / 2; // nC2 EX) 4C2 = (4 * 3) / 2 = 6
					break;

					// start, end 위치에서 각각 같은 값이 여러 개 있을 때 startCnt, endCnt로 개수 세기
				} else {
					int startCnt = 1;
					int endCnt = 1;
					while (start + 1 < end && arr[start] == arr[start + 1]) {
						startCnt++;
						start++;
					}
					while (end - 1 > start && arr[end] == arr[end - 1]) {
						endCnt++;
						end--;
					}
					result += startCnt * endCnt;
					start++;
					end--;
				}
			} else if (sum > 0) {
				end--;
			} else {
				start++;
			}
		}
	}
}