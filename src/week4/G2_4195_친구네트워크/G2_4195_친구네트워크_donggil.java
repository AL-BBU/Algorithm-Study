package week4.G2_4195_친구네트워크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class G2_4195_친구네트워크_donggil {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] arr;
	static int[] arr2;
	static int direction;
	static int n, m, k;
	static StringTokenizer st;
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> house;
	static int min;
	static boolean[][] visited;
	static int[] inDgree;
	static StringBuilder sb;
	static int[] parent;
	static Map<String, Integer>map;

	public static void main(String[] args) throws Exception {
		// 여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int tc = 0; tc<T; tc++) {
			map = new HashMap<String, Integer>();
			int mapIndex = 0;
			n = Integer.parseInt(br.readLine());
			String[] inputArr = new String[n];
			
			for(int i=0; i<n; i++) {
				inputArr[i] = br.readLine(); 
				st = new StringTokenizer(inputArr[i], " ");
				String first = st.nextToken();
				String second = st.nextToken();
				if(!map.containsKey(first)) {
					map.put(first, mapIndex++);
				}
				if(!map.containsKey(second)) {
					map.put(second, mapIndex++);
				}
			}
			parent = new int[mapIndex];
			for(int i=0; i<parent.length; i++) {
				parent[i] = -1; 
			}
			for(int i=0; i<inputArr.length; i++) {
				st = new StringTokenizer(inputArr[i], " ");
				String first = st.nextToken();
				String second = st.nextToken();
				union(map.get(first), map.get(second));
				int index = find(map.get(first));
				sb.append(-(parent[index])).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
	static int find(int x) {
		if(parent[x] < 0) {
			return x;
		}else {
			return parent[x] = find(parent[x]); 
		}
	}
	static void union(int x,int y) {
		x = find(x);
		y = find(y);
		if(x==y) {
			return;
		}
		if(x>y) {
			parent[y] += parent[x];
			parent[x] = y;
		}
		else {
			parent[x] += parent[y];
			parent[y] = x; 
		}
	}
}