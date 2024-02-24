package week4.G4_16398_행성연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_16398_행성연결_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static long result;
	static PriorityQueue<Edge> q;
	static int[] parent, rank;


	static class Edge implements Comparable<Edge> {
		int start, end, value;

		public Edge(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}
		
		public int compareTo(Edge o) {
			return this.value - o.value;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", value=" + value + "]";
		}
		
		
	}

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());
		q = new PriorityQueue<>();
		parent = new int[N + 1];
		rank = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			parent[i] = i;
			for (int j = 1; j <= N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value == 0) continue;
				
				q.add(new Edge(i, j, value));

			}
		}
		int cnt = 0;
		result = 0;
		
		while(cnt < N - 1) {
			
			Edge cur = q.poll();
			
			if(find(cur.start) != find(cur.end)) {
				union(cur.start, cur.end);
				result += cur.value;
				cnt++;
			}
			
			
			
		}
		
		System.out.println(result);
		
		

	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		
		if(rank[x] > rank[y]) {
			parent[y] = x;
		}
		else if(rank[y] > rank[x]) {
			parent[x] = y;
		}
		else {
			parent[y] = x;
			rank[x]++;
		}
		
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		
		return parent[x] = find(parent[x]);
	}

}
