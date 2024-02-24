package week4.G3_1719_택배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G3_1719_택배_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static boolean[] visited; // 정점 방문 체크
	static PriorityQueue<Edge> q;
	static ArrayList<Edge>[] list;
	static int[][] result;
	static int[] dist;
	
	static class Edge implements Comparable<Edge> {
		int vertex, value;
		
		public Edge(int vertex, int value) {
			this.vertex = vertex;
			this.value = value;
		}
		
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		result = new int[N][N];
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Edge>();
 		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			list[start].add(new Edge(end, value));
			list[end].add(new Edge(start, value));
			
		}
		
//		1번 부터 최단거리 탐색
		for(int i = 1; i <= N; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			dijkstra(i);
		}
		
//		경로표 출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i==j) sb.append("- ");
				else {
					sb.append(result[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
		
		
	}
	
	static void dijkstra(int start) {
		q = new PriorityQueue<Edge>();
		q.offer(new Edge(start, 0));
		dist[start] = 0;
		visited = new boolean[N + 1];
		
		while(!q.isEmpty()) {
			Edge cur = q.poll();
			int vertex = cur.vertex;
			int value = cur.value;
			
			
			visited[vertex] = true;
			
			for(int i = 0; i < list[vertex].size(); i++) {
				Edge next = list[vertex].get(i);
				int next_vertex = next.vertex;
				int next_value = next.value;
				
				
					if(!visited[next_vertex] && dist[next_vertex] > dist[vertex] + next_value) {
						dist[next_vertex] = dist[vertex] + next_value;
						result[start - 1][next_vertex - 1] = vertex;
						q.offer(new Edge(next_vertex, dist[next_vertex]));
						
					}
				

			}
		}
	}

}
