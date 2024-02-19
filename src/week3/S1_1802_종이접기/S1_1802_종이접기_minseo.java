package week3.S1_1802_종이접기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.02.17
 * @link https://www.acmicpc.net/problem/1802
 * @keyword_solution  동호의 규칙이 2가지 있고 종이접기를 다시 동호의 규칙대로 접을 수 있는지 판별 하는 문제이다.
 * => 반으로 접으면서 계속해서 가능한지 확인(배열의 끝 값이 달라야함)
 * @input T는 1000보다 작거나 같은 자연수
 * @output YES or NO 출력 
 * @time_complex O(logN)
 * @perf 14040 128 30M 소요 => 문제를 잘 못 이해해서 자꾸틀림..
 */

public class S1_1802_종이접기_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, mid;
	static String str;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();

			int start = 0;
			int end = str.length() - 1;
			if (flag(start, end)) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}

		System.out.println(sb.toString().trim());

	}

	static boolean flag(int start, int end) {
		if(start == end) return true;
		
		
		mid = (start + end) / 2;
		
		for(int i = start; i < mid; i++) {
			if(str.charAt(i) == str.charAt(end - i)) {
				return false;
			}
		}
		
		return flag(start, mid - 1);
		
	}

}
