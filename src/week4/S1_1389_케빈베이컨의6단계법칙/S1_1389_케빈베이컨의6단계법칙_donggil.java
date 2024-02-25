package week4.S1_1389_케빈베이컨의6단계법칙;

import java.io.*;
import java.util.*;

public class S1_1389_케빈베이컨의6단계법칙_donggil {

	static int n, m;
	static int[] memo;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		memo = new int[n+1];
		
		int[][] floyd = new int[n+1][n+1];
		
		// 초기화 
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i==j) floyd[i][j] = 0;
				else floyd[i][j] = 99999999;
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			floyd[a][b] =1;
			floyd[b][a] =1;
		}
		
		
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(floyd[i][j] > floyd[i][k] + floyd[k][j]) {
						floyd[i][j] = floyd[i][k] + floyd[k][j];
					}
				}
				
			}
			
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				memo[i] += floyd[i][j];
			}
		}
		
		int min = Integer.MAX_VALUE;
		int idx =0;
		for(int i=1; i<n+1; i++) {
			if(min > memo[i]) {
				min = memo[i];
				idx =i;
			}
		}
		System.out.println(idx);
	}
}