package week1.S2_6603_로또;

/**
 * @author 강민서
 * @date 2024.01.31
 * @link https://www.acmicpc.net/problem/6603
 * @keyword_solution  , k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지 => 조합
 * @input 집합의 수 (6 < k < 13) 에서 6개를 뽑는 것 
 * @output 수를 고르는 모든 방법을 사전순으로 출력 => StringBuilder 사용
 * @time_complex  15008	152
 * @perf 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_6603_로또_minseo {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int k;
	static int[] arr, lotto;

	public static void main(String[] args) throws IOException {
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) {
				
				break;
			}
			arr = new int[k];
			lotto = new int[6];
			
			for(int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0, 0);
			sb.append("\n");
			
		}
		System.out.println(sb);

	}
	
//	조합 구현
	static void comb(int depth, int start) {
		if(depth == 6) {
			for(int num : lotto) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			lotto[depth] = arr[i];
			comb(depth + 1, i + 1); // depth + 1 : lotto배열 증가, i + 1 : 선택된 인덱스 다시 선택 못하게 중복방지
		}
	}
	
	

}