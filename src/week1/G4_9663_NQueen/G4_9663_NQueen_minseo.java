package week1.G4_9663_NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 강민서
 * @date 2024.01.31
 * @link https://www.acmicpc.net/problem/9663
 * @keyword_solution  N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제 => 퀸은 같은 행, 열, 대각선 공격 가능
 * @input (1 ≤ N < 15) -> 완탐 가능
 * @output  -> 경우의 수 출력
 * @time_complex  
 * @perf 
 */

public class G4_9663_NQueen_minseo {
	
	static int n, cnt;
	static int[] arr;
	static boolean check;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		cnt = 0;
		arr = new int[n];
		check = true;
		/**
		 * arr[index] = v => index가 열, v가 행으로 생각
		 *  arr[0] = 2
		 *  arr[1] = 0
		 *  arr[2] = 3
		 *  arr[3] = 1
		 */
		
		cntQueen(0);
		sb.append(cnt);
		System.out.println(sb);

	}
	static void cntQueen(int depth) { // depth가 n과 같으면 끝
		//base
		if(depth == n) {
			cnt++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			arr[depth] = i; // 일단 퀸 놓기
			
			// 퀸 조건
			for(int j = 0; j < depth; j++) { // 같은 행 => 현재 depth열의 행과 i열의 행이 같을 경우 퀸 배치 불가능
				if(arr[depth] == arr[j]) {
					check = false; 
					break; 
				}
				else if(Math.abs(depth - j) == Math.abs(arr[depth] - arr[j])) { // 대각선 => 열의 차와 행의 차가 같을 경우
					check = false; 
					break;
				}
				
				check = true;
				
			}
			
			if(check) {
				cntQueen(depth + 1);
			}
			
			
		}
	}
		

}
