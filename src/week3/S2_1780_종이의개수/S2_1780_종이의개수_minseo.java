package week3.S2_1780_종이의개수;

/**
 * @author 강민서
 * @date 2024.02.16
 * @link https://www.acmicpc.net/problem/1780
 * @keyword_solution  종의의 수가 모두 같지 않다면 종이를 9등분으로 자르고 -1, 0, 1 의 개수 파악 => 9등분 재귀를 돌려 종이에 같은 숫자가 있을 때 까지 반복 
 * @input N(1 ≤ N ≤ 3^7, N은 3k 꼴) O(n^2) => 완전탐색 가능 
 * @output -1, 0, 1, 개수 출력 => 주의 사항 n X n의 종이의 숫자가 모두 같으면 1개로 취급 => 종이의 개수 출력
 * @time_complex O(n^2)
 * @perf 351716	1536
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S2_1780_종이의개수_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int N;
	static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
//		map으로 0 , -1, 1 담음 
		map.put(0 , 0);
		map.put(-1 , 0);
		map.put(1 , 0);
		
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0 , N);
		
		sb.append(map.get(-1) + "\n").append(map.get(0) + "\n").append(map.get(1));
		
		System.out.print(sb);
		
		
	}
	
	static void dfs(int x, int y, int size) {
		
		
		
		if(check(x, y, size)) {
			map.put(arr[x][y], map.get(arr[x][y]) + 1);  //value 값 갱신 
			return;
		}else {
			
			int division_size = size / 3;  // 3등분 => 9개로 잘라야 하기 때문에 size / 3
				
			/**
			 *9개로 자른다
			 * 1 2 3
			 * 4 5 6
			 * 7 8 9
			 */
			
//			1, 2, 3
			dfs(x, y, division_size);
			dfs(x, y + division_size, division_size);
			dfs(x, y + (division_size * 2), division_size);
			
//			4, 5, 6
			dfs(x + division_size, y, division_size);
			dfs(x + division_size, y + division_size, division_size);
			dfs(x + division_size, y + (division_size * 2), division_size);
			
//			7, 8, 9
			dfs(x + (division_size * 2), y, division_size);
			dfs(x + (division_size * 2), y + division_size, division_size);
			dfs(x + (division_size * 2), y + (division_size * 2), division_size);
		}
	}
	
//	종이에 적혀 있는 숫자가 같은 숫자인지 체크
	static boolean check(int x, int y, int size) {
		int value = arr[x][y];
		
		for(int i = x ; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(value != arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
