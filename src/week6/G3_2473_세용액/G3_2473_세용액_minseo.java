package week6.G3_2473_세용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_2473_세용액_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n;
	static long[] arr;
	static long save;
	static long[] result;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		result = new long[3];
		save = Long.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

//		for문으로 target 마다 세용액 찾기
		for (int i = 0; i < n - 2; i++) {
			find(i);
		}

		Arrays.sort(result);

		for (int i = 0; i < 3; i++) {
			sb.append(result[i] + " ");
		}

		System.out.println(sb);

	}

//	투포인터
	static void find(int target) {
		int start = target + 1;
		int end = n - 1;

		while (start < end) {
			long sum = arr[target] + arr[start] + arr[end];

//			save보다 작으면 save를 갱신하고 result 배열에 해당 용액 저장
			if (save > Math.abs(sum)) {
				save = Math.abs(sum);
				result[0] = arr[target];
				result[1] = arr[start];
				result[2] = arr[end];

			}

			if (sum > 0) {
				end--;
			} else {
				start++;
			}

		}
	}

}
