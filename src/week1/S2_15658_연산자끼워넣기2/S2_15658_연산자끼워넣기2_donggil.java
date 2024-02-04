package week1.S2_15658_연산자끼워넣기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.StringTokenizer;

public class S2_15658_연산자끼워넣기2_donggil {
	/**
	 * @author 임동길
	 * @date 2024-02-04
	 * @link https://www.acmicpc.net/problem/15658
	 * @keyword_solution  
	 * 재귀를 사용한 최대값과 최소값 출력
	 * 입력값을 배열로 저장하고, 이를 4갈래로 뻗어나가는 재귀 사용으로 값을 구하기
	 * 연산자의 순서에 상관이 없으므로, 가지치기는 별다르게 생각나는 것이 없음
	 * @input
	 * 사용할 정수의 수 (배열의 크기) -> 2<=N<=11
	 * +,-,*,/ 의 사용 횟수 -> n-1<= Operation[i] <= 4n
	 * @output   
	 * N이 11, *가 4n일 경우 long의 범위도 고려해야 하지만, 해당 문제에서는 int 타입 케이스만 등장
	 * @time_complex  
	 * O(4ⁿ)
	 * @perf 
	 * 14180KB, 108ms
	 */
	static int n,m,k;
	static int[]arr;
	static int total;
    static StringTokenizer st;
    static StringBuilder sb;
    static boolean[] visited;
    static Set<Integer> set;
    static int max,min;
    static int[] arr2;
    static int head=1;
    static int tail=0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        // 사용할 정수들을 모아놓은 배열
        arr = new int[n];
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        // 사용할 연산자들을 모아놓은 배열
        arr2 = new int[4];
        for(int i=0; i<4; i++) {
        	arr2[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
        br.close();
        bw.close();
    }
    static void dfs(int depth, int sum) {
    	if(depth>=n) {
    		max = Math.max(max, sum);
    		min = Math.min(min, sum);
    		return;
    	}
    	// 만약 연산자를 1번이상 사용할 수 있다면 재귀 호출
    	for(int i=0; i<4; i++) {
    		if(arr2[i]!=0) {
    			arr2[i]--;
    			if(i==0) {
    				dfs(depth+1, sum+arr[depth]);
    			}else if(i==1) {
    				dfs(depth+1, sum-arr[depth]);
    			}else if(i==2) {
    				dfs(depth+1, sum*arr[depth]);
    			}else if(i==3) {
    				dfs(depth+1, sum/arr[depth]);
    			}
    			arr2[i]++;
    		}
    	}
    }
}