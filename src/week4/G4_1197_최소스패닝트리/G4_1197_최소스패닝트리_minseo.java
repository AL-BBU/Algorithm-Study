package week4.G4_1197_최소스패닝트리;

/**
 * 크루스칼
 * 1. 에지리스트로 구현하고 유니온 파인트 배열 초기화
 * 2. 가중치 기준으로 오름차순 정렬
 * 3. 가중치가 가장 낮은 에지부터 연결 시도 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_1197_최소스패닝트리_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E, result, edge;
	static int[] parent;
	static boolean[] visited;
	static Queue<Edge> q = new PriorityQueue<Edge>();

//	에지리스트
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int value;

		public Edge(int start, int end, int value) {
			this.start = start;
			this.end = end;
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
		parent = new int[V + 1];

//		1. 에지리스트로 구현하고 유니온 파인트 배열 초기화
		for (int i = 0; i < V + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			// 2. 가중치 기준으로 오름차순 정렬 => comparable 사용하고 우선순위 큐에 담으면 자동 정렬
			q.add(new Edge(start, end, value));
		}
		


//		MST를 만족하기 위해서는 에지 수가 최대 V - 1개
//		!queue.isEmpty()로 해도 됨
		while (edge < V - 1) {
			Edge cur = q.poll();

//		    3. 가중치가 가장 낮은 에지부터 연결 시도 => 대표노드가 서로 다를 경우! , 만약 같다면 사이클이 형성됨 
			if (find(cur.start) != find(cur.end)) {
				union(cur.start, cur.end);
				result += cur.value;
				edge++;
			}
		}

		sb.append(result);
		System.out.println(sb);

	}

//	union 연산 
	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y) {
			parent[y] = x;
		}else {
			parent[x] = y;
		}
	}

//	find 연산 => 사이클 여부 확인
	static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

}
