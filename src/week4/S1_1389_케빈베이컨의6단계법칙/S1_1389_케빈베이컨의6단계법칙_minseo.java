package week4.S1_1389_케빈베이컨의6단계법칙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S1_1389_케빈베이컨의6단계법칙_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, result, num;
	static ArrayList<Edge>[] list;
	static PriorityQueue<Edge> q;
	static int[] dist;
	static boolean[] visited;

	static class Edge implements Comparable<Edge> {
		int vertex, value;

		public Edge(int vertex, int value) {
			this.vertex = vertex;
			this.value = value;
		}


		@Override
		public int compareTo(Edge o) {
			if (this.value > o.value)
				return 1;
			else
				return -1;
		}

	}

	public static void main(String[] args) throws IOException {

//		########################################### 입력
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		dist = new int[N + 1];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Edge>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(new Edge(b, 1));
			list[b].add(new Edge(a, 1));
		}

//		########################################### 

//		결과가 같으면 번호가 작은 순서이므로 N부터 뒤로 탐색 
		for (int i = N; i >= 1; i--) {
			Arrays.fill(dist, Integer.MAX_VALUE); // 거리 배열 초기화
			
			dijkstra(i);   // 유저마다 다익스트라 돌리기
			int sum = 0;   // 친구 수 저장
			for (int j = 1; j <= N; j++) {
				if(dist[j] != Integer.MAX_VALUE) {
					sum+= dist[j];
					
				}
			}
			
			if(result >= sum) {
				result = sum;
				num = i;
			}
			
			
		}
		
		System.out.println(num);

	}

	
	static void dijkstra(int start) {
		q = new PriorityQueue<>();
		q.offer(new Edge(start, 0));
		dist[start] = 0;

		while (!q.isEmpty()) {
			Edge cur = q.poll();

			int vertex = cur.vertex;

			for (int i = 0; i < list[vertex].size(); i++) {
				Edge next = list[vertex].get(i);
				int next_vertex = next.vertex;
				int next_value = next.value;

				if (dist[next_vertex] > dist[vertex] + next_value) {
					dist[next_vertex] = dist[vertex] + next_value;
					q.offer(new Edge(next_vertex, dist[next.vertex]));
				}
			}
		}

	}

}
