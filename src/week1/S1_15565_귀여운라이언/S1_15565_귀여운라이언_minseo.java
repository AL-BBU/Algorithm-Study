package week1.S1_15565_귀여운라이언;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.02.01
 * @link https://www.acmicpc.net/problem/15565
 * @keyword_solution 라이언 인형이 K개 이상 있는 가장 작은 연속된 인형들의 집합의 크기 => 투포인터 + 슬라이딩 위도우
 * @input (1 ≤ K ≤ N ≤ 10^6) => for 문 2개를 써서 완탐을 할 경우 시간 초과 => O(N)으로 풀어야함
 * @output 비밀번호의 종류의 수를 출력 -> int형 가능
 * @time_complex O(N)
 * @perf 83908 424
 */

public class S1_15565_귀여운라이언_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, K;
	static List<Integer> lions;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		lions = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			;
			if (Integer.parseInt(st.nextToken()) == 1) { // 라이언만 뽑아서 인덱스를 List에 저장
				lions.add(i);
			}
		}

		if (lions.size() < K) { // List 크기가 K보다 작다면 볼 필요 없이 -1 return
			sb.append(-1);
			System.out.println(sb);
			return;
		}

//		K개 이상 있는 가장 작은 연속된 인형들의 집합의 크기 이므로 시작값과 끝값을 최소 K로 두고 그 구간만 슬라이딩 하며 계속 검사
		int start = 0;
		int end = K - 1;
		int min = Integer.MAX_VALUE;

		
//		투포인터
		while (end < lions.size()) { 
			min = Math.min(min, lions.get(end) - lions.get(start) + 1);

			start++;
			end++;

		}

		sb.append(min);

		System.out.println(sb);

	}

}