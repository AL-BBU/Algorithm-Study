package week3.S1_16918_봄버맨;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class S1_16918_봄버맨_donggil {
	static int n, m, k;
	static char[][] arr;
	static int total;
	static StringTokenizer st;
	static StringBuilder sb;
	static int max, min;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] timer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		timer = new int[n][m];
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			Arrays.fill(timer[i], -1);
			for (int j = 0; j < m; j++) {
				arr[i][j] = tmp.charAt(j);
				timer[i][j] = 0;
			}
		}
		if(k%2==0) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					System.out.print("O");
				}
				System.out.println();
			}
			return;
		}
		
		int time = 1;
		while(time<k) {
			time++;
			if(time%2==0) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<m; j++) {
						if(arr[i][j] == '.' ) {
							arr[i][j] = 'O';
							timer[i][j] = time; 
						}
					}
				}
			}
			else {
				for(int i=0; i<n; i++) {
					for(int j=0; j<m; j++) {
						if(timer[i][j] == time-3 ) {
							timer[i][j] = -1;
							arr[i][j] = '.'; 
							for(int k=0; k<4; k++) {
								int nextX = i+dx[k];
								int nextY = j+dy[k];
								if(!rangeCheck(nextX, nextY))continue;
								if(timer[nextX][nextY]== time-3)continue;
								if(arr[nextX][nextY] == 'O' ) {
									arr[nextX][nextY] = '.';
									timer[nextX][nextY] = -1; 
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		br.close();
		bw.close();
	}

	static boolean rangeCheck(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < m)
			return true;
		return false;
	}
}