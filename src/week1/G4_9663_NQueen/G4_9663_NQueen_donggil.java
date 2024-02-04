package week1.G4_9663_NQueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G4_9663_NQueen_donggil {
	/**
	 * @author 임동길
	 * @date 2024-02-04
	 * @link https://www.acmicpc.net/problem/9663
	 * @keyword_solution  
	 * 2차원 배열이 아닌 1차원 배열을 통한 백트래킹 기법
	 * Queen은 상,하,좌,우, 4방향 대각선으로 8방 이동이 가능함
	 * 1차원 배열의 깊이를 2차원 배열의 Column으로 취급 -> Array {0, 1, 2, 3}이 있다면, arr[0]은 0번열, arr[1]은 1번열
	 * 1차원 배열의 깊이에 저장된 값은 2차원 배열의 Row로 취급 -> arr[0] = 1이라면 (1,0)의 좌표, arr[1] = 2라면 (2,1)의 좌표
	 * col - i
	 * @input
	 * 1<= N <= 15 
	 * @output   
	 * 체스판에 놓을 수 있는 경우의 수
	 * @time_complex  
	 * @perf 
	 * 12140KB, 5380ms
	 */
	static int n,m,k;
    static StringTokenizer st;
    static int[]arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int max;
    static boolean[][] visited;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력값 인 정수형 변수 N  - 1<=N<=15
        n = Integer.parseInt(br.readLine());
        // 2차원 배열로 8방탐색을 들어가면 시간초과가 나온다.
        // 문제의 제한시간이 10초이지만, 최악인 15x15 2차원 배열에서 모든 경우의 수를 8방 탐색하면 시간초과
        // 따라서 1차원 배열을 생성하여 진행
        arr = new int[n];
        max=0; // n*n 크기의 배열에서 n개의 퀸을 모두 놓을 수 있는 경우의 수(출력값)
        dfs(0);
        System.out.println(max);
    }
    static void dfs(int depth) {
    	if(depth>=n) {
    		// 만약 재귀가 2차원 배열의 끝인 n-1을 넘어섰다면 경우의수 +1
    		max++;
    		return;
    	}
    	// n의 크기만큼 반복을 진행하여 depth(열의 번호)와 i(행의 번호)를 1차원 배열에 저장하여 검증 실시
    	for(int i=0; i<n; i++) {
    		arr[depth]=i+1;
    		if(check(depth)) {
    			dfs(depth+1);
    		}
    	}
    }
    static boolean check(int col) {
    	for(int i=0; i<col; i++) {
    		// col 값으로 넘어온 것은 depth로 2차원 배열로 취급했을 때의 Column임
    		// 만약 col이 1, arr[col]의 값이 1이라면 2번열의 1번행인 (1,1)가 됨.
    		// 이 때, depth만큼 반복을 진행하여 i가 0, arr[i]가 1이라면 (0,1)과 (1,1)은 하나의 열에 같이 존재하게 되는 것으로 동시에 놓을 수 없음
    		if(arr[col]==arr[i]) {
    			return false;
    		}
    		// Column-i의 값이 arr[col]-arr[i]와 같다면 대각선상에 위치하는 것으로 불가능
    		// 현재 (1,0)에 퀸이 존재하고, (2,1)에 퀸이 존재한다면 col-i값과 arr[col]-arr[i]값이 같아 대각선 취급
    		if(col-i == Math.abs(arr[col]-arr[i]))return false;
    	}
    	return true;
    }
}
