package week3.S1_16918_봄버맨;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class S1_16918_봄버맨_byeongju {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int row;
	static int col;
	static int time;
	
	static char[][] map;
	static int[][] bombmap;
	
	static int[]dx = {0,-1,1,0,0}; // 본인을 포함한 상하 좌우 변경
	static int[]dy = {0,0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		st= new StringTokenizer(br.readLine());
		
		row= Integer.parseInt(st.nextToken());
		col= Integer.parseInt(st.nextToken());
		time= Integer.parseInt(st.nextToken());
		
		map = new char [row][col];
		bombmap = new int [row][col];
		
		for(int r=0;r<row;r++) {
			map[r]= br.readLine().toCharArray(); 
			for(int c=0;c<col;c++) {
				if(map[r][c]=='O')
					bombmap[r][c] = 2; // 시작하고 1초까지 변경이 없고 2초부터 변경이 있길래 2로 초기화를 해버림 
			}
		}
		time%=5;
		for(int i=1;i<time;i++) { // 초기화 이후 1초는 맵의 변화가 없기 때문에 1초부터로 지정
			ChangeMap(i, new boolean[row][col]);			
			
		}
		
		for(int r=0;r<row;r++) {
			for(int c=0;c<col;c++) {
				if(bombmap[r][c]%4==0) { // 5초가 지나면 원상복귀
					sb.append('.');
				}
				else {
					sb.append('O');
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());		
	}
	
	// map을 순회하면서 변경할 함수
	public static void ChangeMap(int cnt, boolean[][] isvisited) {
		for(int r=0;r<row;r++) {
			for(int c=0;c<col;c++) {
				if(isvisited[r][c]) continue;			
				if(bombmap[r][c]!=0) { //값이 0이 아니면 근처로 폭탄을 옮기는 봄버맨
					bombmap[r][c]++;
					countMap(r, c, bombmap[r][c], isvisited); // 주위 폭탄 배달
				}
			}
		}

		for(int r=0;r<row;r++) { 
			for(int c=0;c<col;c++) {		
				if(bombmap[r][c]==0) { // 0이였던 곳은 모두 폭탄이 깔림
					bombmap[r][c]++;
				}else if(bombmap[r][c]==4) { // 폭탄이 설치된 후 3초가 지나면 펑 그래서 1+3초
					bombmap[r][c]=0;
				}
			}
		}
	}
	
	//범위에 따른 실제 값 변화 함수
	public static void countMap(int r, int c, int cnt, boolean[][] isvisited) {

		for(int i=0;i<5;i++) {
			int nx= c+dx[i];
			int ny= r+dy[i];
			
			if(nx<0 || nx>=col ||ny<0 || ny>=row ) continue;
			
			if(bombmap[ny][nx]!=0) continue;
			
			isvisited[ny][nx]=true;
		
			bombmap[ny][nx]=cnt;

		}
	}
}