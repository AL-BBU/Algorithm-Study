package week1.S2_6603_로또;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.StringTokenizer;

public class S2_6603_로또_donggil {
	/**
	 * @author 임동길
	 * @date 2024-02-04
	 * @link https://www.acmicpc.net/problem/6603
	 * @keyword_solution  
	 * 조합 방식 사용
	 * 재귀가 시작할 때, depth 뿐만 아니라 시작지점을 매개변수로 사용하여 조합을 완성시킨 후 출력
	 * @input
	 * 0이 입력되면 반복문 종료
	 * 6<k<13
	 * @output   
	 * 조합으로 만들어낸 수를 출력
	 * @time_complex  
	 * O(N)
	 * @perf 
	 * 17240KB, 240ms
	 */
	static int n,m,k;
	static int[]arr;
	static int total;
    static StringTokenizer st;
    static StringBuilder sb;
    static boolean[] visited;
    static Set<Integer> set;
    static int[] arr2;
    static int head=1;
    static int tail=0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
        	st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            if(n==0)break;
            arr = new int[n];
            for(int i=0; i<n; i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            arr2 = new int[6];
            visited = new boolean[n];
            dfs(0,0);
            System.out.println();
        }
        br.close();
        bw.close();
    }
    // 매개변수에 배열의 깊이인 depth 분 아니라 조합을 만들기위한 start변수까지 사용하여 조합방식을 사용할 것
    static void dfs(int depth, int start) {
    	if(depth==6) {
    		for(int i : arr2) {
    			System.out.print(i+" ");
    		}
    		System.out.println();
    		return;
    	}
    	// 반복문의 시작은 매개변수인 start를 사용
    	for(int i=start; i<n; i++) {
    		arr2[depth] = arr[i];
    		// 다음 재귀는 이번 숫자의 +1을 사용하기 때문에 매개변수 start자리에 (i+1)을 삽입
    		dfs(depth+1, i+1);
    	}
    }
}
