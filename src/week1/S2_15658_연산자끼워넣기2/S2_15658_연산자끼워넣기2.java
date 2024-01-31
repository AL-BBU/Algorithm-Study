package week1.S2_15658_연산자끼워넣기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 강민서	
 * @date 2024.01.31
 * @link https://www.acmicpc.net/problem/15658의 순서를 바꾸지 말고 주어진 연산자로 수식 만들
 * @keyword_solution  조건 1. 우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. => 재귀를 통해서 모든 경우의 수 탐색
조건 2. 연산자 우선 순위를 무시하고 앞에서부터 진행 , 
조건 3. 음수를 양수로 나눌 때는양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다. => 자바에서도 자동으로 이렇게 해줌 무시
 => 가능한 모든 수식을 만들어서 최대 최소 비교하고 출력
 * @input N(2 ≤ N ≤ 11), 연산자 수 합이 N-1보다 크거나 같고, 4N보다 작거나 같은 4개의 정수 => 완탐 가능
 * @output 연산 최대 최소 출력 => 최소 최대가 10억, -10억으로 int가능
 * @time_complex  O(4^n)
 * @perf 16812	144
 */

public class S2_15658_연산자끼워넣기2 {

	static final int plus = 0, minus = 1, mul = 2, div = 3; // 스위치 문에는 상수만 들어갈 수 있어서 final
	static int n, max, min;
	static int[] num, operators;
	static boolean[] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[n];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		operators = new int[4];

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken()); // 배열의 인덱스에 입력 값 저장 ex) operators[0] = 2 => 0의 입력이 2개 들어왔다.
		}
		

		dfs(1, num[0]); // num의 다음 값을 넣어야 하기 때문에 depth의 초기 값 1
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}

//	재귀를 돌면서 모든 경우의 수 탐색
	static void dfs(int depth, int result) {
//		최대 최소 갱신
		if (depth == n) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		
		for (int i = 0; i < 4; i++) {
			if(operators[i] == 0) continue; //원래 순열의 visited와 비슷함 -> 중복체크
			operators[i]--;  
			 switch (i){
             case plus:
                 dfs(depth + 1, result + num[depth]);
                 break;
             case minus:
                 dfs(depth + 1, result - num[depth]);
                 break;
             case mul:
                 dfs(depth + 1, result * num[depth]);
                 break;
             case div:
                 dfs(depth + 1, result / num[depth]);
                 break;
         }
			 operators[i]++; //원래 순열의 visited와 비슷함 -> 중복체크
		}
	}


}