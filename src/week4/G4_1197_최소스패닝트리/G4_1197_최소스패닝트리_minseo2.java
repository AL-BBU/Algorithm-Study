package week4.G4_1197_최소스패닝트리;

/**
 * 프림
 * 1. 임의의 정점 선택 
 * 2. 그 정점과 인접한 정점을 잇는 간선 중 가중치가 가장 낮은 간선 선택
 * 3. 그 간선이 연결하는 정점 선택 그리고 반복 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_1197_최소스패닝트리_minseo2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E, result, edge;
	static boolean[] visited; // 정점 방문 체크
	static Queue<Edge> q = new PriorityQueue<Edge>();
	static ArrayList<Edge>[] list;

//	인접리스트
	static class Edge implements Comparable<Edge> {
		int vertex;
		int value;

		public Edge(int vertex, int value) {
			this.vertex = vertex;
			this.value = value;
		}

//		가중치 오름차순 
		public int compareTo(Edge o) {

			return this.value - o.value;
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[V + 1];
		visited = new boolean[V + 1];

		for (int i = 0; i < V + 1; i++) {
			list[i] = new ArrayList<Edge>();
		}


//		인접리스트 구현 
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			list[start].add(new Edge(end, value));
			list[end].add(new Edge(start, value));
		}

//		1. 임의의 정점 선택 
		q.offer(new Edge(1, 0));

		result = 0;
//		2. 그 정점과 인접한 정점을 잇는 간선 중 가중치가 가장 낮은 간선 선택 => 큐를 활용하여 구현 
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			int vertex = cur.vertex;
			int value = cur.value;

			if (visited[vertex])
				continue;
			visited[vertex] = true;
			result += value;


			for (int i = 0; i < list[vertex].size(); i++) {
				Edge next = list[vertex].get(i);
//				3. 그 간선이 연결하는 정점 선택 그리고 반복 
				if (!visited[next.vertex]) {
					q.offer(next);
				}
			}

		}

		sb.append(result);
		System.out.println(sb);

	}

}
