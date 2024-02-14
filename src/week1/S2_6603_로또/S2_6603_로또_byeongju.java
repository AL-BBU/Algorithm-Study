package week1.S2_6603_로또;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 유병주
 * @date 2024-02-04
 * @link https://www.acmicpc.net/problem/6603
 * @keyword_solution  
 * 아래 주석 참조
 * @input
 * 숫자가 들어있는 집합 의 수 k (6 < k < 13)
 * @output  
 * 그 중 선택가능한 6개의 모든 조합 출력
 * @time_complex  
 * O(N)
 * @perf
 * 15268	164
 */

public class S2_6603_로또_byeongju {
	static int n; // 입력받을 배열의 크기
	static int []lotto; // 가능한 모든 로또 번호를 저장하기 위한 배열
	static int []answer=new int[6]; // 출력을 위해 저장될 배열
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		while(true) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			if(n==0) // 0이 입력되면 종료하는 코드
				break;
			lotto=new int[n];
			
			for(int i=0;i<n;i++) {
				lotto[i]=Integer.parseInt(st.nextToken());
			}
			dfs(0,0); // 출력배열에 저장을 위해 사용되는 index와 현재 배열에 저장된 원소의 갯수를 표현하는 dep
			// 시작 index는 0이고 아직 answer 배열에 저장된 원소가 없으므로 0,0 시작
			sb.append("\n");
		}
		System.out.println(sb.toString());// 출력이 많기 때문에 계속 print하지 않고 StringBuilder를 사용하여 한번에 출력
		br.close();
	}
	
	public static void dfs(int start,int dep) {
		if(dep==6) {// 총 6개의 숫자를 저장 후 출력해야 하기 때문에 높이가 6이면 출력
			for(int num:answer) {
				sb.append(num+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<n;i++) {
			answer[dep]=lotto[i];
			dfs(i+1,dep+1);// 번호의 중복이 없어야 하므로 시작과 원소의 수 모두 증가
		}
	}
}